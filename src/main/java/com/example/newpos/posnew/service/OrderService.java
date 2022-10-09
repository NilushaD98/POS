package com.example.newpos.posnew.service;

import com.example.newpos.posnew.dto.request.OrderSaveRequestDTO;

public interface OrderService{


    String addOrder(OrderSaveRequestDTO orderSaveRequestDTO);
}
