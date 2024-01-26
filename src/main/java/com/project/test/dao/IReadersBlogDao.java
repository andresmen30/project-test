/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.dao;

import com.project.test.entity.BlogsReaders;
import java.util.List;

/**
 *
 * @author andresmendez
 */
public interface IReadersBlogDao {
    
    
    List<BlogsReaders> getAll();
    
    
    void save(final BlogsReaders blogsReaders) ;
    
    
    void delete(final Long id);
   
    
    
  
    
}
