package cat.itacademy.mongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.mongo.documentos.Fruites;
import cat.itacademy.mongo.repository.FruitaRepositorio;

@RestController
@RequestMapping("/Fruita")
public class FruitaController {

	@Autowired
	private FruitaRepositorio repo;
	
	@PostMapping
	public ResponseEntity<?> saveUsuario( @RequestBody Fruites fruita){
		ResponseEntity<?> respuesta = null;
		try {
			Fruites fruitaGuardada = repo.save(fruita);
			respuesta = new ResponseEntity <Fruites> (fruitaGuardada, HttpStatus.CREATED);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;
		
	}
	
	
	
	
}
