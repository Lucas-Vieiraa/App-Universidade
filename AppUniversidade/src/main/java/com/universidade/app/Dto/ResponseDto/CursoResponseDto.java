package com.universidade.app.Dto.ResponseDto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long idCurso;

  private String nomeCurso;
  private Double chAulaCurso;
  private Double chTotalCurso;
  private String turnoCurso;
  private Double valorCurso;
  private Short segundaCurso;
  private Short tercaCurso;
  private Short quartaCurso;
  private Short quintaCurso;
  private Short sextaCurso;
  private Short sabadoCurso;

}
