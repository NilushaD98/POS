package com.example.newpos.posnew.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerUpdateQueryRequestDTO {
    private String customerName;
    private String nic;
}
