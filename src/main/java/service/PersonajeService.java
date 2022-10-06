package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import model.Personaje;
import repository.PersonajeRepository;

@Service
public class PersonajeService {

@Autowired
private PersonajeRepository personajeRepository;

public List<Personaje>findAll(Sort sort){
	return personajeRepository.findAll();
}
public Optional<Personaje> findById(Long idPersonaje){
	return personajeRepository.findById(idPersonaje);
}
public List<Personaje> findByName(String nombre){
	return personajeRepository.findByName(nombre);
}
public List<Personaje> findByAge(int edad){
	return personajeRepository.findByAge(edad);
}
public boolean delete(Long idPersonaje) {
	try {
		personajeRepository.deleteById(idPersonaje);
		return true;
	}catch(Exception e) {
		return false;
	}
}
public Personaje save(Personaje personaje) {
	return personajeRepository.save(personaje);
}
}
