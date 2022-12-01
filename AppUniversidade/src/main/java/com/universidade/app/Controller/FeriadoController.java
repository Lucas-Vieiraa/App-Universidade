package com.universidade.app.Controller;

import com.universidade.app.Dto.ResponseDto.FeriadoResponseDto;
import com.universidade.app.Model.FeriadoModel;
import com.universidade.app.Service.FeriadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Objects;

@RestController
public class FeriadoController {
    @Autowired
    private FeriadoService feriadoService;


    @GetMapping("/feriados/{dataFeriado}")
    public ResponseEntity<FeriadoResponseDto> getFeriadofindById(@PathVariable Date dataFeriado) {
        FeriadoResponseDto feriadoResponseDto = feriadoService.findById(dataFeriado);
        if (Objects.nonNull(feriadoResponseDto)) {
            return ResponseEntity.ok().body(feriadoResponseDto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/feriados/{dataFeriado}")
    public ResponseEntity<Void> deleteFeriadoById(@PathVariable Date dataFeriado){
        feriadoService.deleteById(dataFeriado);
        return ResponseEntity.noContent().build();
    }

    @PutMapping( "/feriados/{dataFeriado}")
    public ResponseEntity<FeriadoResponseDto> updateFeriadoById(@PathVariable Date dataFeriado, @RequestBody FeriadoModel feriado){
        FeriadoResponseDto feriadoResponseDto = feriadoService.updateById(dataFeriado, feriado);
        return ResponseEntity.ok().body(feriadoResponseDto);
    }

    @PostMapping( "/feriados")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FeriadoResponseDto> saveFeriado(@RequestBody FeriadoModel feriado) {
        FeriadoResponseDto feriadoResponseDto = feriadoService.save(feriado);
        return ResponseEntity.ok().body(feriadoResponseDto);
    }

}