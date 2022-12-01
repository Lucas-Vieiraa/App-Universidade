package com.universidade.app.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "turma")
public class TurmaModel implements Serializable {
 private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idTurma;

 private Double valorTurma;
 
 @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
 @JoinColumn(name = "fk_aluno")
 @JsonIgnore
 private AlunoModel alunoModel;
 
 @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
 @JoinColumn(name = "fk_professor")
 @JsonIgnore
 private ProfessorModel professorModel;
 
 @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
 @JoinColumn(name = "fk_curso")
 @JsonIgnore
 private CursoModel cursoModel;
 
}

