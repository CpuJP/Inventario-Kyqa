package com.inventario.parque.kyqa.InventarioKyqa.Controller;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Persona;
import com.inventario.parque.kyqa.InventarioKyqa.Exception.MessageConflictException;
import com.inventario.parque.kyqa.InventarioKyqa.Repository.PersonaRepository;
import com.inventario.parque.kyqa.InventarioKyqa.Service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persona")
@Slf4j
public class PersonaController {

    private PersonaRepository personaRepository;
    private PersonaService personService;
    public PersonaController(PersonaRepository personaRepository, PersonaService personService) {
        this.personaRepository = personaRepository;
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<Persona> findAll() {
        return personService.findAll();
    }

    @GetMapping("findbyid/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Integer id) {
        return personService.findById(id);
    }

    @GetMapping("/findbydocument/{document}")
    public ResponseEntity<Persona> findByDocument(@PathVariable String document) {
        return personService.findByDocument(document);
    }

    @GetMapping("/findpersonaslikelastname/{lastName}")
    public List<Persona> findPersonasLikeLastName(@PathVariable String lastName){
        return personService.findPersonasLikeLastName(lastName);
    }

    @GetMapping("/existspersonbydocument/{document}")
    public ResponseEntity<Persona> existsPerson(@PathVariable String document) {
        return personService.existsPerson(document);
    }

    @PostMapping("/createperson")
    public ResponseEntity<Persona> save(@RequestBody Persona persona, @RequestHeader HttpHeaders headers) {
        return personService.createPerson(persona, headers);
    }
}
