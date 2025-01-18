package com.example.AWS_DDB_LS_POC;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody ItemTable itemTable) {
        itemService.createItem(itemTable);
        return ResponseEntity.ok("Item created successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemTable> getItem(@PathVariable String id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }
}