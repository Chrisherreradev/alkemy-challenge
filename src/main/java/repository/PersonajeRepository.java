package repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long>{

	public List<Personaje> findByName(String nombre);

	public List<Personaje> findByAge(int edad);

}
