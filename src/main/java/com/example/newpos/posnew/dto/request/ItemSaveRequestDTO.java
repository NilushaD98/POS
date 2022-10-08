package com.example.newpos.posnew.dto.request;

import com.example.newpos.posnew.entity.enums.MesuringUnitsType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemSaveRequestDTO {

    private String itemName;
    private String mesuringUnitstype;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;

}
