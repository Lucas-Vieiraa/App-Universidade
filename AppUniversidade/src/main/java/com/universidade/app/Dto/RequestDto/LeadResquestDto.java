package com.universidade.app.Dto.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadResquestDto {

    private String nomeLead;
    private String telefoneLead;
    private Date dataCadastroLead;
    private String statusLead;
    private Date dataNovoContatoLead;
    private String observacaoLead;
}
