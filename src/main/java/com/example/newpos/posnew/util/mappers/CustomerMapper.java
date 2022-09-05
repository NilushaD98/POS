package com.example.newpos.posnew.util.mappers;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO entityToDTO(Customer customer);
}
