package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PeliculaSerie {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long idPelicula;
		private String imagen;
		private String titulo;
		private Date fechaCreacion;
		private byte calificacion;
		
}
