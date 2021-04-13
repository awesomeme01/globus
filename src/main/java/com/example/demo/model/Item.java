package com.example.demo.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name ="item_table ")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name ="name",nullable = false , unique = true)
    private String name ;
    @Column (name="price",nullable = false)
    private Integer price ;
    @Column (name = "dateAdded",nullable = false)
    private LocalDateTime dateAdded;
    @Column (name ="dateExpiry" , nullable = false)
    private LocalDateTime dateExpiry;
    @Column (name ="category" , nullable = false ,unique = false)
    private String category;
    @ManyToOne
    @JoinColumn(name ="cashier_table")
    private Cashier cashier;

    public Item() {
        this.dateAdded = LocalDateTime.now();
    }

    public Item(String name, Integer price, LocalDateTime dateExpiry, String category, Cashier cashier) {
        this.name = name;
        this.price = price;
        this.dateAdded = LocalDateTime.now();
        this.dateExpiry = dateExpiry;
        this.category = category;
        this.cashier = cashier;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalDateTime getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(LocalDateTime dateExpiry) {
        this.dateExpiry = dateExpiry;
    }
}
