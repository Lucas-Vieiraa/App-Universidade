package com.universidade.app.Dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeriadoResquestDto {

    private Date dataFeriado;
    private Long descricaoFeriado;
}
