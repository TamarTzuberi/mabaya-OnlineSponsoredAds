package com.example.mabayaonlinesponsoredads.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CampaignDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("startDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startDate;
    @JsonProperty("productIds")
    private List<Long> productIds;
    @JsonProperty("bid")
    private double bid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }
}
