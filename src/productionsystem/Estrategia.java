package productionsystem;

import java.util.List;

public class Estrategia {
	private TipoEstrategia tipoEstrategia;
	private List<Regla> reglasDisponibles;

	public Estrategia(TipoEstrategia tipoEstrategia) {
		super();
		this.tipoEstrategia = tipoEstrategia;
	}
	
	
	
	public TipoEstrategia getTipoEstrategia() {
		return tipoEstrategia;
	}



	public void setTipoEstrategia(TipoEstrategia tipoEstrategia) {
		this.tipoEstrategia = tipoEstrategia;
	}



	public List<Regla> getReglasDisponibles() {
		return reglasDisponibles;
	}



	public void setReglasDisponibles(List<Regla> reglasDisponibles) {
		this.reglasDisponibles = reglasDisponibles;
	}



	public Regla buscarRegla() {
		Regla r = new Regla();
		switch(tipoEstrategia) {
		case ALEATORIO: 
			Aleatorio a = new Aleatorio();
			r = a.random(reglasDisponibles);
			break;
		case NOVEDAD:
			break;
		case ESPECIFICIDAD:
			break;
		case PRIORIDAD:
			break;
		case NODUPLICACION:
			break;
		}
		return r;
	}
}
