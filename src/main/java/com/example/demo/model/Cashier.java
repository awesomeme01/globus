package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "cashier_table" )
public class Cashier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column (name ="name " ,nullable = false , unique = true)
    private String name;

    public Cashier() {
    }

    public Cashier(String name ) {
        this.name = name;

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
}
