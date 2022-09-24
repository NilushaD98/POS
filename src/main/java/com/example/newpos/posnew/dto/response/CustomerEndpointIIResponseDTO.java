package com.example.newpos.posnew.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerEndpointIIResponseDTO {
    private int customerID;

    private String customerAddress;

    private double customerSalary;

    }
