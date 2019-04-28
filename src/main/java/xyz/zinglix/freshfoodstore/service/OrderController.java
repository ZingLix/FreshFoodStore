package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.InventoryRepository;
import xyz.zinglix.freshfoodstore.model.Inventory;
import xyz.zinglix.freshfoodstore.util.BadRequestException;
import xyz.zinglix.freshfoodstore.util.OrderUtil;
import xyz.zinglix.freshfoodstore.util.Response;
import xyz.zinglix.freshfoodstore.view.OrderItem;

import java.util.ArrayList;
import java.util.List;

class OrderRequest{
    Long id;
    List<OrderItem> order;
    String realname;
    String address;
    String phone;

    public OrderRequest() {
        order=new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getOrder() {
        return order;
    }

    public void setOrder(List<OrderItem> order) {
        this.order = order;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

@RestController
public class OrderController {
@Autowired
    InventoryRepository inv;


    @PostMapping("/api/order/{seller_id}")
    @CrossOrigin
    Response placeOrder(@PathVariable Long seller_id, @RequestBody OrderRequest orderRequest){
        OrderUtil helper=new OrderUtil();
        List<Pair<Inventory,Long>> invlist=new ArrayList<>();
        for(var o:orderRequest.getOrder()){
            var i = inv.findById(o.getId());
            if(!i.isPresent()) throw new BadRequestException("Inventory "+o.getId()+" doesn't exist.");
            invlist.add(Pair.of(i.get(),o.getCount()));
        }
        OrderUtil.createOrder(orderRequest.getId(),seller_id,invlist,orderRequest.getAddress(),orderRequest.getPhone(),orderRequest.getRealname());
        return new Response("success");
    }
}
