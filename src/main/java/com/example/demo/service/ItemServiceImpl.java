package com.example.demo.service;

import com.example.demo.model.Cashier;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepository itemRepository;
    @Override
    public Item create(Item item) {
       return  itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.save(item);
    }


    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getByCategory(String category) {
        return itemRepository.findAll()//returns List<Item>
                .stream()//returns Stream<Item>
                .filter( x -> {
                    return x.getCategory().equals(category);
                })//returns Stream<Item>
                .collect(Collectors.toList());//List<Item>
    }



    @Override
    public List<Item> getNewest() {//убрать испорченные товары
        return itemRepository.findAll()
                .stream()
                .filter(x->{
                    LocalDateTime date = LocalDateTime.now();
                    if(date.isAfter(x.getDateExpiry())){
                        return false;
                    }
                    else
                        return true;
                }).collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        itemRepository.deleteById(id);

    }
}
