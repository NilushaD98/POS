package com.example.newpos.posnew.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUpdateRequestDTO {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private ArrayList contacts;
    private String nic;
    private boolean activeState;
}
