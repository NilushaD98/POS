package com.example.newpos.posnew.util.mappers;

import com.example.newpos.posnew.dto.ItemDTO;
import com.example.newpos.posnew.dto.request.ItemSaveRequestDTO;
import com.example.newpos.posnew.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item RequestDTOtoENtity(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemDTO> EntityListtoDTOList(List<Item> items);
}
