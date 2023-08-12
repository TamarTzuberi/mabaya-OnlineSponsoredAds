package com.example.mabayaonlinesponsoredads.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId;
    String name;
    LocalDateTime startDate;
    double bid;
    @OneToMany(mappedBy = "campaign")
    private Set<ProductsInCampaign> productsInCampaignSet;

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
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
