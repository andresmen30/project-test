/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.dao;

import com.project.test.entity.Blogs;
import java.util.List;

/**
 *
 * @author andresmendez
 */
public interface IBlogsDao {

    List<Blogs> getAll();

    void save(final Blogs blogs);

    void delete(final Long id);
    
    List<Blogs> getBlogs(final Long readerId);

}
