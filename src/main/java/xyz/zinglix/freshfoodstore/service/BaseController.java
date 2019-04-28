package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.*;
import xyz.zinglix.freshfoodstore.model.BaseInventory;
import xyz.zinglix.freshfoodstore.model.Inventory;
import xyz.zinglix.freshfoodstore.model.Product;
import xyz.zinglix.freshfoodstore.util.*;
import xyz.zinglix.freshfoodstore.view.BaseInventoryItem;
import xyz.zinglix.freshfoodstore.view.OrderDetail;

import java.util.Date;
import java.util.List;

@RestController
public class BaseController {
    @Autowired
    private BaseInventoryRepository inv;
    @Autowired
    private ProductRepository product;
    @Autowired
    private OrderProductsRepository orderproducts;
    @Autowired
    private UserRepository user;
    @Autowired
    private OrderRepository order;
    @Autowired
    private UserInfoRepository userinfo;
    @Autowired
    private InventoryRepository inventory;
    @Autowired
    private DeliveryRepository delivery;


    @GetMapping("/api/base/inventory")
    @CrossOrigin
    List<BaseInventoryItem> getInventory(){
        return inv.findAllWithProductInfo();
    }

    @PostMapping("/api/base/inventory")
    @CrossOrigin
    BaseInventoryItem addInventory(@RequestBody BaseInventoryItem i){
        Product p=new Product(i.getName(),i.getUnit(),i.getCategory_id(),i.getImg());
        BaseInventory b=new BaseInventory(p.getId(), i.getCount(),i.getPrice());
        p= product.save(p);
        b.setId(p.getId());
        b= inv.save(b);
        return new BaseInventoryItem(b,p);
    }

    @PutMapping("/api/base/inventory/{id}")
    @CrossOrigin
    BaseInventoryItem setInventory(@RequestBody BaseInventoryItem i,@PathVariable Long id){
        var oldb=inv.findById(id);
        if(!oldb.isPresent()) throw new ResourceNotFoundException("inventory id"+id+" doesn't exist.");
        Product p=new Product(id,i.getName(),i.getUnit(),i.getCategory_id(),i.getImg());
        p= product.save(p);
        var newb=oldb.get();
        newb.setCount(i.getCount());
        newb.setPrice(i.getPrice());
        newb= inv.save(newb);
        return new BaseInventoryItem(newb,p);
    }

    @GetMapping("/api/base/orders")
    @CrossOrigin
    List<OrderDetail> getOrders(){
        var u=user.findAllByType(3);
        if(u.size()==0) throw new BadRequestException("Unknown error.");
        var baseid=u.get(0).getId();
        OrderUtil helper=new OrderUtil();
        return helper.getOrderForSeller(baseid);
    }

    @PostMapping("/api/base/orders/{id}")
    @CrossOrigin
    Response commitOrder(@RequestBody Request r,@PathVariable Long id){
        switch (r.getOperation()){
            case 1: //交付
                var o=order.findById(id);
                var or=o.get();
                or.setStatus(4);
                order.save(or);
                FundUtil.finishOrder(or.getSellerId(),or.getTotalPrice(),or.getId());
                var products=orderproducts.findAllByOrderId(or.getId());
                for(var p:products){
                    Inventory inv=new Inventory();
                    inv.setProductId(p.getProductId());
                    inv.setPrice(0L);
                    inv.setCount(p.getCount());
                    inv.setTime(new Date());
                    inv.setSellerId(or.getBuyerId());
                    inventory.save(inv);
                }
                break;
            default:
                throw new BadRequestException("未知操作！");
        }
        return new Response("success");
    }
}
