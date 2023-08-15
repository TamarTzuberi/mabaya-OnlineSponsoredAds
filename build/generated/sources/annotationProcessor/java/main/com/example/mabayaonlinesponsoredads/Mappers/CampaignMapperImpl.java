package com.example.mabayaonlinesponsoredads.Mappers;

import com.example.mabayaonlinesponsoredads.DTOs.CampaignDTO;
import com.example.mabayaonlinesponsoredads.Entities.Campaign;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-16T00:27:30+0300",
    comments = "version: 1.4.0.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class CampaignMapperImpl implements CampaignMapper {

    private final DatatypeFactory datatypeFactory;

    public CampaignMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public CampaignDTO campaignToCampaignDTO(Campaign campaign) {
        if ( campaign == null ) {
            return null;
        }

        CampaignDTO campaignDTO = new CampaignDTO();

        campaignDTO.setStartDate( xmlGregorianCalendarToString( dateToXmlGregorianCalendar( campaign.getStartDate() ), null ) );
        campaignDTO.setName( campaign.getName() );
        campaignDTO.setBid( campaign.getBid() );

        return campaignDTO;
    }

    @Override
    public Campaign campaignDTOToCampaign(CampaignDTO campaignDTO) {
        if ( campaignDTO == null ) {
            return null;
        }

        Campaign campaign = new Campaign();

        campaign.setName( campaignDTO.getName() );
        campaign.setStartDate( stringToTimestamp( campaignDTO.getStartDate() ) );
        campaign.setBid( campaignDTO.getBid() );

        return campaign;
    }

    private String xmlGregorianCalendarToString( XMLGregorianCalendar xcal, String dateFormat ) {
        if ( xcal == null ) {
            return null;
        }

        if (dateFormat == null ) {
            return xcal.toString();
        }
        else {
            Date d = xcal.toGregorianCalendar().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat( dateFormat );
            return sdf.format( d );
        }
    }

    private XMLGregorianCalendar dateToXmlGregorianCalendar( Date date ) {
        if ( date == null ) {
            return null;
        }

        GregorianCalendar c = new GregorianCalendar();
        c.setTime( date );
        return datatypeFactory.newXMLGregorianCalendar( c );
    }
}
