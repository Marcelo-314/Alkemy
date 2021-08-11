package principal.service;

//--------------------------------------------------------------------------------------

import java.util.List;
import java.util.Optional;

//--------------------------------------------------------------------------------------

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//--------------------------------------------------------------------------------------

import principal.dao.IPeliculaDAO;
import principal.entity.Pelicula;

//--------------------------------------------------------------------------------------

@Service
public class PeliculaServiceImplementacion implements IPeliculaService {
	
	//--------------------------------------------------------------------------------------
	
	
	@Autowired
	private IPeliculaDAO peliculaDAO;
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> findAll() {
		return (List<Pelicula>) peliculaDAO.findAll();
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Pelicula> findPeliculaByTitulo(String titulo) {
		return peliculaDAO.findPeliculaByTitulo(titulo);
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Pelicula> findPeliculaById(Long id) {
		return peliculaDAO.findById(id);
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional
	public void savePelicula(Pelicula pelicula) {
		peliculaDAO.save(pelicula);
	}
	
	//--------------------------------------------------------------------------------------

	@Override
	@Transactional
	public Pelicula uptadePelicula(Pelicula pelicula) {
		return (Pelicula) peliculaDAO.save(pelicula);
	}
	
	//--------------------------------------------------------------------------------------
	
	@Override
	@Transactional
	public void deletePelicula(String titulo) {
		peliculaDAO.deletePeliculaByTitulo(titulo);
	}
	
	//--------------------------------------------------------------------------------------

}
