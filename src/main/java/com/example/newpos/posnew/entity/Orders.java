package com.example.newpos.posnew.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Orders")
@Entity
public class Orders {

    @Id
    @Column(name="order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderID;
    @ManyToOne
    @JoinColumn(name = "custmoer_id",nullable = false)
    private Customer customer;

    @Column(name="order_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name="total",nullable = false)
    private double total;


}
