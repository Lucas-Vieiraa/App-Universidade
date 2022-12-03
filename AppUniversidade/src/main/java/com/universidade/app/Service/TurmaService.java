package com.universidade.app.Service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.universidade.app.Dto.ResponseDto.TurmaResponseDto;
import com.universidade.app.Dto.RequestDto.TurmaRequestDto;
import com.universidade.app.Model.AlunoModel;
import com.universidade.app.Model.CursoModel;
import com.universidade.app.Model.ProfessorModel;
import com.universidade.app.Model.TurmaModel;
import com.universidade.app.Repository.AlunoRepository;
import com.universidade.app.Repository.CursoRepository;
import com.universidade.app.Repository.ProfessorRepository;
import com.universidade.app.Repository.TurmaRepository;
import com.universidade.app.Service.exceptions.ResourceNotFoundException;
@Service
public class TurmaService {
    private TurmaRepository turmaRepository;
    private AlunoRepository alunoRepository;
    private ProfessorRepository professorRepository;
    private CursoRepository cursoRepository;
    private ModelMapper modelMapper;
    @Autowired
    public TurmaService(TurmaRepository turmaRepository, AlunoRepository alunoRepository, ProfessorRepository professorRepository, CursoRepository cursoRepository, ModelMapper modelMapper) {
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.cursoRepository = cursoRepository;
        this.modelMapper = modelMapper;
    }
    /*
     * Anotação transactional garante que a operação de serviço feche corretamente a
     * transação quando ela executar, (obs:readOnly informa que é apenas uma função
     * de leitura e deixa a transação mais rápida)
     */
    @Transactional(readOnly = true)
    public TurmaResponseDto findById(Long idTurma) {
        TurmaModel turmaModel = turmaRepository.findById(idTurma)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe turma com id : " + idTurma));
        return modelMapper.map(turmaModel, TurmaResponseDto.class);
    }
    @Transactional
    public void deleteById(Long idTurma) {
       TurmaModel turmaModel = turmaRepository.findById(idTurma)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe turma com id : " + idTurma));
        turmaRepository.delete(turmaModel);
    }
    @Transactional
    public TurmaResponseDto updateById(Long idTurma, TurmaRequestDto turmaRequestDto){
        if (turmaRepository.existsById(idTurma)) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            AlunoModel alunoModel = alunoRepository.findById(turmaRequestDto.getIdAluno())
                    .orElseThrow(() -> new ResourceNotFoundException("Não existe aluno com id " + turmaRequestDto.getIdAluno()));
            ProfessorModel professorModel = professorRepository.findById(turmaRequestDto.getIdProfessor())
                    .orElseThrow(() -> new ResourceNotFoundException("Não existe professor com id " + turmaRequestDto.getIdProfessor()));
            CursoModel cursoModel = cursoRepository.findById(turmaRequestDto.getIdCurso())
                    .orElseThrow(() -> new ResourceNotFoundException("Não existe curso com id " + turmaRequestDto.getIdCurso()));
            TurmaModel turmaModel = modelMapper.map(turmaRequestDto, TurmaModel.class);
            turmaModel.setIdTurma(idTurma);
            turmaModel.setAlunoModel(alunoModel);
            turmaModel.setProfessorModel(professorModel);
            turmaModel.setCursoModel(cursoModel);
            return modelMapper.map(turmaRepository.save(turmaModel), TurmaResponseDto.class);
        }
        throw  new ResourceNotFoundException("Não existe turma com id : " + idTurma);
    }
    @Transactional
    public TurmaResponseDto save(TurmaRequestDto turmaRequestDto) {
    	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    	AlunoModel alunoModel = alunoRepository.findById(turmaRequestDto.getIdAluno())
    			.orElseThrow(() -> new ResourceNotFoundException("Não existe aluno com id " + turmaRequestDto.getIdAluno()));
    	ProfessorModel professorModel = professorRepository.findById(turmaRequestDto.getIdProfessor())
    			.orElseThrow(() -> new ResourceNotFoundException("Não existe professor com id " + turmaRequestDto.getIdProfessor()));
    	CursoModel cursoModel = cursoRepository.findById(turmaRequestDto.getIdCurso())
    			.orElseThrow(() -> new ResourceNotFoundException("Não existe curso com id " + turmaRequestDto.getIdCurso()));
    	TurmaModel turmaModel = modelMapper.map(turmaRequestDto, TurmaModel.class);
    	turmaModel.setAlunoModel(alunoModel);
    	turmaModel.setProfessorModel(professorModel);
    	turmaModel.setCursoModel(cursoModel);
        return modelMapper.map(turmaRepository.save(turmaModel),TurmaResponseDto.class);
    }
}
