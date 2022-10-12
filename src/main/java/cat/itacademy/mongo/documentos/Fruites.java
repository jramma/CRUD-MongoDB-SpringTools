package cat.itacademy.mongo.documentos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Fruites")
public class Fruites {
	
	@Id
	private int id;
	
	private String nombre;
	
	private int peso;
	
	public Fruites(int id, String nombre, int peso) {
		this.id = id;
		this.nombre = nombre;
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
	
	
	
}
