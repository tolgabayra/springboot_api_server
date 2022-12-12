package com.bayraktolga.springapiserver.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Byte[] images;
    private Integer stock;
}
