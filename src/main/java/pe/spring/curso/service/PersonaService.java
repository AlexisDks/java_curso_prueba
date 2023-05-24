package pe.spring.curso.service;

import java.util.List;

import pe.spring.curso.model.Persona;

public interface PersonaService {
    public List<Persona> listarPersonas();

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona encontrarPersona(Persona persona);
}
