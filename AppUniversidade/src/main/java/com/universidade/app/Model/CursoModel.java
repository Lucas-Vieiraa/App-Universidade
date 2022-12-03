package com.universidade.app.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curso")
public class CursoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurso;
	private String nomeCurso;
	private Double chAulaCurso;
	private Double chTotalCurso;
	private String turnoCurso;
	private Double valorCurso;
	private Short segundaCurso;
	private Short tercaCurso;
	private Short quartaCurso;
	private Short quintaCurso;
	private Short sextaCurso;
	private Short sabadoCurso;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoModel", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TurmaModel> turmaModels;
}
