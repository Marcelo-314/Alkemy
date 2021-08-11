package principal.service;

//--------------------------------------------------------------------------------------

import java.util.List;
import java.util.Optional;

//--------------------------------------------------------------------------------------

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//--------------------------------------------------------------------------------------

import principal.dao.IGeneroDAO;
import principal.entity.Genero;

//--------------------------------------------------------------------------------------

@Service
public class GeneroServiceImplementacion implements IGeneroService {
	
	//--------------------------------------------------------------------------------------
	
	@Autowired
	
	private IGeneroDAO generoDAO;
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	
	public List<Genero> findAll() {
		
		return (List<Genero>) generoDAO.findAll();
		
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	
	public Optional<Genero> findGeneroByNombre(String nombre) {
		
		return generoDAO.findGeneroByNombre(nombre);
		
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	
	public Optional<Genero> findGeneroById(Long id) {
		
		return generoDAO.findById(id);
		
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional
	
	public void saveGenero(Genero genero) {
		
		generoDAO.save(genero);
		
	}
	
	//--------------------------------------------------------------------------------------

	@Override
	@Transactional
	
	public Genero uptadeGenero(Genero genero) {
		
		return (Genero) generoDAO.save(genero);
		
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional
	
	public void deleteGenero(String nombre) {
		
		generoDAO.deleteGeneroByNombre(nombre);
		
	}
	
	//--------------------------------------------------------------------------------------

}