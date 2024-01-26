package com.project.test.conversor;

import com.project.test.dto.BlogsDto;
import com.project.test.entity.Blogs;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.apache.commons.collections4.CollectionUtils;

@Stateless
public class BlogsConversor implements Serializable {

    public BlogsDto getFromEntity(final Blogs entity) {
        final BlogsDto dto = new BlogsDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public Blogs getFromDto(final BlogsDto dto) {
        final Blogs entity = new Blogs();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public List<BlogsDto> getListFromEntity(final List<Blogs> entityList) {
        final List<BlogsDto> dtoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(entityList)) {
            entityList.stream().forEach(entity -> {
                dtoList.add(getFromEntity(entity));
            });
        }
        return dtoList;
    }
}
