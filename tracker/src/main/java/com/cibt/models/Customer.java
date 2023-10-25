package com.cibt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
     @Column(name = "address")
    private String address;
     @Column(name = "phone")
    private String phone;

    public Customer(){

    }

     public Customer(int id,String name,String address,String phone){
        this.id=id;
        this.name=name;
        this.address=address;
        this.phone=phone;
    }
}
