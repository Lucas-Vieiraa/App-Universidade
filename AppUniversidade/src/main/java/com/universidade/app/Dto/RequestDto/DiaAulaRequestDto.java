package com.universidade.app.Dto.RequestDto;

import com.universidade.app.Model.CursoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaAulaRequestDto {

    private Long dataAula;
    private Long idCurso;
}
