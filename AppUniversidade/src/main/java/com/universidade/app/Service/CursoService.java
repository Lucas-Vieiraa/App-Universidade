package com.universidade.app.Service;

import com.universidade.app.Dto.RequestDto.CursoResquestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidade.app.Dto.ResponseDto.CursoResponseDto;
import com.universidade.app.Model.CursoModel;
import com.universidade.app.Repository.CursoRepository;
import com.universidade.app.Service.exceptions.ResourceNotFoundException;
import org.springframework.ui.Model;

@Service
public class CursoService {
	private CursoRepository cursoRepository;
	private ModelMapper modelMapper;
	@Autowired
	public CursoService(CursoRepository cursoRepository, ModelMapper modelMapper) {
		this.cursoRepository = cursoRepository;
		this.modelMapper = modelMapper;
	}
	/*
	 * Anotação transactional garante que a operação de serviço feche corretamente a
	 * transação quando ela executar, (obs:readOnly informa que é apenas uma função
	 * de leitura e deixa a transação mais rápida)
	 */
	@Transactional(readOnly = true)
	public CursoResponseDto findById(Long idCurso) {
		CursoModel cursoModel = cursoRepository.findById(idCurso)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe o curso com id : " + idCurso));
		return modelMapper.map(cursoModel, CursoResponseDto.class);
	}
	@Transactional
	public void deleteById(Long idCurso) {
		CursoModel cursoModel = cursoRepository.findById(idCurso)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe o curso com id : " + idCurso));
		cursoRepository.delete(cursoModel);
	}
	@Transactional
    public CursoResponseDto updateById(Long idCurso, CursoResquestDto cursoResquestDto) {
    	     if (cursoRepository.existsById(idCurso)){
     		  CursoModel cursoModel = modelMapper.map(cursoResquestDto,CursoModel.class);
			  cursoModel.setIdCurso(idCurso);
			  return modelMapper.map( cursoRepository.save(cursoModel), CursoResponseDto.class);
		}
			 throw new ResourceNotFoundException("Não existe curso com id: " + idCurso);
    }
	@Transactional
	public CursoResponseDto save(CursoResquestDto cursoResquestDto) {
		CursoModel cursoModel = cursoRepository.save(modelMapper.map(cursoResquestDto, CursoModel.class));
		return modelMapper.map(cursoModel, CursoResponseDto.class);
	}
}
