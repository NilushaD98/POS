package com.example.newpos.posnew.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUpdateNSNByQueryRequestDTO {

    private String customerName;

    private double customerSalary;

    private String nic;


}
