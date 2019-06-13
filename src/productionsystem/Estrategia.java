package productionsystem;

import java.util.ArrayList;
import java.util.List;

public class Estrategia {
	private List<Regla> reglasActivas;
	private List<Regla> reglasUsadas;
	

	public Estrategia() {
		super();
	}

	public List<Regla> getReglasActivas() {
		return reglasActivas;
	}
	public void setReglasActivas(List<Regla> reglasActivas) {
		this.reglasActivas = reglasActivas;
	}
	public List<Regla> getReglasUsadas() {
		return reglasUsadas;
	}
	public void setReglasUsadas(List<Regla> reglasUsadas) {
		this.reglasUsadas = reglasUsadas;
	}
	public void agregarUsada(Regla r) {
		this.reglasUsadas.add(r);
	}


	public Regla buscarRegla() {
		Regla r = new Regla();
		ArrayList<Regla> aux = new ArrayList<Regla>();
		
		//NO DUPLICACION
		NoDuplicacion np = new NoDuplicacion();
		aux = np.noDuplication(reglasActivas, reglasUsadas);
		System.out.println("AUX: "+aux.size());
		if(aux.size()>1) {
			Aleatorio a = new Aleatorio();
			r = a.random(aux);
		}else {
			if(aux.size()==0) {
				return null;
			}else r=aux.get(0);
			
		}
		
		return r;
	}
}
