package com.example.mabayaonlinesponsoredads.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {
    @JsonProperty("productId")
    private String productId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("category")
    private String category;
    @JsonProperty("price")
    private double price;
    @JsonProperty("pSerialNum")
    private int pSerialNum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getpSerialNum() {
        return pSerialNum;
    }

    public void setpSerialNum(int pSerialNum) {
        this.pSerialNum = pSerialNum;
    }
}
