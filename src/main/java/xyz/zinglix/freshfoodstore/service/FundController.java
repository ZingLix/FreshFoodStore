package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.FundRepository;
import xyz.zinglix.freshfoodstore.model.Fund;
import xyz.zinglix.freshfoodstore.util.BadRequestException;
import xyz.zinglix.freshfoodstore.util.FundUtil;
import xyz.zinglix.freshfoodstore.util.Response;

class FundRequest{
    Long userId;
    Integer operation;
    Long count;

    public FundRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}

@RestController
public class FundController {
    @Autowired
    FundRepository fund;

    @GetMapping("/api/fund/{id}")
    Fund getFund(@PathVariable Long id){
        var f =fund.findById(id);
        if(!f.isPresent()) throw new BadRequestException("User "+id+" fund doesn't exist.");
        return f.get();
    }

    @PostMapping("/api/fund/{id}")
    Response modifyFund(@PathVariable Long id, @RequestBody FundRequest fundRequest){
        switch (fundRequest.operation){
            case 1:
                FundUtil.topup(fundRequest.getUserId(),fundRequest.getCount());
                break;
            case 2:
                FundUtil.withdraw(fundRequest.getUserId(),fundRequest.getCount());
                break;
                default:
                    throw new BadRequestException("Unknown operation.");
        }
        return new Response("充值成功！");
    }
}
