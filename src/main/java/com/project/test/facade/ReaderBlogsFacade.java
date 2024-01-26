/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.facade;

import com.project.test.conversor.BlogsConversor;
import com.project.test.conversor.ReaderBlogsConversor;
import com.project.test.conversor.ReadersConversor;
import com.project.test.dao.IReadersBlogDao;
import com.project.test.dto.BlogsDto;
import com.project.test.dto.BlogsReadersDto;
import com.project.test.dto.ReadersDto;
import com.project.test.entity.BlogsReaders;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author andresmendez
 */
@Stateless
public class ReaderBlogsFacade implements Serializable {
    
    @Inject
    private IReadersBlogDao readersBlogDao;
    
    @Inject
    private ReadersConversor readersConversor;
    
    @Inject
    private BlogsConversor blogsConversor;
    
    @Inject
    private ReaderBlogsConversor readerBlogsConversor;
    
    public List<BlogsReadersDto> getAll() {
        return readerBlogsConversor.getListFromEntity(readersBlogDao.getAll());
    }
    
    public void save(final Long id, final ReadersDto readersDto, final BlogsDto blogsDto) {
        final BlogsReaders blogsReadersEntity = new BlogsReaders();
        if (id != null) {
            blogsReadersEntity.setId(id);
        }
        blogsReadersEntity.setBlog(blogsConversor.getFromDto(blogsDto));
        blogsReadersEntity.setReader(readersConversor.getFromDto(readersDto));
        readersBlogDao.save(blogsReadersEntity);
    }
    
    public void delete(final Long id) {
        readersBlogDao.delete(id);
    }
    
}
