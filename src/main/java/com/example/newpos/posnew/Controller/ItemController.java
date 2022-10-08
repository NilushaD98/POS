package com.example.newpos.posnew.Controller;

import com.example.newpos.posnew.service.ItemService;
import com.example.newpos.posnew.util.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item/")
public class ItemController {

    @Autowired
    private ItemService itemService;

    private ItemMapper itemMapper;
}
