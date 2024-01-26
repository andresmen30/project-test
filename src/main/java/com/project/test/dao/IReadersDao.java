/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.dao;

import com.project.test.entity.Readers;
import java.util.List;

/**
 *
 * @author andresmendez
 */
public interface IReadersDao {
    
    
    List<Readers> getAll();
    
    
    void save(final Readers readers);
    
    
    void delete(final Long id);
   
    
    
  
    
}
