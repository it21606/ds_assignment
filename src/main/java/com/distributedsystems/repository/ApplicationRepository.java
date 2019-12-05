package com.distributedsystems.repository;

import com.distributedsystems.model.Application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

   //region Basic CRUD operations
    Application findById(int id);

    List<Application> findAll();
   //endregion
}