package principal.entity;

import javax.persistence.CascadeType;

//  --------------------------------------------------------------------------------------

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table (name = "Generos")

public class Genero implements Serializable {

	//  --------------------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;
	
	//  --------------------------------------------------------------------------------------

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column	(name = "Genero_Id")
	
	private Long generoId;

	//  --------------------------------------------------------------------------------------

	@Column (name = "Nombre")

	private String nombre;

	//  --------------------------------------------------------------------------------------

	@Column (name = "Foto")

	private String foto;

	//  --------------------------------------------------------------------------------------

	@OneToMany (
			
				targetEntity = Pelicula.class, 
			
				mappedBy = "genero",
						
				fetch = FetchType.LAZY,
						
				cascade = CascadeType.ALL
				
				)
	
	private List<Pelicula> peliculasPorGenero;

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

	protected Genero () {}

	//  --------------------------------------------------------------------------------------

	public Genero (
		
					String nombre, 
		
					String foto
		
				) {
	
					this.nombre = nombre;
		
					this.foto = foto;
	
	}

	//  --------------------------------------------------------------------------------------

	public Long getId() {
		
		return generoId;
		
	}

	//  --------------------------------------------------------------------------------------

	public String getFoto() {
		
		return foto;
		
	}

	//  --------------------------------------------------------------------------------------
	
	public List<Pelicula> getPeliculas() {
		
		return peliculasPorGenero;
		
	}

	//  --------------------------------------------------------------------------------------

	public Date getCreatedAt() {
		
		return createdAt;
		
	}

	//  --------------------------------------------------------------------------------------

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	}

	//  --------------------------------------------------------------------------------------

	public void setFoto(String foto) {
		
		this.foto = foto;
		
	}

	//  --------------------------------------------------------------------------------------

}
