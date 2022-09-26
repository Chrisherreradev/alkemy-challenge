package repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long>{

}
