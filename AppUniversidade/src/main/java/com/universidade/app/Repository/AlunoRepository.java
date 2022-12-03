package com.universidade.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.universidade.app.Model.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository <AlunoModel, Long> {

}
