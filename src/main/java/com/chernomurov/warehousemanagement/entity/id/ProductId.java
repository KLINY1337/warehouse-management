package com.chernomurov.warehousemanagement.entity.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductId implements Serializable {
    private String productArticleNumber;
}
