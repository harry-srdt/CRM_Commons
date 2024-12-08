package in.co.srdt.mapper.core;


import in.co.srdt.dto.core.Core12thBoardDto;
import in.co.srdt.entity.coresetup.Core12thBoard;
import org.springframework.stereotype.Component;

@Component
public class Core12thBoardMapper {

    public Core12thBoardDto toDto(Core12thBoard entity){
        if (entity==null)
            return null;
        Core12thBoardDto dto = new Core12thBoardDto();
        dto.setCore12thBoardId(entity.getCore12thBoardId());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Core12thBoard toEntity(Core12thBoardDto dto){
        if (dto==null)
            return null;
        Core12thBoard entity = new Core12thBoard();
        entity.setCore12thBoardId(dto.getCore12thBoardId());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
