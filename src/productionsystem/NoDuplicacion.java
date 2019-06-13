package productionsystem;

import java.util.ArrayList;
import java.util.List;

public class NoDuplicacion {
	
	
	public NoDuplicacion() {
	}

	public ArrayList<Regla> noDuplication(List<Regla> reglasActivas, List<Regla> reglasUsadas){
		ArrayList<Regla> resultado = new ArrayList<Regla>();
		boolean encontrado = false;
		if(!reglasUsadas.isEmpty()) {
			for(Regla r1 : reglasActivas) {
				for(Regla r2 : reglasUsadas) {
					if(this.usada(r1, r2))
						encontrado=true;
				}
				if(!encontrado) resultado.add(r1);
				encontrado=false;
			}
		}else resultado = (ArrayList<Regla>) reglasActivas;
		
		
		return resultado;
	}
	
	public boolean usada(Regla r1, Regla r2) {
		if(r1.getId()==r2.getId())
			return true;
		else return false;
	}

	public String toString() {
		return "NoDuplication (No Duplicacion)";
	}
	
}
