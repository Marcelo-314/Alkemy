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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//  --------------------------------------------------------------------------------------

import java.io.Serializable;

//  --------------------------------------------------------------------------------------

import java.util.Date;
import java.util.List;

//  --------------------------------------------------------------------------------------

@Entity
@Table (name = "Personajes")

public class Personaje implements Serializable {

	//  --------------------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;

	//  --------------------------------------------------------------------------------------

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column	(name = "Personaje_Id")

	private Long personajeId;

	//  --------------------------------------------------------------------------------------

	@Column (name = "Nombre")

	private String nombre;

	//  --------------------------------------------------------------------------------------

	@Column	(name = "Edad")

	private int edad;

	//  --------------------------------------------------------------------------------------

	@Column (name = "Peso")

	private Long peso;

	//  --------------------------------------------------------------------------------------

	@Column (name = "Foto")

	private String foto;

	//  --------------------------------------------------------------------------------------
	
	@ManyToMany(
			
				targetEntity = Pelicula.class,
			
				mappedBy = "personajesPorPelicula", 
						
				fetch = FetchType.LAZY,
								
				cascade = CascadeType.ALL 
				
				)
	
	List<Pelicula> peliculasPorPersonaje;
	
	//  --------------------------------------------------------------------------------------

	@Column (name = "Created_at")
	@Temporal (TemporalType.DATE)

	private Date createdAt;

	//  --------------------------------------------------------------------------------------

	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}

	//  --------------------------------------------------------------------------------------

	protected Personaje () {}

	//  --------------------------------------------------------------------------------------

	public Personaje (
				
						String nombre,
		
						int edad, 
					
						Long peso, 
					
						String foto
					
					) {
	
						this.nombre = nombre;
		
						this.edad = edad;

						this.peso = peso;
		
						this.foto = foto;
	
	}

	//  --------------------------------------------------------------------------------------

	public Long getId() {
		
		return personajeId;
		
	}

	//  --------------------------------------------------------------------------------------

	public String getNombre() {
		
		return nombre;
	
	}

	//  --------------------------------------------------------------------------------------

	public int getEdad() {
		
		return edad;
		
	}

	//  --------------------------------------------------------------------------------------

	public Long getPeso() {
		
		return peso;
		
	}

	//  --------------------------------------------------------------------------------------

	public String getFoto() {
	
		return foto;
		
	}

	//  --------------------------------------------------------------------------------------

	public Date getCreatedAt() {
		
		return createdAt;
		
	}

	//  --------------------------------------------------------------------------------------

	public void setEdad(int edad) {
		
		this.edad = edad;
		
	}

	//  --------------------------------------------------------------------------------------

	public void setPeso(Long peso) {
		
		this.peso = peso;
		
	}

	//  --------------------------------------------------------------------------------------

	public void setFoto(String foto) {
		
		this.foto = foto;
		
	}

	//  --------------------------------------------------------------------------------------

}
