package com.universidade.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.universidade.app.Dto.ResponseDto.TurmaResponseDto;
import com.universidade.app.Dto.RequestDto.TurmaRequestDto;
import com.universidade.app.Service.TurmaService;

@RestController
public class TurmaController {
    @Autowired
    private TurmaService turmaService;
    @GetMapping( "/turmas/{idTurma}")
    public ResponseEntity<TurmaResponseDto> getTurmafindById(@PathVariable Long idTurma) {
        TurmaResponseDto turmaResponseDto = turmaService.findById(idTurma);
            return ResponseEntity.ok().body(turmaResponseDto);
    }
    @DeleteMapping("/turmas/{idTurma}")
    public ResponseEntity<Void> deleteTurmaById(@PathVariable Long idTurma){
            turmaService.deleteById(idTurma);
            return ResponseEntity.noContent().build();
    }
    @PutMapping( "/turmas/{idTurma}")
    public ResponseEntity<TurmaResponseDto> updateTurmaById(@PathVariable Long idTurma, @RequestBody TurmaRequestDto turmaRequestDto){
        TurmaResponseDto turmaResponseDto = turmaService.updateById(idTurma,turmaRequestDto);
        return ResponseEntity.ok().body(turmaResponseDto);
    }
    @PostMapping( "/turmas")
    public ResponseEntity<TurmaResponseDto> saveTurma(@RequestBody TurmaRequestDto turmaRequestDto) {
    	TurmaResponseDto turmaResponseDto = turmaService.save(turmaRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaResponseDto);
    }
}
