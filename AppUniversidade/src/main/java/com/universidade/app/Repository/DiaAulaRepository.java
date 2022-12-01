package com.universidade.app.Repository;

import com.universidade.app.Model.DiaAulaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiaAulaRepository extends JpaRepository <DiaAulaModel, Long> {

}
