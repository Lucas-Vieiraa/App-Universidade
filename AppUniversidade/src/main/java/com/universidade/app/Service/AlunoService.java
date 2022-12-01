package com.universidade.app.Service;

import com.universidade.app.Dto.RequestDto.AlunoResquestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidade.app.Dto.ResponseDto.AlunoResponseDto;
import com.universidade.app.Model.AlunoModel;
import com.universidade.app.Repository.AlunoRepository;
import com.universidade.app.Service.exceptions.ResourceNotFoundException;


@Service
public class AlunoService {
    private AlunoRepository alunoRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository, ModelMapper modelMapper) {
        this.alunoRepository = alunoRepository;
        this.modelMapper = modelMapper;
    }

     /*Anotação transactional garante que a operação de serviço feche corretamente a transação quando ela
     executar, (obs:readOnly informa que é apenas uma função de leitura e deixa a transação mais rápida)*/
     @Transactional(readOnly = true)
     public AlunoResponseDto findById(Long idAluno) {
    	 AlunoModel alunoModel = alunoRepository.findById(idAluno)
      		   .orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idAluno));
    	 return modelMapper.map(alunoModel, AlunoResponseDto.class);

     }
    @Transactional
    public void deleteById(Long idAluno) {
       AlunoModel alunoModel = alunoRepository.findById(idAluno)
    		   .orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idAluno));
       alunoRepository.delete(alunoModel);
    }
    @Transactional
    public AlunoResponseDto updateById(Long idAluno, AlunoModel alunoUpdate) {
            AlunoModel alunoModel = alunoRepository.findById(idAluno)
            		.orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idAluno));
            alunoModel.setNomeAluno(alunoUpdate.getNomeAluno());
            alunoModel.setTelefoneAluno(alunoUpdate.getTelefoneAluno());
            alunoModel.setEnderecoAluno(alunoUpdate.getEnderecoAluno());
            alunoModel.setCpfAluno(alunoUpdate.getCpfAluno());
            AlunoModel alunoSaved = alunoRepository.save(alunoModel);
            return modelMapper.map(alunoSaved, AlunoResponseDto.class);


    }
        @Transactional
    public AlunoResponseDto save(AlunoResquestDto alunoResquestDto){
         AlunoModel alunoModel = alunoRepository.save(modelMapper.map(alunoResquestDto,AlunoModel.class));
        return modelMapper.map(alunoModel, AlunoResponseDto.class);
        }
}
