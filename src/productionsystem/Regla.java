package productionsystem;

import java.util.ArrayList;
import java.util.List;

public class Regla {
	private int id; //para la no duplicacion
	private int novedad;
	private int prioridad;
	private int especificidad;
	
	
	public Regla() {
		novedad=0;
		prioridad=0;
		especificidad=0;
	}

	public Regla(int id, int novedad, int prioridad, int especificidad) {
		super();
		this.id = id;
		this.novedad = novedad;
		this.prioridad = prioridad;
		this.especificidad = especificidad;
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
	
}
