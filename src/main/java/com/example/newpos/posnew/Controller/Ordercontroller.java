package com.example.newpos.posnew.Controller;

import com.example.newpos.posnew.dto.request.ItemSaveRequestDTO;
import com.example.newpos.posnew.dto.request.OrderSaveRequestDTO;
import com.example.newpos.posnew.service.OrderService;
import com.example.newpos.posnew.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToMany;

@RestController
@CrossOrigin
@RequestMapping("api/v1/order/")
public class Ordercontroller {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody OrderSaveRequestDTO orderSaveRequestDTO) {
        System.out.println(orderSaveRequestDTO);
        String id = orderService.addOrder(orderSaveRequestDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "order successfully saved..", id),
                HttpStatus.CREATED
        );

    }
}