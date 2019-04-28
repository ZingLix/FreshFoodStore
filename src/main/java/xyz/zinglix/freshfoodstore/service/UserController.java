package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.FundRepository;
import xyz.zinglix.freshfoodstore.dao.UserInfoRepository;
import xyz.zinglix.freshfoodstore.dao.UserRepository;
import xyz.zinglix.freshfoodstore.model.Fund;
import xyz.zinglix.freshfoodstore.model.User;
import xyz.zinglix.freshfoodstore.model.UserInfo;
import xyz.zinglix.freshfoodstore.util.BadRequestException;
import xyz.zinglix.freshfoodstore.util.OrderUtil;
import xyz.zinglix.freshfoodstore.util.Request;
import xyz.zinglix.freshfoodstore.util.Response;
import xyz.zinglix.freshfoodstore.view.OrderDetail;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository user;
    @Autowired
    private UserInfoRepository userinfo;
    @Autowired
    private FundRepository fund;

    @PostMapping("/api/user")
    @CrossOrigin
    Response registerUser(@RequestBody User u){
        u.setType(1);
        var check=user.findAllByUsername(u.getUsername());
        if(check.isPresent()) throw new BadRequestException("用户名已存在！");
        u = user.save(u);
        UserInfo info=new UserInfo(u.getId());
        info.setNickname(u.getUsername());
        userinfo.save(info);
        Fund f=new Fund();
        f.setId(u.getId());
        f.setCount(0L);
        fund.save(f);
        return new Response("注册成功！");
    }

    @PostMapping("/api/user/login")
    @CrossOrigin
    User login(@RequestBody User u){
        var correctUser=user.findAllByUsername(u.getUsername());
        if(!correctUser.isPresent()) throw new BadRequestException("用户不存在");
        var cu=correctUser.get();
        if(!cu.getPassword().equals(u.getPassword()))
            throw new BadRequestException("用户名或密码错误");
        cu.setPassword(null);
        return cu;
    }

    @GetMapping("/api/user/{id}/info")
    @CrossOrigin
    UserInfo getUserInfo(@PathVariable Long id){
        var info=userinfo.findById(id);
        if(!info.isPresent()) throw new BadRequestException("用户不存在，id:"+id);
        return info.get();
    }
    @PostMapping("/api/user/{id}/info")
    @CrossOrigin
    UserInfo modifyUserInfo(@PathVariable Long id, @RequestBody UserInfo info){
        var originalInfo=userinfo.findById(id);
        if(!originalInfo.isPresent()) throw new BadRequestException("用户不存在，id: "+id);
        var ori=originalInfo.get();
        ori.setNickname(info.getNickname());
        ori.setAddress(info.getAddress());
        ori.setPhone(info.getPhone());
        ori.setEmail(info.getEmail());
        ori.setRealname(info.getRealname());
        userinfo.save(ori);
        return ori;
    }

    @GetMapping("/api/user/{id}/order")
    @CrossOrigin
    List<OrderDetail> getOrders(@PathVariable Long id){
        return OrderUtil.getOrderForBuyer(id);
    }

    @PostMapping("/api/user/{id}/order/{order_id}")
    @CrossOrigin
    Response getOrders(@PathVariable Long id, @PathVariable Long order_id, @RequestBody Request req){
        switch (req.getOperation()){
            case 1: //确认收货
                OrderUtil.modifyOrderStatus(order_id,4,"买家确认收货");
                break;
                default:throw new BadRequestException("Unknown operation");
        }

        return new Response("success");
    }
}
