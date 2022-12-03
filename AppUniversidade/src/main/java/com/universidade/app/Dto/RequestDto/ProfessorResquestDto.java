package com.universidade.app.Dto.RequestDto;

import com.universidade.app.Model.TurmaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorResquestDto {

    private String nomeProfessor;
    private String telefoneProfessor;
    private Double valorHoraAulaProfessor;
}
