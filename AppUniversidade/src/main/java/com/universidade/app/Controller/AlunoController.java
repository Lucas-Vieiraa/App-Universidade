package com.universidade.app.Controller;

import com.universidade.app.Dto.RequestDto.AlunoResquestDto;
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
import com.universidade.app.Dto.ResponseDto.AlunoResponseDto;
import com.universidade.app.Service.AlunoService;

@RestController
public class AlunoController {

   @Autowired
   private AlunoService alunoService;

   @GetMapping("/alunos/{idAluno}")
   public ResponseEntity<AlunoResponseDto> getAlunofindById(@PathVariable Long idAluno) {
      AlunoResponseDto alunoResponseDto = alunoService.findById(idAluno);
         return ResponseEntity.ok().body(alunoResponseDto);
   }
    @DeleteMapping("/alunos/{idAluno}")
   public ResponseEntity<Void> deleteAlunoById(@PathVariable Long idAluno){
    alunoService.deleteById(idAluno);
         return ResponseEntity.noContent().build();
   }
   @PutMapping( "/alunos/{idAluno}")
   public ResponseEntity<AlunoResponseDto> updateAlunoById(@PathVariable Long idAluno, @RequestBody AlunoResquestDto alunoResquestDto){
	   AlunoResponseDto alunoResponseDto = alunoService.updateById(idAluno,alunoResquestDto);
      return ResponseEntity.ok().body(alunoResponseDto);
   }
   @PostMapping( "/alunos")
   public ResponseEntity<AlunoResponseDto> saveAluno(@RequestBody AlunoResquestDto alunoResquestDto) {
      AlunoResponseDto alunoResponseDto = alunoService.save(alunoResquestDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(alunoResponseDto);
   }
}
