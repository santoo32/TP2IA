package productionsystem;

import java.util.ArrayList;
import java.util.List;

public class Prioridad {
	
	public Prioridad() {
		
	}
	
	public ArrayList<Regla> priority(List<Regla> list) {
		int max = 100;
		ArrayList<Regla> reglasActivas = new ArrayList<Regla>();
		for(Regla r : list) {
			if(r.getPrioridad() < max )
				max = r.getPrioridad();
		}
		for(Regla r : list) {
			if(r.getPrioridad()==max)
				reglasActivas.add(r);
		}
		
		return reglasActivas;
	}
	
	public String toString() {
		return "Priority (Prioridad)";
	}

}
