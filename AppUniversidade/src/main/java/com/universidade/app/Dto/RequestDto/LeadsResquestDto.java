package com.universidade.app.Dto.RequestDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadsResquestDto {

    private String nomeLeads;
    private String telefoneLeads;
    private Date dataCadastroLeads;
    private String statusLeads;
    private Date dataNovoContatoLeads;
    private String observacaoLeads;
}
