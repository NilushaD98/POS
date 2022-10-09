package com.example.newpos.posnew.dto.request;

import com.example.newpos.posnew.entity.Item;
import com.example.newpos.posnew.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsSaveRequestDTO {

    private String itemName;
    private double Qty;
    private double amount;
    private int orders;
    private int item;

}
