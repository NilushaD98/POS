package com.example.newpos.posnew.service.impl;

import com.example.newpos.posnew.dto.ItemDTO;
import com.example.newpos.posnew.dto.paginated.PaginatedRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerSaveRequestDTO;
import com.example.newpos.posnew.dto.request.ItemSaveRequestDTO;
import com.example.newpos.posnew.entity.Customer;
import com.example.newpos.posnew.entity.Item;
import com.example.newpos.posnew.entity.enums.MesuringUnitsType;
import com.example.newpos.posnew.exception.EntriyNotFoundException;
import com.example.newpos.posnew.repo.ItemRepo;
import com.example.newpos.posnew.service.ItemService;
import com.example.newpos.posnew.util.StandardResponse;
import com.example.newpos.posnew.util.mappers.ItemMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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

        if (!itemRepo.existsById(item.getItemID())) {
            return itemRepo.save(item).getItemName();
        } else {
            throw new EntriyNotFoundException("Already in database");
        }
    }
    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepo.findAll();
        List<ItemDTO> itemDTOS = itemMapper.EntityListtoDTOList(items);
        return itemDTOS;
    }
    @Override
    public List<ItemDTO> getItemsByState(boolean status) {
        List<Item> itemList = itemRepo.findAllByActiveStateEquals(status);
        List<ItemDTO> itemDTOList = itemMapper.EntityListtoDTOList(itemList);
        return itemDTOList;
    }
    @Override
    public int countItems() {
        int itemCount = itemRepo.countAllByActiveStateEquals(true);
        return itemCount;
    }
    @Override
    public ItemDTO searchItemByID(int id) throws NotFoundException {
        Optional<Item> item = itemRepo.findById(id);
        if(item.isPresent()){
            ItemDTO itemDTO = itemMapper.EntityTODTO(item.get());
            return itemDTO;
        }
        else {
             throw new NotFoundException("This item not found....");
        }
    }
    @Override
    public String updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getItemID())){
            Item item = itemRepo.getById(itemDTO.getItemID());
            item.setItemID(itemDTO.getItemID());
            item.setItemName(itemDTO.getItemName());
            item.setBalanceQty(itemDTO.getBalanceQty());
            item.setMesuringUnitstype(itemDTO.getMesuringUnitstype());
            item.setSellingPrice(itemDTO.getSellingPrice());
            item.setSupplierPrice(itemDTO.getSupplierPrice());
            item.setActiveState(itemDTO.isActiveState());
            itemRepo.save(item);
            return "upadted...";
        }else {
            throw new com.example.newpos.posnew.exception.NotFoundException("this item not here");
        }
    }

    @Override
    public String deleteItemByID(int id) {
        if(itemRepo.existsById(id)){
            itemRepo.deleteById(id);
            return "deleted";
        }else {
            throw new com.example.newpos.posnew.exception.NotFoundException("this item not here");
        }
    }

    @Override
    public PaginatedRequestDTO getAllItemsPAginated(int page, int size) {

        Page<Item> getAllItemByPaginated = itemRepo.findAll(PageRequest.of(page, size));
        return new PaginatedRequestDTO(
                itemMapper.pageToList(getAllItemByPaginated),
                itemRepo.count()
        );
    }

    @Override
    public PaginatedRequestDTO getAllActiveItemsPaginated(int page, int size, boolean state) {
        Page<Item> getAllItemByPaginated = itemRepo.findAllByActiveStateEquals(state,PageRequest.of(page, size));
        return new PaginatedRequestDTO(
                itemMapper.pageToList(getAllItemByPaginated),
                itemRepo.countAllByActiveStateEquals(state)
        );
    }
}
