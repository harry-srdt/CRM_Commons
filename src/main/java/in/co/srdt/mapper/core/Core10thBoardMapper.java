package in.co.srdt.mapper.core;

import in.co.srdt.dto.core.Core10thBoardDto;
import in.co.srdt.entity.coresetup.Core10thBoard;
import org.springframework.stereotype.Component;

@Component
public class Core10thBoardMapper {

    public Core10thBoardDto toDto(Core10thBoard entity){
        if (entity==null)
            return null;
        Core10thBoardDto dto = new Core10thBoardDto();
        dto.setCore10BoardId(entity.getCore10BoardId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Core10thBoard toEntity(Core10thBoardDto dto){
        if (dto==null)
            return null;
        Core10thBoard entity = new Core10thBoard();
        entity.setCore10BoardId(dto.getCore10BoardId());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
