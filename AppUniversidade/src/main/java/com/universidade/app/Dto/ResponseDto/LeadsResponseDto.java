package com.universidade.app.Dto.ResponseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class LeadsResponseDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long idLeads;
  private String nomeLeads;
  private String telefoneLeads;
  @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
  private Date dataCadastroLeads;
  private String statusLeads;
  @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
  private Date dataNovoContatoLeads;
  private String observacaoLeads;
}

