package xyz.zinglix.freshfoodstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.zinglix.freshfoodstore.dao.InventoryRepository;
import xyz.zinglix.freshfoodstore.model.Inventory;

import java.util.ArrayList;
import java.util.List;

class OrderList{
    class item{
        Long id;
        Long count;

        public item(Long id, Long count) {
            this.id = id;
            this.count = count;
        }

        public Long getId() {

            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }
    }

    List<item> items;

    public OrderList() {
        items=new ArrayList<>();
    }

    public List<item> getItems() {
        return items;
    }

    public void setItems(List<item> items) {
        this.items = items;
    }

    public OrderList(List<item> items) {
        this.items = items;
    }
}

@RestController
public class InventoryController {
    @Autowired
    private InventoryRepository inv;

//    @PostMapping("/api/seller/{id}/inventory")
//    void addProduct(@PathVariable Long seller_id, @RequestBody OrderList list){
//
//    }
}
