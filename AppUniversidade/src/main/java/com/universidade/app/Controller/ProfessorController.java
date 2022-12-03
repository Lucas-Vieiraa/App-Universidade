package com.universidade.app.Controller;

import com.universidade.app.Dto.RequestDto.ProfessorResquestDto;
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
import com.universidade.app.Dto.ResponseDto.ProfessorResponseDto;
import com.universidade.app.Service.ProfessorService;

@RestController
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@GetMapping(value = "/professores/{idProfessor}")
	public ResponseEntity<ProfessorResponseDto> getProfessorById(@PathVariable Long idProfessor) {
		ProfessorResponseDto professorResponseDto = professorService.findById(idProfessor);
		return ResponseEntity.ok().body(professorResponseDto);
	}
	@DeleteMapping(value = "/professores/{idProfessor}")
	public ResponseEntity<Void> deleteProfessorById(@PathVariable Long idProfessor) {
		professorService.deleteById(idProfessor);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/professores/{idProfessor}")
	public ResponseEntity<ProfessorResponseDto> updateProfessorById(@PathVariable Long idProfessor, @RequestBody ProfessorResquestDto professorResquestDto) {
		ProfessorResponseDto professorResponseDto = professorService.updateById(idProfessor, professorResquestDto);
		return ResponseEntity.ok().body(professorResponseDto);
	}
	@PostMapping("/professores")
   public ResponseEntity<ProfessorResponseDto> saveProfessor(@RequestBody ProfessorResquestDto professorResquestDto){
     ProfessorResponseDto professorResponseDto = professorService.save(professorResquestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(professorResponseDto);
   }
}
