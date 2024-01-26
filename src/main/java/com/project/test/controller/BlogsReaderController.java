/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.controller;

import com.project.test.dto.BlogsDto;
import com.project.test.dto.BlogsReadersDto;
import com.project.test.dto.ReadersDto;
import com.project.test.facade.BlogsFacade;
import com.project.test.facade.ReaderBlogsFacade;
import com.project.test.facade.ReadersFacade;
import com.project.test.util.JsfUtility;
import com.project.test.util.MessageUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author andresmendez
 */
@Named
@ViewScoped
public class BlogsReaderController implements Serializable {

    private Long id;
    
    @Inject
    private ReadersFacade readersFacade;

    @Inject
    private ReaderBlogsFacade readerBlogsFacade;

    @Inject
    private BlogsFacade blogsFacade;

    private BlogsDto blogsDto;
    private List<BlogsDto> blogs;
    private ReadersDto readersDto;
    private List<ReadersDto> readers;
    private List<BlogsReadersDto> selectRows;
    private List<BlogsReadersDto> listDatatable;

    @PostConstruct
    public void init() {
        blogsDto = new BlogsDto();
        readersDto = new ReadersDto();
        listDatatable = readerBlogsFacade.getAll();
        readers = readersFacade.getAll();
    }

    public void loadBlogByReader() {
        if (this.readersDto != null) {
            blogs = blogsFacade.getBlobs(this.readersDto.getId());
        } else {
            blogs = new ArrayList<>();
        }
    }

    public void preEditar(final BlogsReadersDto blogsReadersDto) {
        readersDto = blogsReadersDto.getReader();
        loadBlogByReader();
        blogsDto = blogsReadersDto.getBlog();
        id = blogsReadersDto.getId();

    }

    public void cleanNew() {
        this.blogsDto = new BlogsDto();
        readersDto = new ReadersDto();
        blogs = new ArrayList<>();
        id = null;
    }

    public void delete(final BlogsReadersDto blogsReadersDto) {
        readerBlogsFacade.delete(blogsReadersDto.getId());
        JsfUtility.hideDialog("dialogSolicitud");
        MessageUtil.addMessageInfo("Success", null);
        JsfUtility.reloadPagePretty("pretty:readerByBlogs");
    }

    public void save() {
        readerBlogsFacade.save(this.id, readersDto, blogsDto);
        JsfUtility.hideDialog("dialogSolicitud");
        MessageUtil.addMessageInfo("Success", null);
        JsfUtility.reloadPagePretty("pretty:readerByBlogs");
    }

    public BlogsDto getBlogsDto() {
        return blogsDto;
    }

    public void setBlogsDto(BlogsDto blogsDto) {
        this.blogsDto = blogsDto;
    }

    public List<BlogsDto> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogsDto> blogs) {
        this.blogs = blogs;
    }

    public ReadersDto getReadersDto() {
        return readersDto;
    }

    public void setReadersDto(ReadersDto readersDto) {
        this.readersDto = readersDto;
    }

    public List<ReadersDto> getReaders() {
        return readers;
    }

    public void setReaders(List<ReadersDto> readers) {
        this.readers = readers;
    }

    public List<BlogsReadersDto> getSelectRows() {
        return selectRows;
    }

    public void setSelectRows(List<BlogsReadersDto> selectRows) {
        this.selectRows = selectRows;
    }

    public List<BlogsReadersDto> getListDatatable() {
        return listDatatable;
    }

    public void setListDatatable(List<BlogsReadersDto> listDatatable) {
        this.listDatatable = listDatatable;
    }

}
