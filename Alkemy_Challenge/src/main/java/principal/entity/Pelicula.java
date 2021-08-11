package principal.entity;

//--------------------------------------------------------------------------------------

import javax.persistence.CascadeType;

//  --------------------------------------------------------------------------------------

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//  --------------------------------------------------------------------------------------

import principal.generales.Calificacion;

//  --------------------------------------------------------------------------------------

import java.io.Serializable;

//  --------------------------------------------------------------------------------------

import java.util.Date;
import java.util.List;

//  --------------------------------------------------------------------------------------

@Entity
@Table (name = "Peliculas")

public class Pelicula implements Serializable {

	//  --------------------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	//  --------------------------------------------------------------------------------------

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column	(name = "Pelicula_Id")

	private Long peliculaId;

	//  --------------------------------------------------------------------------------------

	@Column (name = "Titulo")

	private String titulo;

	//  --------------------------------------------------------------------------------------

	@Column	(name = "Calificacion")

	private Enum<Calificacion> calificacion;

	//  --------------------------------------------------------------------------------------

	@Column (name = "Foto")

	private String foto;

	//  --------------------------------------------------------------------------------------

	@ManyToOne(fetch = FetchType.LAZY)
    
	private Genero genero;

	//  --------------------------------------------------------------------------------------
	
	@ManyToMany(
			
				targetEntity = Personaje.class, 
			
				fetch = FetchType.LAZY,
				
				cascade = CascadeType.ALL
				
				)
	
	private List<Personaje> personajesPorPelicula;
	
	//  --------------------------------------------------------------------------------------
	
	@Column (name = "Created_at")
	@Temporal (TemporalType.DATE)

	private Date createdAt;

	//--------------------------------------------------------------------------------------

	@PrePersist
	
	public void prePersist() {
		
		createdAt = new Date();
	}

	//  --------------------------------------------------------------------------------------

	protected Pelicula () {}

	//  --------------------------------------------------------------------------------------

	public Pelicula (
		
						String titulo, 
		
						Calificacion calificacion, 
		
						String foto
		
					) {
	
						this.titulo = titulo;
	
						this.calificacion = calificacion;
	
						this.foto = foto;	
	}

	//  --------------------------------------------------------------------------------------

	public Long getId() {
		
		return peliculaId;
	}

	//  --------------------------------------------------------------------------------------

	public String getTitulo() {
		
		return titulo;
	}

	//  --------------------------------------------------------------------------------------

	public String getFoto() {
		
		
		return foto;
	}

	//  --------------------------------------------------------------------------------------

	public Calificacion getCalificacion() {
		
		return (Calificacion) calificacion;
}

	//  --------------------------------------------------------------------------------------

	public Genero getGenero() {
		
		return genero;
		
	}
	
	//  --------------------------------------------------------------------------------------
	
	public Date getCreatedAt() {
		
		return createdAt;
	}

	//  --------------------------------------------------------------------------------------

	public List<Personaje> getPersonajesPorPelicula() {
		
		return personajesPorPelicula;
	}
	
	//  --------------------------------------------------------------------------------------
	
	public void setTitulo(String titulo) {
		
		this.titulo = titulo;
	}

	//  --------------------------------------------------------------------------------------

	public void setFoto(String foto) {
		
		this.foto = foto;
	}

	//  --------------------------------------------------------------------------------------

	public void SetCalificacion(Calificacion calificacion) {
		
		this.calificacion = calificacion;
	}

	//  --------------------------------------------------------------------------------------

	public void SetGenero(Genero genero) {
		
		this.genero = genero;
	}

	//  --------------------------------------------------------------------------------------

}
