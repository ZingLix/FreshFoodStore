package xyz.zinglix.freshfoodstore.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import xyz.zinglix.freshfoodstore.dao.DeliveryRepository;
import xyz.zinglix.freshfoodstore.dao.OrderProductsRepository;
import xyz.zinglix.freshfoodstore.dao.OrderRepository;
import xyz.zinglix.freshfoodstore.model.*;

import java.util.Date;
import java.util.List;

public class Order {
    @Autowired
    static OrderRepository order;

    @Autowired
    static OrderProductsRepository orderProducts;

    @Autowired
    static DeliveryRepository delivery;

    static void createOrder(Long buyerId, Long sellerId, List<Pair<Inventory,Long>> products, String address, String phone){
        Orders o=new Orders();
        o.setBuyer_id(buyerId);
        o.setSeller_id(sellerId);
        o.setStatus(0);
        o.setTime(new Date());
        o.setAddress(address);
        o.setPhone(phone);
        o.setTotal_price(0L);
        o=order.save(o);
        Long totalPrice=0L;
        for(var p:products){
            totalPrice+=p.getSecond()*p.getFirst().getPrice();
            OrderProducts op=new OrderProducts();
            op.setOrder_id(o.getId());
            op.setProduct_id(p.getFirst().getProduct_id());
            op.setPrice(p.getFirst().getPrice());
            op.setCount(p.getFirst().getCount());
            orderProducts.save(op);
        }
        o.setTotal_price(totalPrice);
        o.setStatus(1);
        order.save(o);
    }
}
