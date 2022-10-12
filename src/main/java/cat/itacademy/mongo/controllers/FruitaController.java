package cat.itacademy.mongo.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.mongo.documentos.Fruites;
import cat.itacademy.mongo.repository.FruitaRepositorio;

@RestController
@RequestMapping("/Fruita")
public class FruitaController {

	@Autowired
	private FruitaRepositorio repo;
	
	@PostMapping("/add")
	public ResponseEntity<?> saveFruita( @RequestBody Fruites fruita){
		ResponseEntity<?> respuesta = null;
		try {
			Fruites fruitaGuardada = repo.save(fruita);
			respuesta = new ResponseEntity <Fruites> (fruitaGuardada, HttpStatus.CREATED);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllFruita(){
		ResponseEntity<?> respuesta = null;
		try {
			List <Fruites> fruites= repo.findAll();
			respuesta = new ResponseEntity <List<Fruites>> (fruites, HttpStatus.OK);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateFruita(@RequestBody Fruites fruita){
		ResponseEntity<?> respuesta = null;
		try {
			Fruites fruitaGuardada = repo.save(fruita);
			respuesta = new ResponseEntity <Fruites> (fruitaGuardada, HttpStatus.CREATED);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;
		
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<?> deleteFruita(@PathVariable("id") Integer id){
		ResponseEntity<?> respuesta = null;
		try {
			repo.deleteById(id);
			respuesta = new ResponseEntity <String> (repo.findById(id).toString()+" deleted", HttpStatus.OK);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;
		
	}
	
	@GetMapping(value="/getOne/{id}")
	public ResponseEntity<?> getOneFruita(@PathVariable("id") Integer id){
		ResponseEntity<?> respuesta = null;
		try {
			Optional<Fruites> fruita = repo.findById(id);

			respuesta = new ResponseEntity (fruita, HttpStatus.OK);
		}catch(Exception e) {
			respuesta = new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return respuesta;
		
	}
	
	
}
