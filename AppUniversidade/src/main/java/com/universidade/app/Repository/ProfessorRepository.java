package com.universidade.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.universidade.app.Model.ProfessorModel;


@Repository
public interface ProfessorRepository extends JpaRepository <ProfessorModel, Long> {

}
