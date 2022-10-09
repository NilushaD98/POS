package com.example.newpos.posnew.entity;

import com.example.newpos.posnew.entity.enums.MesuringUnitsType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    @Id
    @Column(name="item_ID",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemID;

    @Column(name="item_name",length = 100,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name="mesuring_units",length = 100,nullable = false)
    private MesuringUnitsType mesuringUnitstype;

    @Column(name="balance_qty",length = 100,nullable = false)
    private double balanceQty;

    @Column(name="supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name="selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name="active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy = "item")
    private Set<OrderDetails> orderDetails;


    public Item(String itemName, String mesuringUnitstype, double balanceQty, double supplierPrice, double sellingPrice, boolean b) {

    }
}
