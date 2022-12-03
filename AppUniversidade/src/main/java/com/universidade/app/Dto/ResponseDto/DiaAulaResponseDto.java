package com.universidade.app.Dto.ResponseDto;

import com.universidade.app.Model.CursoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaAulaResponseDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long dataAula;
  private CursoModel cursoModel;

}






