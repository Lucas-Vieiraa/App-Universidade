package com.universidade.app.Dto.ResponseDto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LeadResponseDto implements Serializable {
  private static final long serialVersionUID = 1L;

private Long id;
private String nomeLead;
private String telefoneLead;
private Date dataCadastroLead;
private String statusLead;
private Date dataNovoContatoLead;
private String observacaoLead;

}

