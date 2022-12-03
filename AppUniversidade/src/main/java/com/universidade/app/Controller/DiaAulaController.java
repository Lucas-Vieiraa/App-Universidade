package com.universidade.app.Controller;

import com.universidade.app.Dto.RequestDto.DiaAulaRequestDto;
import com.universidade.app.Dto.ResponseDto.DiaAulaResponseDto;
import com.universidade.app.Service.DiaAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiaAulaController {
    @Autowired
    private DiaAulaService diaAulaService;

    @GetMapping("/diaAulas/{dataAula}")
    public ResponseEntity<DiaAulaResponseDto> getDiaAulafindById(@PathVariable Long dataAula) {
        DiaAulaResponseDto diaAulaResponseDto = diaAulaService.findById(dataAula);
            return ResponseEntity.ok().body(diaAulaResponseDto);
    }
    @DeleteMapping("/diaAulas/{dataAula}")
    public ResponseEntity<Void> deleteDiaAulaById(@PathVariable Long dataAula){
        diaAulaService.deleteById(dataAula);
        return ResponseEntity.noContent().build();
    }
    @PutMapping( "/diaAulas/{dataAula}")
    public ResponseEntity<DiaAulaResponseDto> updateDiaAulaById(@PathVariable Long dataAula, @RequestBody DiaAulaRequestDto diaAulaRequestDto){
        DiaAulaResponseDto diaAulaResponseDto = diaAulaService.updateById(dataAula,diaAulaRequestDto);
        return ResponseEntity.ok().body(diaAulaResponseDto);
    }
    @PostMapping( "/diaAulas")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DiaAulaResponseDto> saveDiaAula(@RequestBody DiaAulaRequestDto diaAulaRequestDto) {
        DiaAulaResponseDto diaAulaResponseDto = diaAulaService.save(diaAulaRequestDto);
        return ResponseEntity.ok().body(diaAulaResponseDto);
    }
}
