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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "aluno")
public class AlunoModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;
	private String nomeAluno;
	private String telefoneAluno;
	private String enderecoAluno;
	@JsonIgnore
	private String cpfAluno;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "alunoModel", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TurmaModel> turmaModels;
}