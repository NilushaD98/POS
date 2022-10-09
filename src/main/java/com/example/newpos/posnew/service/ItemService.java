package com.example.newpos.posnew.service;

import com.example.newpos.posnew.dto.ItemDTO;
import com.example.newpos.posnew.dto.paginated.PaginatedRequestDTO;
import com.example.newpos.posnew.dto.request.ItemSaveRequestDTO;
import javassist.NotFoundException;

import java.util.List;

public interface ItemService {
    String addItem(ItemSaveRequestDTO itemSaveRequestDTO);


    List<ItemDTO> getAllItems();

    List<ItemDTO> getItemsByState(boolean status);

    int countItems();

    ItemDTO searchItemByID(int id) throws NotFoundException;

    String updateItem(ItemDTO itemDTO);

    String deleteItemByID(int id);

    PaginatedRequestDTO getAllItemsPAginated(int page, int size);

    PaginatedRequestDTO getAllActiveItemsPaginated(int page, int size, boolean state);
}
