package com.universidade.app.Controller;

import com.universidade.app.Dto.RequestDto.LeadsResquestDto;
import com.universidade.app.Dto.ResponseDto.LeadsResponseDto;
import com.universidade.app.Service.LeadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LeadsController {

    @Autowired
    private LeadsService leadsService;

    @GetMapping("/leads/{idLead}")
    public ResponseEntity<LeadsResponseDto> getLeadfindById(@PathVariable Long idLead) {
        LeadsResponseDto leadsResponseDto = leadsService.findById(idLead);
        return ResponseEntity.ok().body(leadsResponseDto);
    }
    @DeleteMapping("/leads/{idLead}")
    public ResponseEntity<Void> deleteLeadById(@PathVariable Long idLead){
        leadsService.deleteById(idLead);
        return ResponseEntity.noContent().build();
    }
    @PutMapping( "/leads/{idLead}")
    public ResponseEntity<LeadsResponseDto> updateLeadById(@PathVariable Long idLead, @RequestBody LeadsResquestDto leadsResquestDto){
        LeadsResponseDto leadsResponseDto = leadsService.updateById(idLead, leadsResquestDto);
        return ResponseEntity.ok().body(leadsResponseDto);
    }
    @PostMapping( "/leads")
    public ResponseEntity<LeadsResponseDto> saveLead(@RequestBody LeadsResquestDto leadsResquestDto) {
        LeadsResponseDto leadsResponseDto = leadsService.save(leadsResquestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(leadsResponseDto);
    }

}
