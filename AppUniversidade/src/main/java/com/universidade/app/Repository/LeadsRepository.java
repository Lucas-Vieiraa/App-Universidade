package com.universidade.app.Repository;

import com.universidade.app.Model.LeadsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadsRepository extends JpaRepository <LeadsModel, Long> {

}
