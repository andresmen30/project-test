/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.conversor;

import com.project.test.dto.BlogsDto;
import com.project.test.dto.BlogsReadersDto;
import com.project.test.entity.Blogs;
import com.project.test.entity.BlogsReaders;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.commons.collections4.CollectionUtils;

/**
 *
 * @author andresmendez
 */
@Stateless
public class ReaderBlogsConversor implements Serializable {

    @Inject
    private ReadersConversor readersConversor;

    @Inject
    private BlogsConversor blogsConversor;

    public BlogsReadersDto getFromEntity(final BlogsReaders entity) {
        final BlogsReadersDto dto = new BlogsReadersDto();
        dto.setId(entity.getId());
        dto.setBlog(blogsConversor.getFromEntity(entity.getBlog()));
        dto.setReader(readersConversor.getFromEntity(entity.getReader()));
        return dto;
    }

    public List<BlogsReadersDto> getListFromEntity(final List<BlogsReaders> entityList) {
        final List<BlogsReadersDto> dtoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(entityList)) {
            entityList.stream().forEach(entity -> {
                dtoList.add(getFromEntity(entity));
            });
        }
        return dtoList;
    }

}
