package principal.service;

//--------------------------------------------------------------------------------------

import java.util.List;
import java.util.Optional;

//--------------------------------------------------------------------------------------

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//--------------------------------------------------------------------------------------

import principal.dao.IPersonajeDAO;
import principal.entity.Personaje;

//--------------------------------------------------------------------------------------

@Service

public class PersonajeServiceImplementacion implements IPersonajeService {
	
	//--------------------------------------------------------------------------------------
	
	
	@Autowired
	
	private IPersonajeDAO personajeDAO;
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	
	public List<Personaje> findAll() {
		
		return (List<Personaje>) personajeDAO.findAll();
		
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	
	public Personaje findPersonajeByNombre(String nombre) {
		
		return personajeDAO.findPersonajeByNombre(nombre).orElse(null);
		
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	
	public Optional<Personaje> findPersonajeById(Long id) {
		
		return personajeDAO.findById(id);
		
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional
	
	public void savePersonaje(Personaje personaje) {
		
		personajeDAO.save(personaje);
		
	}
	
	//--------------------------------------------------------------------------------------

	@Override
	@Transactional
	
	public Personaje uptadePersonaje(Personaje personaje) {
		
		return (Personaje) personajeDAO.save(personaje);
		
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional
	
	public void deletePersonaje(String nombre) {
		personajeDAO.deletePersonajeByNombre(nombre);
	}
	
	//--------------------------------------------------------------------------------------

}

