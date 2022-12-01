package com.universidade.app.Service;

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
	private ProfessorRepository ProfessorRepository;
	private ModelMapper modelMapper;

	@Autowired
	public ProfessorService(ProfessorRepository ProfessorRepository, ModelMapper modelMapper) {
		this.ProfessorRepository = ProfessorRepository;
		this.modelMapper = modelMapper;
	}

	/*
	 * Anotação transactional garante que a operação de serviço feche corretamente a
	 * transação quando ela executar, (obs:readOnly informa que é apenas uma função
	 * de leitura e deixa a transação mais rápida)
	 */
	@Transactional(readOnly = true)
	public ProfessorResponseDto findById(Long idProfessor) {
		ProfessorModel professorModel = ProfessorRepository.findById(idProfessor)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idProfessor));
		return modelMapper.map(professorModel, ProfessorResponseDto.class);

	}

	@Transactional
	public void deleteById(Long idProfessor) {
		ProfessorModel ProfessorModel = ProfessorRepository.findById(idProfessor)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idProfessor));
		ProfessorRepository.delete(ProfessorModel);
	}

	@Transactional
	public ProfessorResponseDto updateById(Long idProfessor, ProfessorModel professor) {
		ProfessorModel professorModel = ProfessorRepository.findById(idProfessor)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idProfessor));
		professorModel.setNomeProfessor(professor.getNomeProfessor());
		professorModel.setTelefoneProfessor(professor.getTelefoneProfessor());
		professorModel.setValorHoraAulaProfessor(professor.getValorHoraAulaProfessor());
		ProfessorModel professorSaved = ProfessorRepository.save(professorModel);
		return modelMapper.map(professorSaved, ProfessorResponseDto.class);

	}

	@Transactional
	public ProfessorResponseDto save(ProfessorModel professor) {
		ProfessorModel professorModel = ProfessorRepository.save(professor);
		return modelMapper.map(professorModel, ProfessorResponseDto.class);
	}
}
