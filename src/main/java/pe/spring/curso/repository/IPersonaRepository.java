package pe.spring.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.spring.curso.model.Persona;

public interface IPersonaRepository extends JpaRepository <Persona, Integer>{
    
}
