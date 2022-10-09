package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Personaje;
import service.PersonajeService;

@RequestMapping("/characters")
@Controller
public class PersonajeController {

@Autowired
private PersonajeService personajeService;

@GetMapping()
private ResponseEntity<List<Personaje>> getAll(){
	return ResponseEntity.ok(personajeService.findAll(null));
}
@GetMapping("/{id}")
private Optional<Personaje> findById(@PathVariable("id")Long idPersonaje){
	return personajeService.findById(idPersonaje);
}
@GetMapping(params="name")
private List<Personaje> findByName(@RequestParam("nombre")String nombre){
	return personajeService.findByName(nombre);
}
}
