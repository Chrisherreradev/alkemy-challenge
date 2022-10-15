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

import model.PeliculaSerie;
import service.GeneroService;
import service.PeliculaSerieService;

@RequestMapping("/movies")
@Controller
public class PeliculaSerieController {

@Autowired
private PeliculaSerieService peliculaSerieService;

@Autowired
private GeneroService generoService;

@GetMapping()
private ResponseEntity<List<PeliculaSerie>> getAll(){
	return ResponseEntity.ok(peliculaSerieService.findAll(null));
}
@GetMapping("/{id}")
private Optional<PeliculaSerie> findById(@PathVariable("id")Long idPelicula){
	return peliculaSerieService.findById(idPelicula);
}
@GetMapping(params="title")
private List<PeliculaSerie> findByTitle(@RequestParam("title")String titulo){
	return peliculaSerieService.findByTitle(titulo);
}
@GetMapping(value="", params="genre")
private List<PeliculaSerie> getByGenre(@RequestParam("genre")Long idGenero){
	return generoService.getMovieByGenre(idGenero);
}
@DeleteMapping(path="delete/{id}")
private String delete(@PathVariable("id")Long idPelicula) {
	try {
		peliculaSerieService.delete(idPelicula);
		return "Movie/Series deleted succesfully!";
	}catch (Exception e) {
		return "Couldn't delete Movie/Series";
	}
}
@PostMapping
private PeliculaSerie save(@RequestParam("file")MultipartFile imagen,@ModelAttribute PeliculaSerie peliculaSerie) {
	if(!imagen.isEmpty()) {
		Path imagesPath=Paths.get("src/main/resources/static/imagenes");
		String absolutPath=imagesPath.toFile().getAbsolutePath();
		try {
			byte[] bytes=imagen.getBytes();
			Path route=Paths.get(absolutPath + imagen.getOriginalFilename());
			Files.write(route, bytes);
			peliculaSerie.setImagen(imagen.getOriginalFilename());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	return peliculaSerieService.save(peliculaSerie);
}
}
