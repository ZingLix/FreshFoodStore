package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.BaseInventoryRepository;
import xyz.zinglix.freshfoodstore.dao.ProductRepository;
import xyz.zinglix.freshfoodstore.dao.UserInfoRepository;
import xyz.zinglix.freshfoodstore.dao.UserRepository;
import xyz.zinglix.freshfoodstore.model.BaseInventory;
import xyz.zinglix.freshfoodstore.model.Inventory;
import xyz.zinglix.freshfoodstore.model.Product;
import xyz.zinglix.freshfoodstore.util.BadRequestException;
import xyz.zinglix.freshfoodstore.util.OrderHelper;
import xyz.zinglix.freshfoodstore.util.OrderHelper;
import xyz.zinglix.freshfoodstore.view.OrderItem;
import xyz.zinglix.freshfoodstore.util.Response;
import xyz.zinglix.freshfoodstore.view.BaseInventoryItem;

import java.util.ArrayList;
import java.util.List;

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
            inv.setProduct_id(p.getId());
            list.add(Pair.of(inv,p.getCount()));
        }
        var base=user.findAllByType(3);
        if(base.size()==0) throw new BadRequestException("Unknown error.");
        var baseid=base.get(0).getId();
        var sellerinfo=userinfo.findById(id).get();
        var helper=new OrderHelper();
        helper.createOrder(id,baseid,list,sellerinfo.getAddress(),sellerinfo.getPhone());
        return new Response("success");
    }
}
