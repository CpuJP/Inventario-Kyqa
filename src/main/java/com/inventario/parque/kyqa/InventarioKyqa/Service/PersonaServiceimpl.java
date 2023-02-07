package com.inventario.parque.kyqa.InventarioKyqa.Service;

import com.inventario.parque.kyqa.InventarioKyqa.Entity.Persona;
import com.inventario.parque.kyqa.InventarioKyqa.Exception.MessageBadRequestException;
import com.inventario.parque.kyqa.InventarioKyqa.Exception.MessageConflictException;
import com.inventario.parque.kyqa.InventarioKyqa.Repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "personaService")
@Slf4j
public class PersonaServiceimpl implements PersonaService {

    private PersonaRepository personaRepository;

    public PersonaServiceimpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public ResponseEntity<Persona> findByDocument(String document) {
        Optional<Persona> persona = personaRepository.findByDocumento(document);
        return persona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public List<Persona> findPersonasLikeLastName(String lastName) {
        return personaRepository.findByPrimerApellidoLike(lastName);
    }


    @Override
    public ResponseEntity<Persona> existsPerson(String document) {
        if (!personaRepository.existsPersonaByDocumento(document)) {
            log.warn("El documento " + document + " no existe");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Persona> findById(Integer id) {
        Optional<Persona> persona = personaRepository.findById(id);
        return persona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Persona> createPerson(Persona persona, HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if (persona.getDocumento() == null || persona.getPrimerNombre() == null || persona.getPrimerApellido() == null) {
            log.warn("El documento, el primer nombre y el primer apellido son obligatorios");
            throw  new MessageBadRequestException("El documento, el primer nombre y el primer apellido son obligatorios");
        }
        String validarCelular = persona.getCelular();
        if (personaRepository.existsPersonaByCelular(validarCelular)) {
            log.warn("El celular " + validarCelular + " ya existe");
            throw new MessageConflictException("El celular " + validarCelular + " ya existe");
        }
        String validarDocumento = persona.getDocumento();
        if (personaRepository.existsPersonaByDocumento(validarDocumento)) {
            log.warn("El documento " + validarDocumento + " ya existe");
            throw new MessageConflictException("El documento " + validarDocumento + " ya existe");
        }
        Persona result = personaRepository.save(persona);
        return ResponseEntity.ok(result);
    }
}
