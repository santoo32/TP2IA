package productionsystem;

import java.util.List;

public class Especificidad {
	
	public Especificidad() {
	}
	
	public Regla specificity(List<Regla> list) {
		Regla reglaEspecifica = list.get(0);
		for(Regla r : list) {
			if(r.getEspecificidad() > reglaEspecifica.getEspecificidad() )
				reglaEspecifica = r;
		}
		return reglaEspecifica;
	}
	
	public String toString() {
		return "Specificity (Especificidad)";
	}
}
