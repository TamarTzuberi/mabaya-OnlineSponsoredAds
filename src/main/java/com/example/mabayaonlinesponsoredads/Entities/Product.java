package com.example.mabayaonlinesponsoredads.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String title;
    private String category;
    private double price;
    private int pSerialNum;

    @OneToMany(mappedBy = "product")
    private Set<ProductsInCampaign> productsInCampaignSet;


    public Product(){

    }

    public Product(String title, String category, double price, int pSerialNum) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.pSerialNum = pSerialNum;
    }

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

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public Set<ProductsInCampaign> getProductsInCampaignSet() {
        return productsInCampaignSet;
    }

    public void setProductsInCampaignSet(Set<ProductsInCampaign> productsInCampaignSet) {
        this.productsInCampaignSet = productsInCampaignSet;
    }
}
