package chatbot;

import java.util.ArrayList;

import productionsystem.Estrategia;
import productionsystem.Regla;
import productionsystem.TipoEstrategia;
import tp2iav1.pkg0.interfazPrincipal;


public class AgenteBasadoEnConocimiento {
	
    
    
	public AgenteBasadoEnConocimiento() {}
	

	public String start(String oracion, boolean mode){
		
        System.out.println("ENVIADO: " + oracion);
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
		ArrayList<String> oracionIngresada = new ArrayList<String>();
		oracionIngresada.add(oracion);
		///////////	
		
		//pasar el string a una clase que lo divida en palabras
		
		
		//pasar las palabras a un metodo que chequee con que reglas matchea esas palabras
		ArrayList<Regla> reglasDisponibles = this.verificarReglas(reglas, oracionIngresada);
		
		if(!reglasDisponibles.isEmpty()) {
			//ver que regla ejecutar segun la estrategia
			Estrategia e = new Estrategia(TipoEstrategia.ESPECIFICIDAD);
			e.setReglasDisponibles(reglasDisponibles);
			
			//ejecutar la regla
			System.out.println("RESPUESTA: "+e.buscarRegla().getRespuesta());
			return e.buscarRegla().getRespuesta();
		}else {
			System.out.println("RESPUESTA: Perdon, no te entendi :(");
			return "Perdon, no te entendi :(";
		}
			
		
	}
	
	
	public ArrayList<Regla> verificarReglas(ArrayList<Regla> reglas, ArrayList<String> palabras){
		ArrayList<Regla> reglasDisponibles = new ArrayList<Regla>();
		for(Regla r : reglas) {
			if(r.verificaCondicion(palabras)) reglasDisponibles.add(r);
		}
		return reglasDisponibles;
	}
	
	
	
}
