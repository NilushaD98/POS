package com.example.newpos.posnew.Controller;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.ItemDTO;
import com.example.newpos.posnew.dto.request.ItemSaveRequestDTO;
import com.example.newpos.posnew.service.ItemService;
import com.example.newpos.posnew.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item/")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path="save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {

        String saveState = itemService.addItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,saveState + "item succefully saved..",saveState),
                HttpStatus.CREATED
        );
    }
    @GetMapping(path="get-all-items")
     public ResponseEntity<StandardResponse> gettAllItem(){
        List<ItemDTO> allItems = itemService.getAllItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success...",allItems),
                HttpStatus.OK
        );
     }


}
