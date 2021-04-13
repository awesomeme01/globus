package com.example.demo.bootstrap;

import com.example.demo.model.Cashier;
import com.example.demo.model.Item;
import com.example.demo.repository.CashierRepository;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MainBootstrap implements ApplicationRunner {
    @Autowired
    CashierRepository cashierRepository;
    @Autowired
    ItemRepository itemRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try{
            Cashier cashier = new Cashier ("Kylie");
            cashierRepository.save(cashier);
            Item item1 = new Item("cheese",200, LocalDateTime.of(2001, 12,12,13,1),"milky-products",cashier);
            Item item2 = new Item("bread",25, LocalDateTime.of(2021, 6,1,13,1),"flourish-products",cashier);
            Item item3 = new Item("coke",35, LocalDateTime.of(2021, 5,3,13,1),"drinks",cashier);
            Item item4 = new Item("water",18, LocalDateTime.of(2021, 4,23,13,1),"drinks",cashier);
            itemRepository.save(item1);
            itemRepository.save(item2);
            itemRepository.save(item3);
            itemRepository.save(item4);
        }
        catch(DataIntegrityViolationException exception){
            System.out.println("Data already exists! ERROR: "+ exception.getCause());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{
            System.out.println("Marketplace is working !");
        }
    }
}
