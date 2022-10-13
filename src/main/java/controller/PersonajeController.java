package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
@GetMapping(params="age")
private List<Personaje> findByAge(@RequestParam("edad")Integer edad){
	return personajeService.findByAge(edad);
}
@DeleteMapping(path="delete/{id}")
private String delete(@PathVariable("id")Long idPersonaje) {
	try {
	personajeService.delete(idPersonaje);
	return "Character deleted succesfully!";
	} catch (Exception e) {
		return "Couldn't delete character!";
	} 
}
@PostMapping
private Personaje save(@RequestParam("file")MultipartFile imagen,@ModelAttribute Personaje personaje) {
	if(!imagen.isEmpty()) {
		Path imagesPath=Paths.get("src/main/resources/static/imagenes");
		String absolutPath=imagesPath.toFile().getAbsolutePath();
		try {
			byte[] bytes=imagen.getBytes();
			Path route=Paths.get(absolutPath + imagen.getOriginalFilename());
			Files.write(route, bytes);
			personaje.setImagen(imagen.getOriginalFilename());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	return personajeService.save(personaje);
}
}
