package com.universidade.app.Dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResquestDto {

    private String nomeAluno;
    private String telefoneAluno;
    private String enderecoAluno;
    private String cpfAluno;
    private Long turmaModels;

}
