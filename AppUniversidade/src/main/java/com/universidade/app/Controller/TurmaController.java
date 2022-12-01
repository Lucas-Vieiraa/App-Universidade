package com.universidade.app.Controller;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.universidade.app.Dto.ResponseDto.TurmaResponseDto;
import com.universidade.app.Dto.RequestDto.TurmaRequestDto;
import com.universidade.app.Model.TurmaModel;
import com.universidade.app.Service.TurmaService;

@RestController
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping( "/turmas/{idTurma}")
    public ResponseEntity<TurmaModel> getTurmafindById(@PathVariable Long idTurma) {
        TurmaModel turmaModel = turmaService.findById(idTurma);
        if (Objects.nonNull(turmaModel)) {
            return ResponseEntity.ok().body(turmaModel);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/turmas/{idTurma}")
    public ResponseEntity<TurmaResponseDto> deleteTurmaById(@PathVariable Long idTurma){
        TurmaResponseDto turmaResponseDto = turmaService.deleteById(idTurma);
        if (Objects.nonNull(turmaResponseDto)){
            return ResponseEntity.ok().body(turmaResponseDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping( "/turmas/{idTurma}")
    public ResponseEntity<TurmaResponseDto> updateTurmaById(@PathVariable Long idTurma, @RequestBody TurmaResponseDto turmaResponseDto){
        return ResponseEntity.ok(turmaService.updateById(idTurma, turmaResponseDto));
    }

    @PostMapping( "/turmas")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TurmaResponseDto> saveTurma(@RequestBody TurmaRequestDto turmaRequestDto) {
    	TurmaResponseDto turmaResponseDto = turmaService.save(turmaRequestDto);
        return ResponseEntity.ok().body(turmaResponseDto);
    }

}
