package com.universidade.app.Service;

import com.universidade.app.Dto.ResponseDto.LeadResponseDto;
import com.universidade.app.Model.LeadModel;
import com.universidade.app.Repository.LeadRepository;
import com.universidade.app.Service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeadService {
    private LeadRepository leadRepository;
    private ModelMapper modelMapper;

    @Autowired
    public LeadService(LeadRepository leadRepository, ModelMapper modelMapper) {
        this.leadRepository = leadRepository;
        this.modelMapper = modelMapper;
    }

    /*Anotação transactional garante que a operação de serviço feche corretamente a transação quando ela
    executar, (obs:readOnly informa que é apenas uma função de leitura e deixa a transação mais rápida)*/
    @Transactional(readOnly = true)
    public LeadResponseDto findById(Long idLead) {
        LeadModel leadModel = leadRepository.findById(idLead)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idLead));
        return modelMapper.map(leadModel, LeadResponseDto.class);

    }
    @Transactional
    public void deleteById(Long idLead) {
        LeadModel leadModel = leadRepository.findById(idLead)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idLead));
        leadRepository.delete(leadModel);
    }
    @Transactional
    public LeadResponseDto updateById(Long idLead, LeadModel lead) {
        LeadModel leadModel = leadRepository.findById(idLead)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe o aluno com id : " + idLead));
        leadModel.setNomeLead(lead.getNomeLead());
        leadModel.setTelefoneLead(lead.getTelefoneLead());
        leadModel.setDataCadastroLead(lead.getDataCadastroLead());
        leadModel.setStatusLead(lead.getStatusLead());
        leadModel.setDataNovoContatoLead(lead.getDataNovoContatoLead());
        leadModel.setObservacaoLead(lead.getObservacaoLead());
        LeadModel leadSaved = leadRepository.save(leadModel);
        return modelMapper.map(leadSaved, LeadResponseDto.class);
    }
    @Transactional
    public LeadResponseDto save(LeadModel lead) {
        LeadModel leadModel = leadRepository.save(lead);
        return modelMapper.map(leadModel, LeadResponseDto.class);
    }
}
