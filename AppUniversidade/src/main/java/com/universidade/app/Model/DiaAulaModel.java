package com.universidade.app.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "diaaula")
public class DiaAulaModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataAula;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_curso")
    private CursoModel cursoModel;
}
