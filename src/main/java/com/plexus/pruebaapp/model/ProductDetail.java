package com.plexus.pruebaapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProductDetail {
    private String id;
    private String name;
    private double price;
    private boolean availability;
}
