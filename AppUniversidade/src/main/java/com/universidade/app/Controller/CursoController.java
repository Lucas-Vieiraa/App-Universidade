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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.universidade.app.Dto.ResponseDto.CursoResponseDto;
import com.universidade.app.Model.CursoModel;
import com.universidade.app.Service.CursoService;

@RestController
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping("/cursos/{idCurso}")
	public ResponseEntity<CursoResponseDto> getCursofindById(@PathVariable Long idCurso) {
		CursoResponseDto cursoResponseDto = cursoService.findById(idCurso);
		return ResponseEntity.ok().body(cursoResponseDto);
	}

	@DeleteMapping("/cursos/{idCurso}")
	public ResponseEntity<Void> deleteCursoById(@PathVariable Long idCurso) {
		cursoService.deleteById(idCurso);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/cursos/{idCurso}")
	public ResponseEntity<CursoResponseDto> updateCursoById(@PathVariable Long idCurso, @RequestBody CursoModel curso) {
		CursoResponseDto cursoResponseDto = cursoService.updateById(idCurso, curso);
		return ResponseEntity.ok().body(cursoResponseDto);
	}

	@PostMapping("/cursos")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CursoResponseDto> saveCurso(@RequestBody CursoModel curso) {
		CursoResponseDto cursoResponseDto = cursoService.save(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoResponseDto);
	}
}
