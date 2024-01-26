package com.project.test.conversor;

import com.project.test.dto.ReadersDto;
import com.project.test.entity.Readers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.commons.collections4.CollectionUtils;

@Stateless
public class ReadersConversor implements Serializable {

    public ReadersDto getFromEntity(final Readers entity) {
        final ReadersDto dto = new ReadersDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
    
    public Readers getFromDto(final ReadersDto dto) {
        final Readers entity = new Readers();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

    public List<ReadersDto> getListFromEntity(final List<Readers> entityList) {
        final List<ReadersDto> dtoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(entityList)) {
            entityList.stream().forEach(entity -> {
                dtoList.add(getFromEntity(entity));
            });
        }
        return dtoList;
    }
}
