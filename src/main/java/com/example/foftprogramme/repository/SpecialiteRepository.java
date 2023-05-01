package com.example.foftprogramme.repository;

import com.example.foftprogramme.modele.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite,Integer> {

//    @Query("select specialite from  Specialite specialite inner join Niveau ni on ni.id= specialite.niveau.id where ni.id=:niveau_id")
//    List<Specialite> findByNiveau(Integer niveau);

}
