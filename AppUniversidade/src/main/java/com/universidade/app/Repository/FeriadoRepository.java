package com.universidade.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.universidade.app.Model.FeriadoModel;
import java.sql.Date;

@Repository
public interface FeriadoRepository extends JpaRepository <FeriadoModel, Date> {

	
}
