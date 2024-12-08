package in.co.srdt.mapper.lead;

import in.co.srdt.dto.lead.LeadCaptureDTO;
import in.co.srdt.dto.lead.LeadStageDTO;
import in.co.srdt.entity.lead.LeadCapture;
import in.co.srdt.entity.lead.LeadStage;
import in.co.srdt.crmcommons.exception.core.*;
import in.co.srdt.exception.core.*;
import in.co.srdt.exception.lead.ResourceNotFoundException;
import in.co.srdt.crmcommons.repository.core.*;
import in.co.srdt.repository.core.*;
import in.co.srdt.repository.lead.LeadStageRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LeadCaptureMapper {

    private final CoreStateRepository stateRepository;
    private final CoreCityRepository cityRepository;
    private final CoreAcademicCareerRepository careerRepository;
    private final CoreAcademicProgramRepository programRepository;
    private final CoreLeadSourceRepository leadSourceRepository;
    private final CoreSessionRepository sessionRepository;
    private final LeadStageRepository leadStageRepository;

    public LeadCaptureMapper(CoreStateRepository stateRepository,
                             CoreCityRepository cityRepository,
                             CoreAcademicCareerRepository careerRepository, CoreAcademicProgramRepository programRepository,
                             CoreLeadSourceRepository leadSourceRepository,
                             CoreSessionRepository sessionRepository,
                             LeadStageRepository leadStageRepository) {

        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.careerRepository = careerRepository;
        this.programRepository = programRepository;
        this.leadSourceRepository = leadSourceRepository;
        this.sessionRepository = sessionRepository;
        this.leadStageRepository = leadStageRepository;
    }

    public LeadCaptureDTO toDto(LeadCapture leadCapture) {
        if (leadCapture == null) return null;

        LeadCaptureDTO dto = new LeadCaptureDTO();
        dto.setLeadCaptureId(leadCapture.getLeadCaptureId());
        dto.setName(leadCapture.getName());
        dto.setEmail(leadCapture.getEmail());
        dto.setPhone(leadCapture.getPhone());
        dto.setModifiedOn(leadCapture.getUpdatedAt());

        leadCapture.getLeadStages().stream()
                .max(Comparator.comparing(LeadStage::getCreatedAt))
                .ifPresent(latestStage -> {
                    if (latestStage.getCoreLeadStage() != null) {
                        dto.setLeadStageName(latestStage.getCoreLeadStage().getName());
                    }
                });

        if (leadCapture.getCoreState() != null) {
            dto.setCurrentCoreStateId(leadCapture.getCoreState().getCoreStateId());
            dto.setStateName(leadCapture.getCoreState().getName());
        }

        if (leadCapture.getCoreCity() != null) {
            dto.setCurrentCoreCityId(leadCapture.getCoreCity().getCoreCityId());
            dto.setCityName(leadCapture.getCoreCity().getName());
        }

        if (leadCapture.getAcademicCareer() != null) {
            dto.setAcademicCareerId(leadCapture.getAcademicCareer().getAcademicCareerId());
            dto.setCareerDescription(leadCapture.getAcademicCareer().getDescription());
            dto.setAcademicCareerName(leadCapture.getAcademicCareer().getName());
        }

        if (leadCapture.getAcademicProgram() != null) {
            dto.setAcademicProgramId(leadCapture.getAcademicProgram().getAcademicProgramId());
            dto.setProgramDescription(leadCapture.getAcademicProgram().getDescription());
            dto.setAcademicProgramName(leadCapture.getAcademicProgram().getName());
        }

        if (leadCapture.getLeadSource() != null) {
            dto.setLeadSourceId(leadCapture.getLeadSource().getLeadSourceId());
            dto.setLeadDescription(leadCapture.getLeadSource().getDescription());
            dto.setLeadSourceName(leadCapture.getLeadSource().getName());
        }

        if (leadCapture.getCoreSession() != null) {
            dto.setCoreSessionId(leadCapture.getCoreSession().getSessionId());
            dto.setSessionName(leadCapture.getCoreSession().getName());
        }

        List<LeadStageDTO> leadStageDTOs = leadCapture.getLeadStages().stream()
                .map(stage -> {
                    LeadStageDTO leadStageDTO = new LeadStageDTO();
                    leadStageDTO.setLeadStageId(stage.getLeadStageId());
                    leadStageDTO.setCoreLeadStageId(stage.getCoreLeadStage().getLeadStageId());
                    leadStageDTO.setCoreLeadSubStageId(stage.getCoreLeadSubStage().getLeadSubStageId());
                    return leadStageDTO;
                })
                .collect(Collectors.toList());

        dto.setLeadStages(leadStageDTOs);

        return dto;
    }


    public LeadCapture toEntity(LeadCaptureDTO leadCaptureDto) {
        if (leadCaptureDto == null) return null;

        LeadCapture entity = new LeadCapture();
        entity.setLeadCaptureId(leadCaptureDto.getLeadCaptureId());
        entity.setName(leadCaptureDto.getName());
        entity.setEmail(leadCaptureDto.getEmail());
        entity.setPhone(leadCaptureDto.getPhone());

        if (leadCaptureDto.getCurrentCoreStateId() != null) {
            entity.setCoreState(stateRepository.findById(leadCaptureDto.getCurrentCoreStateId())
                    .orElseThrow(() -> new CoreStateNotFoundException("State not found with this id: " + leadCaptureDto.getCurrentCoreStateId())));

        }

        if (leadCaptureDto.getCurrentCoreCityId() != null) {
            entity.setCoreCity(cityRepository.findById(leadCaptureDto.getCurrentCoreCityId())
                    .orElseThrow(() -> new CoreCityNotFoundException("City not found with this id: " + leadCaptureDto.getCurrentCoreCityId())));
        }

        if (leadCaptureDto.getAcademicCareerId() != null) {
            entity.setAcademicCareer(careerRepository.findById(leadCaptureDto.getAcademicCareerId())
                    .orElseThrow(() -> new CoreAcademicCareerNotFoundException("Academic Career not found with this id: " + leadCaptureDto.getAcademicCareerId())));

        }

        if (leadCaptureDto.getAcademicProgramId() != null) {
            entity.setAcademicProgram(programRepository.findById(leadCaptureDto.getAcademicProgramId())
                    .orElseThrow(() -> new CoreAcademicProgramNotFoundException("Academic Program not found with this id: " + leadCaptureDto.getAcademicProgramId())));

        }

        if (leadCaptureDto.getLeadSourceId() != null) {
            entity.setLeadSource(leadSourceRepository.findById(leadCaptureDto.getLeadSourceId())
                    .orElseThrow(() -> new CoreLeadSourceNotFoundException("Lead Source not found with this id: " + leadCaptureDto.getLeadSourceId())));

        }

        if (leadCaptureDto.getCoreSessionId() != null) {
            entity.setCoreSession(sessionRepository.findById(leadCaptureDto.getCoreSessionId())
                    .orElseThrow(() -> new ResourceNotFoundException("Session not found with this id: " + leadCaptureDto.getCoreSessionId())));

        }

        if (leadCaptureDto.getLeadStages() != null) {
            List<LeadStage> leadStages = leadCaptureDto.getLeadStages().stream()
                    .map(stageDto -> leadStageRepository.findById(stageDto.getLeadStageId())
                            .orElseThrow(() -> new ResourceNotFoundException("Lead Stage not found with id: " + stageDto.getLeadStageId())))
                    .collect(Collectors.toList());
            entity.setLeadStages(leadStages);
        }

        return entity;
    }
}
