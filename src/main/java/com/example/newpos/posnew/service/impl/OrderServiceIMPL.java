package com.example.newpos.posnew.service.impl;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.request.OrderSaveRequestDTO;
import com.example.newpos.posnew.entity.Customer;
import com.example.newpos.posnew.entity.OrderDetails;
import com.example.newpos.posnew.entity.Orders;
import com.example.newpos.posnew.exception.NotFoundException;
import com.example.newpos.posnew.repo.CustomerRepo;
import com.example.newpos.posnew.repo.ItemRepo;
import com.example.newpos.posnew.repo.OrderDetailsRepo;
import com.example.newpos.posnew.repo.OrderRepo;
import com.example.newpos.posnew.service.OrderService;
import com.example.newpos.posnew.util.mappers.OrderMappers;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderMappers orderMappers;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Override
    @Transactional
    public String addOrder(OrderSaveRequestDTO orderSaveRequestDTO) {
        Orders orders = new Orders(
                customerRepo.getById(orderSaveRequestDTO.getCustomer()),
                orderSaveRequestDTO.getDate(),
                orderSaveRequestDTO.getTotal()
        );
        orderRepo.save(orders);
        if (orderRepo.existsById(orders.getOrderID())) {
            List<OrderDetails> orderDetails =
                    modelMapper
                    .map(orderSaveRequestDTO.getOrderDetailsList(), new TypeToken<List<OrderDetails>>() {
                    }.getType());

            if(orderDetails.size()>0){
                for(int i=0;i<orderDetails.size();i++){
                    orderDetails.get(i).setOrders(orders);
                    orderDetails.get(i).setItem(itemRepo.getById(orderSaveRequestDTO.getOrderDetailsList().get(i).getItem()));
                }
                orderDetailsRepo.saveAll(orderDetails);
                return orders.getOrderID()+"Saved...";
            }else{
                return null;
            }
        }
        return null;
    }

}
