package com.universidade.app.Dto.ResponseDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeriadoResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private Date dataFeriado;
	private String descricaoFeriado;

}
