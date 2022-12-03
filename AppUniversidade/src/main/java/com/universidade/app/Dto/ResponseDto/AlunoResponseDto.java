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
public class AlunoResponseDto implements Serializable {
   private static final long serialVersionUID = 1L;

   private Long idAluno;
   private String nomeAluno;
   private String telefoneAluno;
   private String enderecoAluno;
   private List<TurmaModel> turmaModels;
}