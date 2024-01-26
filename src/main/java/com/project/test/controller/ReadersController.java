/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.test.controller;

import com.project.test.dto.ReadersDto;
import com.project.test.facade.ReadersFacade;
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
public class ReadersController implements Serializable {

    @Inject
    private ReadersFacade readersFacade;

    private ReadersDto readersDto;
    private List<ReadersDto> readers;

    @PostConstruct
    public void init() {
        this.readersDto = new ReadersDto();
        readers = readersFacade.getAll();
    }

    public void cleanNew() {
        this.readersDto = new ReadersDto();
    }

    public void save() {
        readersFacade.save(readersDto);
        JsfUtility.hideDialog("dialogSolicitud");
        MessageUtil.addMessageInfo("Success", null);
        JsfUtility.reloadPagePretty("pretty:reader");
    }

    public void preEditar(final ReadersDto readersEdit) {
        this.readersDto = readersEdit;
    }
    
    public void delete(final ReadersDto readersDelete) {
        readersFacade.delete(readersDelete.getId());
        JsfUtility.hideDialog("dialogSolicitud");
        MessageUtil.addMessageInfo("Success", null);
        JsfUtility.reloadPagePretty("pretty:reader");
    }

    public ReadersFacade getReadersFacade() {
        return readersFacade;
    }

    public void setReadersFacade(ReadersFacade readersFacade) {
        this.readersFacade = readersFacade;
    }

    public List<ReadersDto> getReaders() {
        return readers;
    }

    public void setReaders(List<ReadersDto> readers) {
        this.readers = readers;
    }

    public ReadersDto getReadersDto() {
        return readersDto;
    }

    public void setReadersDto(ReadersDto readersDto) {
        this.readersDto = readersDto;
    }

}
