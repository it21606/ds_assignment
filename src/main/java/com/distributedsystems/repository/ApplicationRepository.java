package com.distributedsystems.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.distributedsystems.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

   //region Basic CRUD operations
    Application findById(int id);

    List<Application> findAll();


   //endregion
}