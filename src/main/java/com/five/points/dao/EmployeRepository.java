package com.five.points.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.five.points.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
