/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.controller;

import com.project.test.dto.BlogsDto;
import com.project.test.facade.BlogsFacade;
import com.project.test.util.JsfUtility;
import com.project.test.util.MessageUtil;
import java.io.Serializable;
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
public class BlogsController implements Serializable {

    @Inject
    private BlogsFacade blogsFacade;

    private BlogsDto blogsDto;
    private List<BlogsDto> blogs;

    @PostConstruct
    public void init() {
        blogsDto = new BlogsDto();
        blogs = blogsFacade.getAll();
    }

    public void cleanNew() {
        this.blogsDto = new BlogsDto();
    }

    public void save() {
        blogsFacade.save(blogsDto);
        JsfUtility.hideDialog("dialogSolicitud");
        MessageUtil.addMessageInfo("Success", null);
        JsfUtility.reloadPagePretty("pretty:blogs");
    }

    public void preEditar(final BlogsDto edit) {
        this.blogsDto = edit;
    }

    public void delete(final BlogsDto delete) {
        blogsFacade.delete(delete.getId());
        JsfUtility.hideDialog("dialogSolicitud");
        MessageUtil.addMessageInfo("Success", null);
        JsfUtility.reloadPagePretty("pretty:blogs");
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

}
