package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idGenero;
	private String nombre;
	private String imagen;
	
	@OneToMany
	@JoinColumn(name="idPelicula")
	private PeliculaSerie peliculaSerie;
	private List<PeliculaSerie>peliculaSerieId;
}
