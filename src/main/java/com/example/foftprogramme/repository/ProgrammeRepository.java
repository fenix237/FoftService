package com.example.foftprogramme.repository;

import com.example.foftprogramme.modele.Jour;
import com.example.foftprogramme.modele.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgrammeRepository extends JpaRepository<Programme, Integer> {

    @Query("select prog from Programme prog inner join Jour jour on jour.id= prog.jour.id where jour.id=:jourId")
    List<Programme> findProgrammeByJour(@Param("jourId") int jourId);
}
