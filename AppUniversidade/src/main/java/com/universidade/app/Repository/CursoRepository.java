package com.universidade.app.Repository;

import com.universidade.app.Model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository <CursoModel, Long> {

}