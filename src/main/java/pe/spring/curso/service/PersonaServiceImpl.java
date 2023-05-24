package pe.spring.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.spring.curso.model.Persona;
import pe.spring.curso.repository.IPersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private IPersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaRepository.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaRepository.findById(persona.getIdPersona()).orElse(null);
    }

}
