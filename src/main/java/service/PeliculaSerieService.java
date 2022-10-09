package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import model.PeliculaSerie;
import repository.PeliculaSerieRepository;

@Service
public class PeliculaSerieService {

@Autowired
private PeliculaSerieRepository peliculaSerieRepository;

public List<PeliculaSerie>findAll(Sort sort){
	return peliculaSerieRepository.findAll();
}
public Optional<PeliculaSerie>findById(Long idPelicula){
	return peliculaSerieRepository.findById(idPelicula);
}
public List<PeliculaSerie>findByTitle(String titulo){
	return peliculaSerieRepository.findByTitle(titulo);
}
public PeliculaSerie save(PeliculaSerie peliculaSerie) {
	return peliculaSerieRepository.save(peliculaSerie);
}
public List<PeliculaSerie>getByOrder(String orden){
	if(orden.equals("ASC")) {
		return peliculaSerieRepository.getAllByOrderAsc();
	}else if(orden.equals("DESC")) {
		return peliculaSerieRepository.getAllByOrderDesc();
	}else {
		return peliculaSerieRepository.getAll();
	}
}
public boolean delete(Long idPelicula) {
	try {
		peliculaSerieRepository.deleteById(idPelicula);
		return true;
	}catch(Exception e) {
		return false;
	}
}
}
