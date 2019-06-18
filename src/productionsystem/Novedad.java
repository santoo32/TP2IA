package productionsystem;

import java.util.ArrayList;
import java.util.List;

public class Novedad {

	public Novedad() {
	}
	
	public ArrayList<Regla> novelty(List<Regla> reglasActivas){
		ArrayList<Regla> resultado = new ArrayList<Regla>();
		int max=0;
		for(Regla r : reglasActivas) {
			if(r.getNovedad()>r.getNovedad()) max=r.getNovedad();
		}
		for(Regla r: reglasActivas) {
			if(r.getNovedad()==max) resultado.add(r);
		}
		
		return resultado;
	}
	
	public String toString() {
		return "Novelty (Novedad)";
	}
	
}
