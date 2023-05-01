package com.example.foftprogramme.proxy;



import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.foftprogramme.modele.Programme;

import java.util.List;



@FeignClient(name = "microservice-Programmes", url = "localhost:9001")
public interface MicroserviceProgrammeProxy {
   @GetMapping(value = "/Programmes")
   List<Programme> listeDesProgrammes();

   @GetMapping( value = "/Programmes/{id}")
   Programme recupererUnProduit(@PathVariable("id") int id);

}