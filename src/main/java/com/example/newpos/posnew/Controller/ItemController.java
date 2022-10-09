package com.example.newpos.posnew.Controller;

import com.example.newpos.posnew.dto.CustomerDTO;
import com.example.newpos.posnew.dto.ItemDTO;
import com.example.newpos.posnew.dto.paginated.PaginatedRequestDTO;
import com.example.newpos.posnew.dto.request.ItemSaveRequestDTO;
import com.example.newpos.posnew.service.ItemService;
import com.example.newpos.posnew.util.StandardResponse;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
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
    @GetMapping(
            path={"get-all-by-state"},
            params = {"state"}
    )
    public ResponseEntity<StandardResponse> getAllByState(@RequestParam(value="state")String state){
        if(state.equalsIgnoreCase("active") || state.equalsIgnoreCase("inactive")){
            boolean status = state.equalsIgnoreCase("active")?true:false;
            List<ItemDTO> allItems = itemService.getItemsByState(status);
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,"Success...",allItems),
                    HttpStatus.OK
            );
        }else if(state.equalsIgnoreCase("all")){
            List<ItemDTO> allItems = itemService.getAllItems();
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,"Success...",allItems),
                    HttpStatus.OK
            );
        }else{
            return null;
        }
    }
    @GetMapping(path="get-items-count")
    public ResponseEntity<StandardResponse> getAlItemCounts(){;
        int itemCount = itemService.countItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success..",itemCount),
                HttpStatus.OK
        );
    }
    @GetMapping(
            value = {"search-item-by-id"},
            params = {"id"}
    )
    public ResponseEntity<StandardResponse> searchItemByID(@RequestParam(value = "id")int id) throws NotFoundException {
        ItemDTO itemDTO = itemService.searchItemByID(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"This is the customer...",itemDTO),
                HttpStatus.OK
        );
    }
    @PutMapping(value="update-item")
    public ResponseEntity<StandardResponse> updateItem(@RequestBody ItemDTO itemDTO){
        String updateStatus = itemService.updateItem(itemDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Updated status",updateStatus),
                HttpStatus.ACCEPTED
        );
    }
    @DeleteMapping(value="delete-item-by-id/{id}")
    public ResponseEntity<StandardResponse> deleteItem(@PathVariable(value = "id")int id){
        String deleteStatus = itemService.deleteItemByID(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"delete Status",deleteStatus),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path="get-all-active-items-paginated",
            params = {"page","size","state"}
    )
    public  ResponseEntity<StandardResponse> getAllItemsPaginated(
            @RequestParam(value = "page") int page,
            @RequestParam(value="size")@Max(50) int size,
            @RequestParam(value="state")boolean state

    ){
        PaginatedRequestDTO paginatedRequestDTO = itemService.getAllActiveItemsPaginated(page,size,state);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success..",paginatedRequestDTO),
                HttpStatus.OK
        );
    }
}
