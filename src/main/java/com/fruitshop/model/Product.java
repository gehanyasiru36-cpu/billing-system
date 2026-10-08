package com.fruitshop.model;
public record Product(int id,String code,String name,String unit,double buyingPrice,double sellingPrice,double stock,double reorderLevel) {}