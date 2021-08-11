package principal.dao;

import java.util.Optional;

//--------------------------------------------------------------------------------------

import org.springframework.data.repository.CrudRepository;

//--------------------------------------------------------------------------------------

import principal.entity.Personaje;

//--------------------------------------------------------------------------------------

public interface IPersonajeDAO extends CrudRepository<Personaje, Long> {

	Optional<Personaje> findPersonajeByNombre(String nombre);

	void deletePersonajeByNombre(String nombre);

}
