package com.universidade.app.Repository;

import com.universidade.app.Model.LeadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository <LeadModel, Long> {

}
