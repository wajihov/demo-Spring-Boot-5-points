package com.five.points.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.five.points.entities.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
