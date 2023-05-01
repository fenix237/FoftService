package com.example.foftprogramme.modele;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;
@Data
@Entity
@DynamicUpdate
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;




    public Specialite(Integer id, String code, Set<UniteEnseignement> uniteEnseignements) {
        super();
        this.id = id;
        this.code = code;
    }

    public Specialite() {
        super();
    }

}
