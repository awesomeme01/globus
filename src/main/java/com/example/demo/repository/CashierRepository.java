package com.example.demo.repository;

import com.example.demo.model.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashierRepository  extends JpaRepository<Cashier,Integer> {

}
