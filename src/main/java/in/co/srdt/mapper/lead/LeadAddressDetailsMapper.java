package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadAddressDetailsDTO;
import in.co.srdt.entity.lead.LeadAddressDetails;
import in.co.srdt.exception.core.CoreCityNotFoundException;
import in.co.srdt.exception.core.CoreStateNotFoundException;
import in.co.srdt.exception.lead.LeadAddressDetailsNotFoundException;
import in.co.srdt.repository.core.CoreCityRepository;
import in.co.srdt.repository.core.CoreStateRepository;
import in.co.srdt.repository.lead.LeadCaptureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LeadAddressDetailsMapper {

    private final LeadCaptureRepository captureRepository;
    public final CoreStateRepository stateRepository;
    private final CoreCityRepository cityRepository;

    public LeadAddressDetailsDTO toDto(LeadAddressDetails leadAddressDetails){
        if (leadAddressDetails==null)
            return null;
        LeadAddressDetailsDTO dto = new LeadAddressDetailsDTO();
        dto.setLeadAddressDetailsId(leadAddressDetails.getLeadAddressDetailsId());
        dto.setLeadCaptureId(leadAddressDetails.getLeadCapture()!=null?leadAddressDetails.getLeadCapture().getLeadCaptureId():0);
        dto.setAddressType(leadAddressDetails.getAddressType());
        dto.setCountry(leadAddressDetails.getCountry());
        dto.setCoreCityId(leadAddressDetails.getCoreCity()!=null? leadAddressDetails.getCoreCity().getCoreCityId():0);
        dto.setCoreStateId(leadAddressDetails.getCoreState()!=null?leadAddressDetails.getCoreState().getCoreStateId():0);
        dto.setAddress(leadAddressDetails.getAddress());
        dto.setCityName(leadAddressDetails.getCoreCity().getName());
        dto.setStateName(leadAddressDetails.getCoreState().getName());
        return dto;
    }

    public LeadAddressDetails toEntity(LeadAddressDetailsDTO detailsDTO){
        if (detailsDTO==null)
            return null;
        LeadAddressDetails entity =   new LeadAddressDetails();
        entity.setLeadCapture(captureRepository
                .findById(detailsDTO.getLeadCaptureId())
                .orElseThrow(()-> new LeadAddressDetailsNotFoundException("Lead Capture Not found with this id : " + detailsDTO.getLeadCaptureId())));
        entity.setCoreState(stateRepository
                .findById(detailsDTO.getCoreStateId())
                .orElseThrow(()-> new CoreStateNotFoundException(("State Not Found With This Id : " + detailsDTO.getCoreStateId()))));
        entity.setCoreCity(cityRepository
                .findById(detailsDTO.getCoreCityId())
                .orElseThrow(()-> new CoreCityNotFoundException(("City Not Found With This Id : " + detailsDTO.getCoreCityId()))));
        entity.setAddress(detailsDTO.getAddress());
        entity.setCountry(detailsDTO.getCountry());
        entity.setAddressType(detailsDTO.getAddressType());
        return entity;
    }
}
