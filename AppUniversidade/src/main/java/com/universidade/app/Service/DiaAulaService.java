package com.universidade.app.Service;

import com.universidade.app.Dto.RequestDto.DiaAulaRequestDto;
import com.universidade.app.Dto.ResponseDto.DiaAulaResponseDto;
import com.universidade.app.Model.CursoModel;
import com.universidade.app.Model.DiaAulaModel;
import com.universidade.app.Model.TurmaModel;
import com.universidade.app.Repository.CursoRepository;
import com.universidade.app.Repository.DiaAulaRepository;
import com.universidade.app.Service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



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

    /*Anotação transactional garante que a operação de serviço feche corretamente a transação quando ela
    executar, (obs:readOnly informa que é apenas uma função de leitura e deixa a transação mais rápida)*/
    @Transactional(readOnly = true)
    public DiaAulaModel findById(Long dataAula) {
        DiaAulaModel diaAulaModel = diaAulaRepository.findById(dataAula)
                .orElseThrow(()-> new RuntimeException());
        return diaAulaModel;
    }
    @Transactional
    public DiaAulaResponseDto deleteById(Long dataAula) {
        if (diaAulaRepository.existsById(dataAula)) {
            diaAulaRepository.deleteById(dataAula);
        } else {
            throw new RuntimeException("Usuário não existe");
        }
        return null;
    }
    @Transactional
    public DiaAulaResponseDto updateById(Long dataAula, DiaAulaResponseDto diaAulaResponseDto) {
        if (diaAulaRepository.existsById(dataAula)) {
            DiaAulaModel diaAulaModel = modelMapper.map(diaAulaResponseDto, DiaAulaModel.class);
            diaAulaModel.setDataAula(dataAula);
            return modelMapper.map(diaAulaRepository.save(diaAulaModel), DiaAulaResponseDto.class);
        } else {
            throw new RuntimeException("Usuário não existe");
        }
    }
    @Transactional
    public DiaAulaResponseDto save(DiaAulaRequestDto diaAulaRequestDto) {
       CursoModel cursoModel = cursoRepository.findById(diaAulaRequestDto.getIdCurso())
                .orElseThrow(() -> new ResourceNotFoundException("Não existe curso com id " + diaAulaRequestDto.getIdCurso()));
        DiaAulaModel diaAulaModel = modelMapper.map(diaAulaRequestDto, DiaAulaModel.class);
        diaAulaModel.setIdCurso(cursoModel);
        DiaAulaModel modelSaved = diaAulaRepository.save(diaAulaModel);
        return modelMapper.map(modelSaved, DiaAulaResponseDto.class);
    }
}
