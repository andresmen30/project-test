/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.facade;

import com.project.test.conversor.BlogsConversor;
import com.project.test.dao.IBlogsDao;
import com.project.test.dto.BlogsDto;
import com.project.test.entity.Blogs;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author andresmendez
 */
@Stateless
public class BlogsFacade implements Serializable {

    @Inject
    private IBlogsDao blogsDao;

    @Inject
    private BlogsConversor conversor;

    public List<BlogsDto> getAll() {
        return conversor.getListFromEntity(blogsDao.getAll());
    }

    public void save(final BlogsDto blogsDto) {
        final Blogs entity = conversor.getFromDto(blogsDto);
        blogsDao.save(entity);
    }

    public void delete(final Long id) {
        blogsDao.delete(id);
    }

    public List<BlogsDto> getBlobs(Long idReader) {
        return conversor.getListFromEntity(blogsDao.getBlogs(idReader));
    }

}
