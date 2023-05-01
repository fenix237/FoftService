package com.example.foftprogramme.repository;

import com.example.foftprogramme.modele.Niveau;
import com.example.foftprogramme.modele.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauRepository extends JpaRepository<Niveau, Integer> {

}