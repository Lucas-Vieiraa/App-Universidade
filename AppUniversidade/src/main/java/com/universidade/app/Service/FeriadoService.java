package com.universidade.app.Service;

import com.universidade.app.Dto.ResponseDto.FeriadoResponseDto;
import com.universidade.app.Model.FeriadoModel;
import com.universidade.app.Repository.FeriadoRepository;
import com.universidade.app.Service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
@Service
public class FeriadoService {

    private FeriadoRepository feriadoRepository;
    private ModelMapper modelMapper;

    @Autowired
    public FeriadoService(FeriadoRepository feriadoRepository, ModelMapper modelMapper) {
        this.feriadoRepository = feriadoRepository;
        this.modelMapper = modelMapper;
    }

    /*Anotação transactional garante que a operação de serviço feche corretamente a transação quando ela
    executar, (obs:readOnly informa que é apenas uma função de leitura e deixa a transação mais rápida)*/
    @Transactional(readOnly = true)
    public FeriadoResponseDto findById(Date idFeriado) {
       FeriadoModel feriadoModel = feriadoRepository.findById(idFeriado)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idFeriado));
        return modelMapper.map(feriadoModel, FeriadoResponseDto.class);
    }

    @Transactional
    public void deleteById(Date idFeriado) {
        FeriadoModel feriadoModel = feriadoRepository.findById(idFeriado)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idFeriado));
       feriadoRepository.delete(feriadoModel);
    }

    @Transactional
    public FeriadoResponseDto updateById(Date idFeriado, FeriadoModel feriado) {
        FeriadoModel feriadoModel = feriadoRepository.findById(idFeriado)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idFeriado));
        feriadoModel.setDataFeriado(feriado.getDataFeriado());
        feriadoModel.setDescricao(feriado.getDescricao());
        FeriadoModel feriadoSaved = feriadoRepository.save(feriadoModel);
        return modelMapper.map(feriadoSaved, FeriadoResponseDto.class);
    }

    @Transactional
    public FeriadoResponseDto save(FeriadoModel feriado) {
       FeriadoModel feriadoModel = feriadoRepository.save(feriado);
        return modelMapper.map(feriadoModel, FeriadoResponseDto.class);
    }

}
