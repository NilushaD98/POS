package com.example.newpos.posnew.service.impl;

import com.example.newpos.posnew.dto.ItemDTO;
import com.example.newpos.posnew.dto.request.CustomerSaveRequestDTO;
import com.example.newpos.posnew.dto.request.ItemSaveRequestDTO;
import com.example.newpos.posnew.entity.Customer;
import com.example.newpos.posnew.entity.Item;
import com.example.newpos.posnew.entity.enums.MesuringUnitsType;
import com.example.newpos.posnew.exception.EntriyNotFoundException;
import com.example.newpos.posnew.repo.ItemRepo;
import com.example.newpos.posnew.service.ItemService;
import com.example.newpos.posnew.util.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {


    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public String addItem(ItemSaveRequestDTO itemSaveRequestDTO) {

        Item item = itemMapper.RequestDTOtoENtity(itemSaveRequestDTO);
        item.setActiveState(true);

        if(!itemRepo.existsById(item.getItemID())){
            return itemRepo.save(item).getItemName();
        }else{
            throw new EntriyNotFoundException("Already in database");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepo.findAll();

        List<ItemDTO> itemDTOS = itemMapper.EntityListtoDTOList(items);
        return itemDTOS;
    }
}
