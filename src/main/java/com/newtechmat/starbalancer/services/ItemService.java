package com.example.starmanufacture.starmanufacture.services;

import com.example.starmanufacture.starmanufacture.data.models.Item;
import com.example.starmanufacture.starmanufacture.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAllByOrderByIdAsc();
    }

    public Item getItemById(Integer id) {
        return itemRepository.findById(id).get();
    }

    public void removeItemById(Integer id) {
        itemRepository.deleteById(id);
    }
}
