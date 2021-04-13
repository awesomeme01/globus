package com.example.demo.service;

import com.example.demo.model.Item;

import java.util.List;

public interface ItemService {
    Item create (Item item );
    Item update (Item item );
    List<Item> getAll();
    List<Item> getByCategory(String category);
    List<Item> getNewest();
    void delete (Integer id );


}
