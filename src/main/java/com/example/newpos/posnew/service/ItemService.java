package com.example.newpos.posnew.service;

import com.example.newpos.posnew.dto.ItemDTO;
import com.example.newpos.posnew.dto.request.ItemSaveRequestDTO;

import java.util.List;

public interface ItemService {
    String addItem(ItemSaveRequestDTO itemSaveRequestDTO);


    List<ItemDTO> getAllItems();
}
