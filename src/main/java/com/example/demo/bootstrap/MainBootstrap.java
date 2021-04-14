package com.example.demo.bootstrap;

import com.example.demo.model.Cashier;
import com.example.demo.model.Item;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repository.CashierRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MainBootstrap implements ApplicationRunner {
    @Autowired
    CashierRepository cashierRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try{

            BCryptPasswordEncoder b = new BCryptPasswordEncoder();

            User user = new User("admin", b.encode("123"));
            userRepository.save(user);
            UserRole userRole = new UserRole("ROLE_USER", user);
            userRoleRepository.save(userRole);


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
