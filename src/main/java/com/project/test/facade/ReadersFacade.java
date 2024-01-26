/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.facade;

import com.project.test.conversor.ReadersConversor;
import com.project.test.dao.IReadersDao;
import com.project.test.dto.ReadersDto;
import com.project.test.entity.Readers;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author andresmendez
 */
@Stateless
public class ReadersFacade implements Serializable {
    
    @Inject
    private IReadersDao readersDao;
    
    @Inject
    private ReadersConversor conversor;
    
    public List<ReadersDto> getAll() {
        return conversor.getListFromEntity(readersDao.getAll());
    }
    
    public void save(final ReadersDto readersDto) {
        final Readers entity = conversor.getFromDto(readersDto);
        readersDao.save(entity);
    }
    
    public void delete(final Long id) {
        readersDao.delete(id);
    }
    
}
