package com.example.newpos.posnew.dto;

import com.example.newpos.posnew.entity.enums.MesuringUnitsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {

    private int itemID;
    private String itemName;
    private MesuringUnitsType mesuringUnitstype;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;
}
