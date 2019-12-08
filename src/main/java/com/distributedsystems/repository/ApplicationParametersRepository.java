package com.distributedsystems.repository;

import com.distributedsystems.model.ApplicationParameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationParametersRepository extends JpaRepository<ApplicationParameters, Long> {

    ApplicationParameters findById(long id);
}
