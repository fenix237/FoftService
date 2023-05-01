package com.example.foftprogramme.service;

import com.example.foftprogramme.modele.Programme;
import com.example.foftprogramme.repository.ProgrammeRepository;
import lombok.Data;
import org.hibernate.cfg.annotations.reflection.internal.XMLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class ProgrammeService {
    @Autowired
    private ProgrammeRepository programmeRepository;

   

    public Optional<Programme> getProgramme(Integer id){
        return programmeRepository.findById(id);
    }

    public Iterable<Programme> getProgrammes(){
        return programmeRepository.findAll();
    }

    public void deleteProgramme (Integer id){
        programmeRepository.deleteById(id);
    }

    public Programme saveProgramme ( Programme programme){
        Programme saved = programmeRepository.save(programme);
        return saved;
    }

    public int idOfJour (String jour){
        int id;
        switch (jour){
            case "lundi": id = 1;
            break;
            case "mardi": id =2;
            break;
            case "mercredi": id =3;
            break;
            case "jeudi": id = 4;
            break;
            case "vendredi": id = 5;
            break;
            case "samedi": id = 6;
            break;
            case "dimanche": id =7;
            break;
            default: id=0;
        }
        System.out.println(id);
        return id;
    }


    public List<Programme> findByJour (int jourId) {return programmeRepository.findProgrammeByJour(jourId);}


    Date aujourdhui = new Date();
    private static final SimpleDateFormat formater = new SimpleDateFormat("EEEE");
    private static final SimpleDateFormat heureFormat = new SimpleDateFormat("HH:mm");
    String jour = formater.format(aujourdhui);




    // @Scheduled(cron = "0 59 23 * * ?") // Exécute tous les jours à 23 h 59 min
    // public void planifierRattrapage() {
    //     List<Fiche> fiches = ficheService.findByState(0);
    //     for(Fiche fiche : fiches) fiche.setState(3);
    // }
//    @Scheduled(cron = "0 59 23 * * L") // Exécute le dernier jour de la semaine à 23 h 59 min
//    public void planifierEchec() {
//        List<Fiche> fiches = ficheService.findByState(0);
//        for(Fiche fiche : fiches) fiche.setState(3);
//    }

    // @Scheduled(fixedRate = 60000) // Exécute toutes les 30 secondes
    // public void genererFiche() throws ParseException {

    //     List<Programme> programmes = findByJour(idOfJour(jour));
    //     for (Programme programme : programmes){
    //         String heureDebut = heureFormat.format(heureFormat.parse(programme.getHeureDeDebut().toString()));
    //         int specialiteId = programme.getUe().getSpecialite().getId();
    //         int niveauId = programme.getUe().getNiveau().getId();
    //         if(heureDebut.equals(heureFormat.format(new Date()))){
    //             List<Delegue> delegues = delegueRepository.getAllBySpecialiteAndNiveau(specialiteId,niveauId);
    //                 ficheService.createFiche(programme,programme.getUe().getNiveau(), programme.getUe().getSpecialite(), programme.getSeance(), delegues);
    //         }
    //     }


    // }

}



