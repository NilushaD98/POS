package com.example.newpos.posnew.entity;

import com.example.newpos.posnew.entity.enums.MesuringUnitsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="order_details")
public class OrderDetails {
    @Id
    @Column(name="order_details_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsID;

    @Column(name="item_name",length = 100,nullable = false)
    private String itemName;

    @Column(name="qty",length = 100,nullable = false)
    private double Qty;

    @Column(name="selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name="amount",nullable = false)
    private double amount;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
