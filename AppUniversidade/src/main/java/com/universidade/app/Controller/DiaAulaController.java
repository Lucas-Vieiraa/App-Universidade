package com.universidade.app.Controller;

import com.universidade.app.Dto.RequestDto.DiaAulaRequestDto;
import com.universidade.app.Dto.ResponseDto.DiaAulaResponseDto;
import com.universidade.app.Model.DiaAulaModel;
import com.universidade.app.Service.DiaAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;


@RestController
public class DiaAulaController {
    @Autowired
    private DiaAulaService diaAulaService;

    @GetMapping("/diaAulas/{dataAula}")
    public ResponseEntity<DiaAulaModel> getDiaAulafindById(@PathVariable Long dataAula) {
        DiaAulaModel diaAulaModel = diaAulaService.findById(dataAula);
        if (Objects.nonNull(diaAulaModel)) {
            return ResponseEntity.ok().body(diaAulaModel);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/diaAulas/{dataAula}")
    public ResponseEntity<Void> deleteDiaAulaById(@PathVariable Long dataAula){
        diaAulaService.deleteById(dataAula);
        return ResponseEntity.noContent().build();
    }

    @PutMapping( "/diaAulas/{dataAula}")
    public ResponseEntity<DiaAulaResponseDto> updateDiaAulaById(@PathVariable Long dataAula, @RequestBody DiaAulaResponseDto diaAula){
        DiaAulaResponseDto diaAulaResponseDto = diaAulaService.updateById(dataAula, diaAula);
        return ResponseEntity.ok().body(diaAulaResponseDto);
    }

    @PostMapping( "/diaAulas")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DiaAulaResponseDto> saveDiaAula(@RequestBody DiaAulaRequestDto diaAula) {
        DiaAulaResponseDto diaAulaResponseDto = diaAulaService.save(diaAula);
        return ResponseEntity.ok().body(diaAulaResponseDto);
    }
}
