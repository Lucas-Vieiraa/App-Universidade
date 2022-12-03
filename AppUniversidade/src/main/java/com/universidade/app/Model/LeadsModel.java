package com.universidade.app.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leads")
public class LeadsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

