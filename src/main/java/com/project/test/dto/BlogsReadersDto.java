/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.dto;

/**
 *
 * @author andresmendez
 */
public class BlogsReadersDto {

    private Long id;
    private ReadersDto reader;
    private BlogsDto blog;

    public BlogsReadersDto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReadersDto getReader() {
        return reader;
    }

    public void setReader(ReadersDto reader) {
        this.reader = reader;
    }

    public BlogsDto getBlog() {
        return blog;
    }

    public void setBlog(BlogsDto blog) {
        this.blog = blog;
    }

}
