package principal.dao;

import java.util.List;
import java.util.Optional;

//--------------------------------------------------------------------------------------

import org.springframework.data.repository.CrudRepository;

//--------------------------------------------------------------------------------------

import principal.entity.Pelicula;

//--------------------------------------------------------------------------------------

public interface IPeliculaDAO extends CrudRepository<Pelicula, Long> {

	Optional<Pelicula> findPeliculaByTitulo(String titulo);

	void deletePeliculaByTitulo(String titulo);
	
	List<Pelicula> findPeliculaByGeneroId(Long generoId );

}
