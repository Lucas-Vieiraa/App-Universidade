package com.universidade.app.Dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaRequestDto {

	 private Double valorTurma;
	 private Long idAluno;
	 private Long idProfessor;
	 private Long idCurso;
}
