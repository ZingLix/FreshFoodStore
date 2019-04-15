package xyz.zinglix.freshfoodstore.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import xyz.zinglix.freshfoodstore.dao.*;
import xyz.zinglix.freshfoodstore.model.*;
import xyz.zinglix.freshfoodstore.view.OrderDetail;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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

    @Autowired
    UserInfoRepository userinfo;

    @Autowired
    ProductRepository product;

    public static OrderHelper h;

    public OrderHelper() {
    }

    @PostConstruct
    public void init() {
        h = this;
        h.order = this.order;
        h.orderProducts=this.orderProducts;
        h.delivery=this.delivery;
        h.userinfo=this.userinfo;
        h.product=this.product;
    }


    public static void createOrder(Long buyerId, Long sellerId, List<Pair<Inventory,Long>> products, String address, String phone, String realname){
        Orders o=new Orders();
        o.setBuyerId(buyerId);
        o.setSellerId(sellerId);
        o.setStatus(0);
        o.setTime(new Date());
        o.setAddress(address);
        o.setPhone(phone);
        o.setRealname(realname);
        o.setTotalPrice(0L);
        o=h.order.save(o);
        Long totalPrice=0L;
        for(var p:products){
            totalPrice+=p.getSecond()*p.getFirst().getPrice();
            OrderProducts op=new OrderProducts();
            op.setOrderId(o.getId());
            op.setProductId(p.getFirst().getProductId());
            op.setPrice(p.getFirst().getPrice());
            op.setCount(p.getSecond());
            h.orderProducts.save(op);
        }
        o.setTotalPrice(totalPrice);
        o.setStatus(2);
        h.order.save(o);
    }

    public static List<OrderDetail> getOrderForBuyer(Long buyerId){
        var orders=h.order.findAllByBuyerId(buyerId);
        return handleOrders(orders);
    }

    public static List<OrderDetail> getOrderForSeller(Long sellerId){
        var orders=h.order.findAllBySellerId(sellerId);
        return handleOrders(orders);
    }

    private static List<OrderDetail> handleOrders(List<Orders> orders){
        List<OrderDetail> list=new ArrayList<>();
        for(var o:orders){
            OrderDetail d=new OrderDetail();
            d.setByOrder(o);
            var seller=h.userinfo.findById(o.getSellerId());
            d.setSeller_info(seller.get());
            var buyer=h.userinfo.findById(o.getBuyerId());
            d.setBuyer_info(buyer.get());
            var products=h.orderProducts.findAllByOrderId(o.getId());
            for(var item:products){
                var p=h.product.findById(item.getProductId());
                d.addItem(p.get(),item.getCount(),item.getPrice());
            }
            var deliveryinfo=h.delivery.findAllByOrderId(o.getId());
            d.setDelivery_info(deliveryinfo);
            list.add(d);
        }
        return list;
    }

    public static void modifyOrderStatus(Long order_id,Integer newStatus,String msg){
        var o=h.order.findById(order_id);
        if(!o.isPresent()) throw new BadRequestException("order "+order_id+" doesn't exist.");
        var targetOrder=o.get();
        targetOrder.setStatus(newStatus);
        h.order.save(targetOrder);
        Delivery d=new Delivery();
        d.setTime(new Date());
        d.setStatus(newStatus);
        d.setInfo(msg);
        d.setOrderId(targetOrder.getId());
        h.delivery.save(d);
    }
}
