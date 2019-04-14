package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.zinglix.freshfoodstore.dao.InventoryRepository;
import xyz.zinglix.freshfoodstore.model.Inventory;
import xyz.zinglix.freshfoodstore.util.BadRequestException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private InventoryRepository inv;

    @GetMapping("/api/inventory/{id}")
    @CrossOrigin
    Inventory getInventory(@PathVariable Long id){
        var item=inv.findById(id);
        if(!item.isPresent()) throw new BadRequestException("Inventory "+id+" doesn't exist.");
        return item.get();
    }
}
