package com.example.newpos.posnew.dto.paginated;

import com.example.newpos.posnew.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedRequestDTO {
    private List<ItemDTO> itemDTOList;
    private long dataCount;
}
