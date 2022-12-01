package com.universidade.app.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "feriado")
public class FeriadoModel implements Serializable {
    private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
private Date dataFeriado;
private String descricao;
}
