package com.universidade.app.Controller;

import com.universidade.app.Dto.RequestDto.FeriadoResquestDto;
import com.universidade.app.Dto.ResponseDto.FeriadoResponseDto;
import com.universidade.app.Service.FeriadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;


@RestController
public class FeriadoController {
    @Autowired
    private FeriadoService feriadoService;

    @GetMapping("/feriados/{dataFeriado}")
    public ResponseEntity<FeriadoResponseDto> getFeriadofindById(@PathVariable Date dataFeriado) {
        FeriadoResponseDto feriadoResponseDto = feriadoService.findById(dataFeriado);
            return ResponseEntity.ok().body(feriadoResponseDto);
    }
    @DeleteMapping("/feriados/{dataFeriado}")
    public ResponseEntity<Void> deleteFeriadoById(@PathVariable Date dataFeriado){
        feriadoService.deleteById(dataFeriado);
        return ResponseEntity.noContent().build();
    }
    @PutMapping( "/feriados/{dataFeriado}")
    public ResponseEntity<FeriadoResponseDto> updateFeriadoById(@PathVariable Date dataFeriado, @RequestBody FeriadoResquestDto feriadoResquestDto){
        FeriadoResponseDto feriadoResponseDto = feriadoService.updateById(dataFeriado,feriadoResquestDto);
        return ResponseEntity.ok().body(feriadoResponseDto);
    }
    @PostMapping( "/feriados")
    public ResponseEntity<FeriadoResponseDto> saveFeriado(@RequestBody FeriadoResquestDto feriadoResquestDto) {
        FeriadoResponseDto feriadoResponseDto = feriadoService.save(feriadoResquestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(feriadoResponseDto);
    }

}