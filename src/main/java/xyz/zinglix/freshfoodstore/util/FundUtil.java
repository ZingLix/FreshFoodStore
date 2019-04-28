package xyz.zinglix.freshfoodstore.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.zinglix.freshfoodstore.dao.FundLogRepository;
import xyz.zinglix.freshfoodstore.dao.FundRepository;
import xyz.zinglix.freshfoodstore.model.Fund;
import xyz.zinglix.freshfoodstore.model.FundLog;

import javax.annotation.PostConstruct;
import java.util.Date;
@Component
public class FundUtil {

    @Autowired
    FundRepository fundRepository;

    @Autowired
    FundLogRepository fundLogRepository;

    public static FundUtil h;

    @PostConstruct
    public void init() {
        h = this;
        h.fundRepository=this.fundRepository;
        h.fundLogRepository=this.fundLogRepository;
    }

    public static void topup(Long user_id,Long count){
        modifyFund(user_id,1,1,count,"用户充值",0L);
    }

    public static void withdraw(Long user_id,Long count){
        modifyFund(user_id,2,1,count,"用户提现",0L);
    }

    public static void placeOrder(Long user_id,Long count,Long order_id){
        modifyFund(user_id,2,2,count,"下达订单",order_id);
    }

    public static void finishOrder(Long user_id,Long count,Long order_id){
        modifyFund(user_id,1,2,count,"订单完成",order_id);
    }

    static void modifyFund(Long user_id,Integer type,Integer reason,Long count,String msg,Long order_id){
        var f = h.fundRepository.findById(user_id);
        if(!f.isPresent()) throw new BadRequestException("User " + user_id+" doesn't exist.");
        var fund=f.get();
        switch (type){
            case 1:
                fund.setCount(fund.getCount()+count);
                break;
            case 2:
                if(fund.getCount()<count) throw new BadRequestException("余额不足");
                fund.setCount(fund.getCount()-count);
                break;
                default:
                    throw new BadRequestException("Unknown operation.");
        }
        FundLog log=new FundLog();
        log.setCount(count);
        log.setMsg(msg);
        log.setOrder_id(order_id);
        log.setReason(reason);
        log.setType(type);
        log.setUser_id(user_id);
        log.setTime(new Date());
        h.fundLogRepository.save(log);
    }
}
