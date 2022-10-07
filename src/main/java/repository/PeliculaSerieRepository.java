package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.PeliculaSerie;

@Repository
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long>{

	public List<PeliculaSerie> findByTitle(String titulo);

	@Query(value="SELECT imagen, titulo, fechaCreacion FROM Peli_Serie ORDER BY fechaCreacion Asc")
	public List<PeliculaSerie> getAllByOrderAsc();

	@Query(value="SELECT imagen, titulo, fechaCreacion FROM Peli_Serie ORDER BY fechaCreacion Desc")
	public List<PeliculaSerie> getAllByOrderDesc();
	public PeliculaSerie getById(Long idPelicula);

	@Query(value="SELECT imagen, titulo, fechaCreacion FROM Peli_Serie")
	public List<PeliculaSerie> getAll();

}
