package xyz.zinglix.freshfoodstore.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import xyz.zinglix.freshfoodstore.dao.DeliveryRepository;
import xyz.zinglix.freshfoodstore.dao.OrderProductsRepository;
import xyz.zinglix.freshfoodstore.dao.OrderRepository;
import xyz.zinglix.freshfoodstore.model.*;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Component
public class OrderHelper {
    @Autowired
    OrderRepository order;

    @Autowired
    OrderProductsRepository orderProducts;

    @Autowired
    DeliveryRepository delivery;

    public static OrderHelper h;

    public OrderHelper() {
    }

    @PostConstruct
    public void init() {
        h = this;
        h.order = this.order;
        h.orderProducts=this.orderProducts;
        h.delivery=this.delivery;
    }


    public void createOrder(Long buyerId, Long sellerId, List<Pair<Inventory,Long>> products, String address, String phone){
        Orders o=new Orders();
        o.setBuyerId(buyerId);
        o.setSellerId(sellerId);
        o.setStatus(0);
        o.setTime(new Date());
        o.setAddress(address);
        o.setPhone(phone);
        o.setTotalPrice(0L);
        o=h.order.save(o);
        Long totalPrice=0L;
        for(var p:products){
            totalPrice+=p.getSecond()*p.getFirst().getPrice();
            OrderProducts op=new OrderProducts();
            op.setOrderId(o.getId());
            op.setProductId(p.getFirst().getProduct_id());
            op.setPrice(p.getFirst().getPrice());
            op.setCount(p.getSecond());
            h.orderProducts.save(op);
        }
        o.setTotalPrice(totalPrice);
        o.setStatus(1);
        h.order.save(o);
    }
}
