package com.example.mabayaonlinesponsoredads.Entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId;
    String name;
    Timestamp startDate;
    double bid;
    @OneToMany(mappedBy = "campaign")
    private Set<ProductsInCampaign> productsInCampaignSet = new HashSet<>();

    public Campaign(String name, Timestamp startDate, double bid) {
        this.name = name;
        this.startDate = startDate;
        this.bid = bid;
    }

    public Campaign() {

    }

    public Long getCampaignId() {
        return campaignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public Set<ProductsInCampaign> getProductsInCampaignSet() {
        return productsInCampaignSet;
    }

    public void setProductsInCampaignSet(Set<ProductsInCampaign> productsInCampaignSet) {
        this.productsInCampaignSet = productsInCampaignSet;
    }
}
