package com.chernomurov.warehousemanagement.entity.id_class;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductId implements Serializable {
    private String productArticleNumber;
}
