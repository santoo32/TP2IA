package productionsystem;

import java.util.ArrayList;
import java.util.List;

public class Regla {
	private List<String> condicion;
	private String respuesta;
	private int id; //para la no duplicacion
	private int novedad;
	private int prioridad;
	private int especificidad;
	
	
	public Regla() {
		novedad=0;
		prioridad=0;
		especificidad=0;
		condicion = new ArrayList<String>();
	}
	public Regla(List<String> condicion, String respuesta) {
		novedad=0;
		prioridad=0;
		especificidad=condicion.size();
		this.condicion = condicion;
		this.respuesta=respuesta;
	}

	public Regla(List<String> condicion, String respuesta, int id, int novedad, int prioridad, int especificidad) {
		super();
		this.condicion = condicion;
		this.respuesta = respuesta;
		this.id = id;
		this.novedad = novedad;
		this.prioridad = prioridad;
		this.especificidad = especificidad;
	}
	public List<String> getCondicion() {
		return condicion;
	}
	public void setCondicion(List<String> condicion) {
		this.condicion = condicion;
		this.especificidad = condicion.size();
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNovedad() {
		return novedad;
	}
	public void setNovedad(int novedad) {
		this.novedad = novedad;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public int getEspecificidad() {
		return especificidad;
	}
	public void setEspecificidad(int especificidad) {
		this.especificidad = especificidad;
	}
	
	public String toString() {
		String rpta = "Condicion: " +this.condicion.toString() + " Respuesta: "+this.respuesta; 
		return rpta; 
	}
	
	public boolean verificaCondicion (ArrayList<String> palabras) {
		int cantPalabras = palabras.size();
		int contador = 0;
		for(String s1 : palabras) {
			for(String s2 : this.condicion) {
				if(s1.equals(s2)) contador++;
			}
		}
		if(contador == cantPalabras) return true;
		else return false;
	}
	
}
