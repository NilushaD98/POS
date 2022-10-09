package com.example.newpos.posnew.dto.request;

import com.example.newpos.posnew.entity.Customer;
import com.example.newpos.posnew.entity.Item;
import com.example.newpos.posnew.entity.OrderDetails;
import com.example.newpos.posnew.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderSaveRequestDTO {


    private int customer;
    private Date date;
    private double total;
    private List<OrderDetailsSaveRequestDTO> orderDetailsList;


}
