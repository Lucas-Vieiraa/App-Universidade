package com.universidade.app.Dto.ResponseDto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.universidade.app.Model.AlunoModel;
import com.universidade.app.Model.CursoModel;
import com.universidade.app.Model.ProfessorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idTurma;
	private Double valorTurma;
	private AlunoModel alunoModel;
	private ProfessorModel professorModel;
	private CursoModel cursoModel;
}
