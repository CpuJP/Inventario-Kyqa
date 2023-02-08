package com.inventario.parque.kyqa.InventarioKyqa.Service;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Persona;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface PersonaService {
    List<Persona> findAll();
    ResponseEntity<Persona> findByDocument(@PathVariable String document);
    List<Persona> findPersonasLikeLastName(@PathVariable String lastName);
    ResponseEntity<Persona> existsPerson(@PathVariable String document);
    ResponseEntity<Persona> findById(@PathVariable Integer id);
    ResponseEntity<Persona> createPerson(@RequestBody Persona persona, @RequestHeader HttpHeaders headers);
    ResponseEntity<Persona> updatePerson(@RequestBody Persona persona);
    ResponseEntity<Persona> deletePerson(@PathVariable Integer id);
}
