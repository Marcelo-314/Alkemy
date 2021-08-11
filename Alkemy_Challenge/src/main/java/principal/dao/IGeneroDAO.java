package principal.dao;

import java.util.Optional;

//--------------------------------------------------------------------------------------

import org.springframework.data.repository.CrudRepository;

//--------------------------------------------------------------------------------------

import principal.entity.Genero;

//--------------------------------------------------------------------------------------

public interface IGeneroDAO extends CrudRepository<Genero, Long>  {

	Optional<Genero> findGeneroByNombre(String nombre);

	void deleteGeneroByNombre(String nombre);

}
