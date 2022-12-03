package com.universidade.app.Dto.ResponseDto;

import java.io.Serializable;
import java.util.List;
import com.universidade.app.Model.TurmaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idProfessor;
	private String nomeProfessor;
	private String telefoneProfessor;
	private Double valorHoraAulaProfessor;
	private List<TurmaModel> turmaModels;
}
