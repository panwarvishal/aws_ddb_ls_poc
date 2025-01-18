package com.example.AWS_DDB_LS_POC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void createItem(ItemTable itemTable) {
        itemRepository.save(itemTable);
    }

    public ItemTable getItemById(String id) {
        return itemRepository.getById(id);
    }
}