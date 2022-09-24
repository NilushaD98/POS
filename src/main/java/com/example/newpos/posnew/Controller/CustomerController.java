package com.example.newpos.posnew.Controller;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.request.CustomerSaveRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateNSNByQueryRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateQueryRequestDTO;
import com.example.newpos.posnew.dto.request.CustomerUpdateRequestDTO;
import com.example.newpos.posnew.dto.response.CustomerEndpointIIResponseDTO;
import com.example.newpos.posnew.dto.response.ResponseActiveCustomerDTO;
import com.example.newpos.posnew.service.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/Customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO) {

        String id = customerService.addCustomer(customerSaveRequestDTO);
        return id;
    }
    @PutMapping(path = "update")
    public String UpdateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        String state = customerService.updateCustomer(customerUpdateRequestDTO);
        return customerUpdateRequestDTO.getCustomerName();
    }
    @GetMapping(
            path = "get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return customerDTO;
    }
    @GetMapping(
            path = "get-all-custom"
    )
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }
    @DeleteMapping(path="delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value = "id")int id) throws NotFoundException {
        boolean deletedCustomer = customerService.deleteCustomer(id);
        return "deleted";
    }
    @GetMapping(
            path= "get-by-name",
            params = "name"
    )
    public List<CustomerDTO> getByName(@RequestParam(value= "name")String customerName) throws NotFoundException {
        List<CustomerDTO> customerDTOList = customerService.getCustomerByName(customerName);
        return customerDTOList;
    }
    @GetMapping(
            path = "get-by- activeState"
    )
    public List<CustomerDTO> getByActiveState() throws NotFoundException {
        List<CustomerDTO> customerDTOList = customerService.getCustomerByActiveState();
        return customerDTOList;
    }
    @GetMapping(
            path = "get-by- activeState-only-name"
    )
    public List<ResponseActiveCustomerDTO> getByActiveStateOnlyNAme() throws NotFoundException {
        List<ResponseActiveCustomerDTO> responseActiveCustomerDTOS = customerService.getCustomerByActiveStateOnlyName();
        return responseActiveCustomerDTOS;
    }
    @PutMapping(path="update-name-nic-query/{id}")
    public String updateCustomerByQuery(
            @RequestBody CustomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO,
            @PathVariable(value = "id")int id) {
        String updated = customerService.updateCustomerByQuery(customerUpdateQueryRequestDTO,id);
        return updated;
    }
    @GetMapping(path="get-customer-by-nic/{nic}")
    public List<CustomerDTO> getbyNIC(@PathVariable(value="nic")String nic) throws NotFoundException {
        List<CustomerDTO> customerDTO = customerService.getCusomerByNIC(nic);
        return  customerDTO;
    }
    @GetMapping(path="get-by-id-salary-address-id/{id}")
    public CustomerEndpointIIResponseDTO getCustomerSalaryAddressByID(@PathVariable(value="id")int id) throws NotFoundException {
        CustomerEndpointIIResponseDTO customerEndpointIIResponseDTO = customerService.getCustomerByIdOnlySallaryAndAddress(id);
        return  customerEndpointIIResponseDTO;
    }
    @PutMapping(path="update-name-salary-nic/{id}")
    public String UpdateCustomerNameSalaryNicByQuery(
            @RequestBody CustomerUpdateNSNByQueryRequestDTO customerUpdateNSNByQueryRequestDTO,
            @PathVariable(value="id")int id
    ) throws NotFoundException {
        String updated = customerService.updateCustomerNSNByQuery(customerUpdateNSNByQueryRequestDTO,id);
        return  updated;

    }

    @GetMapping(path="get-active-or-inactive-customer-by-id/{id}")
    public String getActiveCustomerById(@PathVariable(value="id")int id) throws NotFoundException {
        String customerPresantStatus = customerService.getCustomerInactiveOrActiveByid(id);
        return customerPresantStatus;
    }

}
