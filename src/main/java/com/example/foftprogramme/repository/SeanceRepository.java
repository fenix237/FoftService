package com.example.foftprogramme.repository;

import com.example.foftprogramme.modele.Salle;
import com.example.foftprogramme.modele.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {

}
