package principal.controller;

//  --------------------------------------------------------------------------------------

import java.util.List;

//  --------------------------------------------------------------------------------------

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//  --------------------------------------------------------------------------------------

import principal.entity.Personaje;
import principal.service.IPersonajeService;

//  --------------------------------------------------------------------------------------

@RestController
@RequestMapping("/api")

public class PersonajeRestController {
	
//  --------------------------------------------------------------------------------------

	@Autowired
	
	private IPersonajeService personajeService;
	
//  --------------------------------------------------------------------------------------
	
	@PostMapping("/sign_up")
	
	public ResponseEntity<Void> addPersonaje(@RequestBody Personaje personaje){
		
			if(personajeService.findPersonajeByNombre(personaje.getNombre())==null) {
				
				personajeService.savePersonaje(personaje);
				
				return new ResponseEntity<Void>(HttpStatus.CREATED);
			
			}else {
			
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
//  --------------------------------------------------------------------------------------
	
	@GetMapping("/personajes")
	@ResponseStatus(HttpStatus.OK)
	
	public List<Personaje> getPersonaje() {
		
			return personajeService.findAll();
			
	}
	
//  --------------------------------------------------------------------------------------
	
	@PostMapping("/find_personaje")
	
	public ResponseEntity<?> findPersonaje(@RequestBody Personaje personaje){
		
			Personaje personajeDB = personajeService.findPersonajeByNombre(personaje.getNombre());
			
			if(personajeDB!=null) {
				
				return new ResponseEntity<>(personajeDB, HttpStatus.OK);
			
			}else {

				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
	}
	
//  --------------------------------------------------------------------------------------
	
	@PutMapping("/update/{nombre}")
	
	public ResponseEntity<?> updatePersonaje(
			
			@PathVariable(value="nombre") String nombre,
			@RequestBody Personaje personaje
			
		){
			
			Personaje personajeDB = null;
			personajeDB = personajeService.findPersonajeByNombre(nombre);
			
			if(personajeDB != null) {
				
				personajeDB.setEdad(personaje.getEdad());
				personajeDB.setPeso(personaje.getPeso());
				personajeDB.setFoto(personaje.getFoto());
				personajeService.uptadePersonaje(personajeDB);
			
				return new ResponseEntity<>(personajeDB, HttpStatus.OK);
			
			}else {
			
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
	}
	
//  --------------------------------------------------------------------------------------
	
	@DeleteMapping("/delete/{nombre}")
	
	public ResponseEntity<Void> deletePersonaje(@PathVariable(value="nombre") String nombre){
		
			personajeService.deletePersonaje(nombre);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
//  --------------------------------------------------------------------------------------

}

