package com.universidade.app.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidade.app.Dto.ResponseDto.CursoResponseDto;
import com.universidade.app.Model.CursoModel;
import com.universidade.app.Repository.CursoRepository;
import com.universidade.app.Service.exceptions.ResourceNotFoundException;

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
    public CursoResponseDto updateById(Long idCurso, CursoModel curso) {
    	CursoModel cursoModel = cursoRepository.findById(idCurso)
     		   .orElseThrow(() -> new ResourceNotFoundException("Não existe o curso com id : " + idCurso));
    		cursoModel.setNomeCurso(curso.getNomeCurso());
    		cursoModel.setChAulaCurso(curso.getChAulaCurso());
    		cursoModel.setChTotalCurso(curso.getChTotalCurso());
    		cursoModel.setTurnoCurso(curso.getTurnoCurso());
    		cursoModel.setValorCurso(curso.getValorCurso());
    		cursoModel.setSegundaCurso(curso.getSegundaCurso());
    		cursoModel.setTercaCurso(curso.getTercaCurso());
    		cursoModel.setQuartaCurso(curso.getQuartaCurso());
    		cursoModel.setQuintaCurso(curso.getQuintaCurso());
    		cursoModel.setSextaCurso(curso.getSextaCurso());
    		cursoModel.setSabadoCurso(curso.getSabadoCurso());
            CursoModel cursoSaved = cursoRepository.save(cursoModel);
            return modelMapper.map(cursoSaved, CursoResponseDto.class);
    }

	@Transactional
	public CursoResponseDto save(CursoModel curso) {
		CursoModel cursoModel = cursoRepository.save(curso);
		return modelMapper.map(cursoModel, CursoResponseDto.class);
	}
}
