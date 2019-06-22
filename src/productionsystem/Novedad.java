package productionsystem;

import java.util.ArrayList;
import java.util.List;

public class Novedad {

	public Novedad() {
	}
	
	public ArrayList<Regla> novelty(List<Regla> reglasActivas){
		ArrayList<Regla> resultado = new ArrayList<Regla>();
		for(Regla r: reglasActivas) {
			if(r.getNovedad()) resultado.add(r);
		}
		
		return resultado;
	}
	
	public String toString() {
		return "Novelty (Novedad)";
	}
	
}
