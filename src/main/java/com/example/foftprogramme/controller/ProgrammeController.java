package com.example.foftprogramme.controller;

import com.example.foftprogramme.modele.*;
import com.example.foftprogramme.service.ProgrammeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ProgrammeController {

    @Autowired
    private ProgrammeService programmeService;

    @PostMapping("/programme")
    @ResponseBody
    public Programme createProgramme(@RequestParam("heureDeDebut") @DateTimeFormat(pattern = "HH:mm")LocalTime heureDeDebut,
                                     @RequestParam("heureDeFin") @DateTimeFormat(pattern = "HH:mm") LocalTime heureDeFin,
                                     @RequestParam("totalHoraire") String totalHoraire,
                                     @RequestParam("enseignant") Enseignant enseignant,
                                     @RequestParam("ue") UniteEnseignement uniteEnseignement,
                                     @RequestParam("salle") Salle salle,
                                     @RequestParam("seance") Seance seance,
                                     @RequestParam("jour") Jour jour){
        Programme programme = new Programme();
        programme.setJour(jour);
        programme.setEnseignant(enseignant);
        programme.setSalle(salle);
        programme.setHeureDeDebut(heureDeDebut);
        programme.setTotalHoraire(totalHoraire);
        programme.setHeureDeFin(heureDeFin);
        programme.setUe(uniteEnseignement);
        programme.setSeance(seance);
        return programmeService.saveProgramme(programme);
    }

    @GetMapping("/programme/{id}")
    @ResponseBody
    public Optional<Programme> getProgrammes(@PathVariable int id){
        return programmeService.getProgramme(id);
    }

    @GetMapping("/programmes")
    @ResponseBody
    public Iterable<Programme> getProgrammes(){
        return programmeService.getProgrammes();
    }

    @DeleteMapping("/programme/{id}")
    @ResponseBody
    public void deleteProgramme(@PathVariable int id){
         programmeService.deleteProgramme(id);
    }

    @GetMapping("/jourP")
    @ResponseBody
    public List<Programme> verify(){

        return programmeService.findByJour(programmeService.idOfJour(programmeService.getJour()));
    }


    @PutMapping("/programme/{id}")
    @ResponseBody
    public Map<String, String> updateProgramme(@PathVariable int id, @RequestBody Programme programme) {
        Optional<Programme> f = programmeService.getProgramme(id);
        if(f.isPresent()) {
            Programme current = f.get();
                LocalTime heureDeDebut = programme.getHeureDeDebut();
                if(heureDeDebut!=current.getHeureDeDebut()) current.setHeureDeDebut(heureDeDebut);
                LocalTime heureDeFin = programme.getHeureDeFin();
                if(heureDeFin!=current.getHeureDeFin())current.setHeureDeFin(heureDeFin);
                 String totalHoraire = programme.getTotalHoraire();
                if(totalHoraire!= current.getTotalHoraire())current.setTotalHoraire(totalHoraire);
                Enseignant enseignant = programme.getEnseignant();
                if(enseignant!=current.getEnseignant())current.setEnseignant(enseignant);
                UniteEnseignement uniteEnseignement = programme.getUe();
                if(uniteEnseignement!=current.getUe())current.setUe(uniteEnseignement);
                Salle salle = programme.getSalle();
                if(salle!=current.getSalle())current.setSalle(salle);
                Seance seance = programme.getSeance();
                if(seance!=current.getSeance())current.setSeance(seance);
                programmeService.saveProgramme(current);
                return Collections.singletonMap("response", "Programme modifie avec succès");
            }
        else {
            return Collections.singletonMap("response", "Fiche absente");
        }
    }

}
