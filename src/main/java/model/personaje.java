package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Personaje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPersonaje;
	private String imagen;
	private String nombre;
	private int edad;
	private double peso;
	private String historia;
	
	
}
