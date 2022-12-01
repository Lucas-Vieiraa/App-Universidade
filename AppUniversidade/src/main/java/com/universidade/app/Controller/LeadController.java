package com.universidade.app.Controller;

import com.universidade.app.Dto.ResponseDto.LeadResponseDto;
import com.universidade.app.Model.LeadModel;
import com.universidade.app.Service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class LeadController {

    @Autowired
    private LeadService leadService;


    @GetMapping("/leads/{idLead}")
    public ResponseEntity<LeadResponseDto> getLeadfindById(@PathVariable Long idLead) {
        LeadResponseDto leadResponseDto = leadService.findById(idLead);
        if (Objects.nonNull(leadResponseDto)) {
            return ResponseEntity.ok().body(leadResponseDto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/leads/{idLead}")
    public ResponseEntity<Void> deleteLeadById(@PathVariable Long idLead){
        leadService.deleteById(idLead);
        return ResponseEntity.noContent().build();
    }

    @PutMapping( "/leads/{idLead}")
    public ResponseEntity<LeadResponseDto> updateLeadById(@PathVariable Long idLead, @RequestBody LeadModel lead){
        LeadResponseDto leadResponseDto = leadService.updateById(idLead, lead);
        return ResponseEntity.ok().body(leadResponseDto);
    }

    @PostMapping( "/leads")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LeadResponseDto> saveLead(@RequestBody LeadModel lead) {
        LeadResponseDto leadResponseDto = leadService.save(lead);
        return ResponseEntity.ok().body(leadResponseDto);
    }

}
