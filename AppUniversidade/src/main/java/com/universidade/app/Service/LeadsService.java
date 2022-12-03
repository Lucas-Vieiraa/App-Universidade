package com.universidade.app.Service;

import com.universidade.app.Dto.RequestDto.LeadsResquestDto;
import com.universidade.app.Dto.ResponseDto.LeadsResponseDto;
import com.universidade.app.Model.LeadsModel;
import com.universidade.app.Repository.LeadsRepository;
import com.universidade.app.Service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LeadsService {
    private LeadsRepository leadsRepository;
    private ModelMapper modelMapper;

    @Autowired
    public LeadsService(LeadsRepository leadsRepository, ModelMapper modelMapper) {
        this.leadsRepository = leadsRepository;
        this.modelMapper = modelMapper;
    }
    /*
     * Anotação transactional garante que a operação de serviço feche corretamente a
     * transação quando ela executar, (obs:readOnly informa que é apenas uma função
     * de leitura e deixa a transação mais rápida)
     */
    @Transactional(readOnly = true)
    public LeadsResponseDto findById(Long idLead) {
        LeadsModel leadsModel = leadsRepository.findById(idLead)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe Feriado no dia : " + idLead));
        return modelMapper.map(leadsModel, LeadsResponseDto.class);
    }
    @Transactional
    public void deleteById(Long idLead) {
        LeadsModel leadsModel = leadsRepository.findById(idLead)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe Feriado no dia : " + idLead));
        leadsRepository.delete(leadsModel);
    }
    @Transactional
    public LeadsResponseDto updateById(Long idLead, LeadsResquestDto leadsResquestDto) {
        if(leadsRepository.existsById(idLead)) {
            LeadsModel leadsModel = modelMapper.map(leadsResquestDto, LeadsModel.class);
            leadsModel.setIdLeads(idLead);
            return modelMapper.map(leadsRepository.save(leadsModel), LeadsResponseDto.class);
        }
        throw  new ResourceNotFoundException("Não existe Feriado no dia : " + idLead);
    }
    @Transactional
    public LeadsResponseDto save(LeadsResquestDto leadsResquestDto) {
        LeadsModel leadsModel = leadsRepository.save(modelMapper.map(leadsResquestDto, LeadsModel.class));
        return modelMapper.map(leadsModel, LeadsResponseDto.class);
    }
}
