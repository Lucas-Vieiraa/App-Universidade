package com.universidade.app.Dto.RequestDto;

import com.universidade.app.Model.TurmaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResquestDto {

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
