package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Genero;
import model.PeliculaSerie;
import repository.GeneroRepository;

@Service
public class GeneroService {

@Autowired
private GeneroRepository generoRepository;

public Optional<Genero> findById(Long idGenero){
	return generoRepository.findById(idGenero);
}
public boolean delete(Long idGenero) {
	try {
		generoRepository.deleteById(idGenero);
		return true;
	}catch (Exception e){
		return false;
	}
}
public Genero save(Genero genero) {
	return generoRepository.save(genero);
}
public List<PeliculaSerie> getMovieByGenre(Long IdGenero){
	Genero genero = generoRepository.getById(IdGenero);
	if(genero!=null) {
		List<PeliculaSerie> peliculaSerie = genero.getPeliculaSerieId();
		return peliculaSerie;
	}else {
		return null;
	}
}
}
