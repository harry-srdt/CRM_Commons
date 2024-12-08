package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.CoreSessionDto;
import in.co.srdt.entity.coresetup.CoreSession;
import org.springframework.stereotype.Component;

@Component
public class CoreSessionMapper {

    public CoreSessionDto toDto(CoreSession coreSession) {
        if (coreSession == null) {
            return null;
        }
        CoreSessionDto dto = new CoreSessionDto();
        dto.setName(coreSession.getName());
        dto.setSessionId(coreSession.getSessionId());
        dto.setStatus(coreSession.getStatus());
        return dto;
    }

    public CoreSession toEntity(CoreSessionDto coreSessionDto) {
        if (coreSessionDto == null) {
            return null;
        }
        CoreSession coreSession = new CoreSession();
        coreSession.setSessionId(coreSessionDto.getSessionId());
        coreSession.setName(coreSessionDto.getName());
        coreSession.setStatus(coreSessionDto.getStatus());
        return coreSession;
    }
}
