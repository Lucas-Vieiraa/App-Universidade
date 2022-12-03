package com.universidade.app.Service;

import com.universidade.app.Dto.RequestDto.FeriadoResquestDto;
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
    /*
     * Anotação transactional garante que a operação de serviço feche corretamente a
     * transação quando ela executar, (obs:readOnly informa que é apenas uma função
     * de leitura e deixa a transação mais rápida)
     */
    @Transactional(readOnly = true)
    public FeriadoResponseDto findById(Date idFeriado) {
       FeriadoModel feriadoModel = feriadoRepository.findById(idFeriado)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe Feriado no dia : " + idFeriado));
        return modelMapper.map(feriadoModel, FeriadoResponseDto.class);
    }
    @Transactional
    public void deleteById(Date idFeriado) {
        FeriadoModel feriadoModel = feriadoRepository.findById(idFeriado)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe Feriado no dia : " + idFeriado));
       feriadoRepository.delete(feriadoModel);
    }
    @Transactional
    public FeriadoResponseDto updateById(Date idFeriado,FeriadoResquestDto feriadoResquestDto) {
        if(feriadoRepository.existsById(idFeriado)) {
            FeriadoModel feriadoModel = modelMapper.map(feriadoResquestDto,FeriadoModel.class);
            feriadoModel.setDataFeriado(idFeriado);
            return modelMapper.map(feriadoRepository.save(feriadoModel),FeriadoResponseDto.class);
        }
        throw  new ResourceNotFoundException("Não existe Feriado no dia : " + idFeriado);
    }
    @Transactional
    public FeriadoResponseDto save(FeriadoResquestDto feriadoResquestDto) {
       FeriadoModel feriadoModel = feriadoRepository.save(modelMapper.map(feriadoResquestDto,FeriadoModel.class));
        return modelMapper.map(feriadoModel,FeriadoResponseDto.class);
    }
}
