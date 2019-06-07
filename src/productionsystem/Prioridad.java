package productionsystem;

import java.util.List;

public class Prioridad {
	
	public Prioridad() {
		
	}
	
	public Regla priority(List<Regla> list) {
		Regla reglaPrioridad = list.get(0);
		for(Regla r : list) {
			if(r.getPrioridad() > reglaPrioridad.getPrioridad() )
				reglaPrioridad = r;
		}
		return reglaPrioridad;
	}
	
	public String toString() {
		return "Priority (Prioridad)";
	}

}
