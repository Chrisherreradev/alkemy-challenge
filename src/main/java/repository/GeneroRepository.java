package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long>{

	public Optional<Genero> findById(Long idGenero);
	public Genero getById(Long idGenero);
}
