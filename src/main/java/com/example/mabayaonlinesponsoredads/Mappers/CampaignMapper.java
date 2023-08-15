package com.example.mabayaonlinesponsoredads.Mappers;
import com.example.mabayaonlinesponsoredads.DTOs.CampaignDTO;
import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface CampaignMapper {
    @Mapping(target = "startDate", source = "startDate")
    CampaignDTO campaignToCampaignDTO(Campaign campaign);

    default Timestamp stringToTimestamp(String value) {
        return Timestamp.valueOf(value);
    }

    Campaign campaignDTOToCampaign(CampaignDTO campaignDTO);
}
