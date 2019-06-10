package productionsystem;

import java.util.LinkedList;
import java.util.List;



public class Aleatorio {
	
	public Aleatorio() {
	}
	
	public Regla random(List<Regla> list) {

		java.util.Random r = new java.util.Random(System.currentTimeMillis());
		int valor = r.nextInt(list.size());
		return list.get(valor);
		
	}

	
	public String toString() {
		return "Random (Aleatorio)";
	}
}
