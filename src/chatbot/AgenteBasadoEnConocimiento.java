package chatbot;

import java.util.ArrayList;

import productionsystem.Estrategia;
import productionsystem.Regla;
import productionsystem.TipoEstrategia;

public class AgenteBasadoEnConocimiento {
	
	public AgenteBasadoEnConocimiento() {
	}
	
	public void start(String oracion){
		
		//borrar despues
		/////////////
		ArrayList<String> condicion1 = new ArrayList<String>();
		condicion1.add("Hola");
		Regla r1 = new Regla(condicion1, "Holaaa!");
		ArrayList<String> condicion2 = new ArrayList<String>();
		condicion2.add("Buenas");
		condicion2.add("Tardes");
		Regla r2 = new Regla(condicion2, "Muy buenaas!");
		ArrayList<Regla> reglas = new ArrayList<Regla>();
		reglas.add(r1);
		reglas.add(r2);
		///////////	
		
		//pasar el string a una clase que lo divida en palabras
		
		
		//pasar las palabras a un metodo que chequee con que reglas matchea esas palabras
		ArrayList<Regla> reglasDisponibles = this.verificarReglas(reglas, condicion2);
		
		
		//ver que regla ejecutar segun la estrategia
		Estrategia e = new Estrategia(TipoEstrategia.ESPECIFICIDAD);
		e.setReglasDisponibles(reglasDisponibles);
		
		//ejecutar la regla
		System.out.println(e.buscarRegla().getEspecificidad());
	}
	
	
	public ArrayList<Regla> verificarReglas(ArrayList<Regla> reglas, ArrayList<String> palabras){
		ArrayList<Regla> reglasDisponibles = new ArrayList<Regla>();
		for(Regla r : reglas) {
			if(r.verificaCondicion(palabras)) reglasDisponibles.add(r);
		}
		return reglasDisponibles;
	}
	
	
	
}
