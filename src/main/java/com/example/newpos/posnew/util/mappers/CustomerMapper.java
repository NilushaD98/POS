package com.example.newpos.posnew.util.mappers;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.response.CustomerEndpointIIResponseDTO;
import com.example.newpos.posnew.dto.response.ResponseActiveCustomerDTO;
import com.example.newpos.posnew.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO entityToDTO(Customer customer);
    List<CustomerDTO> entityListToDTOList(List<Customer> customer);
    List<ResponseActiveCustomerDTO> entityListToDTOListOnlyName(List<Customer> customers);

    CustomerEndpointIIResponseDTO entityToCustomerEndpointIIResponseDTO(Customer customer);
}
