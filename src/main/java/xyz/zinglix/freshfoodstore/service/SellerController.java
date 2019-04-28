package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.*;
import xyz.zinglix.freshfoodstore.model.Inventory;
import xyz.zinglix.freshfoodstore.util.BadRequestException;
import xyz.zinglix.freshfoodstore.util.OrderUtil;
import xyz.zinglix.freshfoodstore.util.Request;
import xyz.zinglix.freshfoodstore.view.InventoryItem;
import xyz.zinglix.freshfoodstore.view.OrderDetail;
import xyz.zinglix.freshfoodstore.view.OrderItem;
import xyz.zinglix.freshfoodstore.util.Response;
import xyz.zinglix.freshfoodstore.view.BaseInventoryItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SellerController {
    @Autowired
    private BaseInventoryRepository base;

    @GetMapping("/api/seller/baseProducts")
    @CrossOrigin
    List<BaseInventoryItem> getBaseProducts(){
        return base.findAllWithProductInfo();
    }

    @Autowired
    private BaseInventoryRepository baseinv;
    @Autowired
    private UserRepository user;
    @Autowired
    private UserInfoRepository userinfo;

    @PostMapping("/api/seller/{id}/products")
    @CrossOrigin
    Response placeOrder(@RequestBody List<OrderItem> products, @PathVariable Long id){
        List<Pair<Inventory,Long>> list=new ArrayList<>();
        for(var p:products ){
            var productinfores=baseinv.findById(p.getId());
            if(!productinfores.isPresent())throw new BadRequestException("商品不存在,id: "+p.getId());
            var productinfo=productinfores.get();
            Inventory inv=new Inventory();
            inv.setPrice(productinfo.getPrice());
            inv.setProductId(p.getId());
            list.add(Pair.of(inv,p.getCount()));
        }
        var base=user.findAllByType(3);
        if(base.size()==0) throw new BadRequestException("Unknown error.");
        var baseid=base.get(0).getId();
        var sellerinfo=userinfo.findById(id).get();
        var helper=new OrderUtil();
        helper.createOrder(id,baseid,list,sellerinfo.getAddress(),sellerinfo.getPhone(),sellerinfo.getRealname());
        return new Response("success");
    }

    @Autowired
    private InventoryRepository inventory;
    @Autowired
    private ProductRepository product;

    @GetMapping("/api/seller/{id}/inventory")
    @CrossOrigin
    List<InventoryItem> getInventory(@PathVariable Long id){
        var invlist=inventory.findAllBySellerId(id);
        Map<Long,InventoryItem> m=new HashMap<>();
        for(var i:invlist){
            var productId=i.getProductId();
            if(!m.containsKey(productId)){
                m.put(productId,new InventoryItem(productId,product.findById(productId).get()));
            }
            m.get(productId).add(i);
        }
        List<InventoryItem> list=new ArrayList<>();
        for(var inv:m.values()){
            list.add(inv);
        }
        return list;
    }

    @PostMapping("/api/seller/{seller_id}/inventory/{id}")
    @CrossOrigin
    Inventory setInventory(@PathVariable Long seller_id,@PathVariable Long id,@RequestBody Inventory inv){
        inv.setId(id);
        inventory.save(inv);
        return inv;
    }

    @GetMapping("/api/seller/{seller_id}/stock")
    @CrossOrigin
    List<OrderDetail> getStockList(@PathVariable Long seller_id){
        return OrderUtil.getOrderForBuyer(seller_id);
    }

    @GetMapping("/api/seller/{seller_id}/order")
    @CrossOrigin
    List<OrderDetail> getOrderList(@PathVariable Long seller_id){
        return OrderUtil.getOrderForSeller(seller_id);
    }

    @PostMapping("/api/seller/{seller_id}/order/{order_id}")
    @CrossOrigin
    Response getOrderList(@PathVariable Long seller_id, @PathVariable Long order_id, @RequestBody Request request){
        switch (request.getOperation()){
            case 1: //发货
                OrderUtil.modifyOrderStatus(order_id,3,"卖家发货");
                break;
            case 2: //更新物流信息
                OrderUtil.modifyOrderStatus(order_id,3,request.getMessage());
                break;
                default:
                    throw new BadRequestException("Unknown operation!");
        }
        return new Response("success");
    }
}
