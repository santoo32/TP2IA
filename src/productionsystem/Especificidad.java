package productionsystem;

import java.util.ArrayList;
import java.util.List;

public class Especificidad {
	
	public Especificidad() {
	}
	
	public ArrayList<Regla> specificity(List<Regla> list) {
		int max =0;
		ArrayList<Regla> reglasActivas = new ArrayList<Regla>();
		for(Regla r : list) {
			if(r.getEspecificidad() > max )
				max = r.getEspecificidad();
		}
		for(Regla r : list) {
			if(r.getEspecificidad()==max)
				reglasActivas.add(r);
				
		}
		return reglasActivas;
	}
	
	public String toString() {
		return "Specificity (Especificidad)";
	}
}
