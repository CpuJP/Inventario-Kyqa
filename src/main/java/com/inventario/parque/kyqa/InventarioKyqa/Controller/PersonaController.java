package com.inventario.parque.kyqa.InventarioKyqa.Controller;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Persona;
import com.inventario.parque.kyqa.InventarioKyqa.Repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persona")
@Slf4j
public class PersonaController {

    private PersonaRepository personaRepository;

    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @GetMapping("/all")
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Long id) {
        Optional<Persona> personaOpt = personaRepository.findById(id);
        return personaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
