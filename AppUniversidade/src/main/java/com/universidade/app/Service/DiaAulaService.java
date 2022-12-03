package com.universidade.app.Service;

import com.universidade.app.Dto.RequestDto.DiaAulaRequestDto;
import com.universidade.app.Dto.ResponseDto.DiaAulaResponseDto;
import com.universidade.app.Model.CursoModel;
import com.universidade.app.Model.DiaAulaModel;
import com.universidade.app.Repository.CursoRepository;
import com.universidade.app.Repository.DiaAulaRepository;
import com.universidade.app.Service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class DiaAulaService {
    private DiaAulaRepository diaAulaRepository;
    private CursoRepository cursoRepository;
    private ModelMapper modelMapper;
    @Autowired
    public DiaAulaService(DiaAulaRepository diaAulaRepository, CursoRepository cursoRepository, ModelMapper modelMapper) {
        this.diaAulaRepository = diaAulaRepository;
        this.cursoRepository = cursoRepository;
        this.modelMapper = modelMapper;
    }
    /*
     * Anotação transactional garante que a operação de serviço feche corretamente a
     * transação quando ela executar, (obs:readOnly informa que é apenas uma função
     * de leitura e deixa a transação mais rápida)
     */
    @Transactional(readOnly = true)
    public DiaAulaResponseDto findById(Long dataAula) {
        DiaAulaModel diaAulaModel = diaAulaRepository.findById(dataAula)
                .orElseThrow(() -> new ResourceNotFoundException("Não terá Aula no dia : " + dataAula));
        return modelMapper.map(diaAulaModel,DiaAulaResponseDto.class);
    }
    @Transactional
    public void deleteById(Long dataAula) {
        DiaAulaModel diaAulaModel = diaAulaRepository.findById(dataAula)
                .orElseThrow(() -> new ResourceNotFoundException("Não terá Aula no dia : " + dataAula));
        diaAulaRepository.delete(diaAulaModel);
    }
    @Transactional
    public DiaAulaResponseDto updateById(Long dataAula, DiaAulaRequestDto diaAulaRequestDto) {
        if (diaAulaRepository.existsById(dataAula)) {
            CursoModel cursoModel = cursoRepository.findById(diaAulaRequestDto.getIdCurso())
                    .orElseThrow(() -> new ResourceNotFoundException("Não existe curso com id " + diaAulaRequestDto.getIdCurso()));
            DiaAulaModel diaAulaModel = modelMapper.map(diaAulaRequestDto, DiaAulaModel.class);
            diaAulaModel.setDataAula(dataAula);
            diaAulaModel.setCursoModel(cursoModel);
            return modelMapper.map(diaAulaRepository.save(diaAulaModel), DiaAulaResponseDto.class);
        } else {
            throw new RuntimeException("Não terá aula no dia : " + dataAula);
        }
    }
    @Transactional
    public DiaAulaResponseDto save(DiaAulaRequestDto diaAulaRequestDto) {
       CursoModel cursoModel = cursoRepository.findById(diaAulaRequestDto.getIdCurso())
                .orElseThrow(() -> new ResourceNotFoundException("Não existe curso com id " + diaAulaRequestDto.getIdCurso()));
        DiaAulaModel diaAulaModel = modelMapper.map(diaAulaRequestDto, DiaAulaModel.class);
        diaAulaModel.setCursoModel(cursoModel);
        return modelMapper.map(diaAulaRepository.save(diaAulaModel), DiaAulaResponseDto.class);
    }
}
