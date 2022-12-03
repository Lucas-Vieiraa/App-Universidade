package com.universidade.app.Service;

import com.universidade.app.Dto.RequestDto.ProfessorResquestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.universidade.app.Dto.ResponseDto.ProfessorResponseDto;
import com.universidade.app.Model.ProfessorModel;
import com.universidade.app.Repository.ProfessorRepository;
import com.universidade.app.Service.exceptions.ResourceNotFoundException;

@Service
public class ProfessorService {
	private ProfessorRepository professorRepository;
	private ModelMapper modelMapper;

	@Autowired
	public ProfessorService(ProfessorRepository professorRepository, ModelMapper modelMapper) {
		this.professorRepository = professorRepository;
		this.modelMapper = modelMapper;
	}
	/*
	 * Anotação transactional garante que a operação de serviço feche corretamente a
	 * transação quando ela executar, (obs:readOnly informa que é apenas uma função
	 * de leitura e deixa a transação mais rápida)
	 */
	@Transactional(readOnly = true)
	public ProfessorResponseDto findById(Long idProfessor) {
		ProfessorModel professorModel = professorRepository.findById(idProfessor)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe professor com id : " + idProfessor));
		return modelMapper.map(professorModel, ProfessorResponseDto.class);
	}
	@Transactional
	public void deleteById(Long idProfessor) {
		ProfessorModel professorModel = professorRepository.findById(idProfessor)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe professor com id : " + idProfessor));
		professorRepository.delete(professorModel);
	}
	@Transactional
	public ProfessorResponseDto updateById(Long idProfessor, ProfessorResquestDto professorResquestDto) {
		if(professorRepository.existsById(idProfessor)) {
			ProfessorModel professorModel = modelMapper.map(professorResquestDto,ProfessorModel.class);
			professorModel.setIdProfessor(idProfessor);
			return modelMapper.map(professorRepository.save(professorModel),ProfessorResponseDto.class);
		}
		throw  new ResourceNotFoundException("Não existe professor com id : " + idProfessor);
	}
	@Transactional
	public ProfessorResponseDto save(ProfessorResquestDto professorResquestDto) {
		ProfessorModel professorModel = professorRepository.save(modelMapper.map(professorResquestDto,ProfessorModel.class));
		return modelMapper.map(professorModel, ProfessorResponseDto.class);
	}
}
