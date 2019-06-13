package chatbot;

import java.util.ArrayList;

import productionsystem.Estrategia;
import productionsystem.Regla;
import sttYtts.LeerArchivo;
import tp2iav1.pkg0.interfazPrincipal;


public class AgenteBasadoEnConocimiento {
	ArrayList<Regla> reglasDisponibles;
	ArrayList<Regla> reglasUsadas;
    
    
	public AgenteBasadoEnConocimiento() {
		this.reglasUsadas = new ArrayList<Regla>();
		this.reglasDisponibles = new ArrayList<Regla>();
		this.cargarReglas();
	}
	

	public String start(String oracion, boolean mode){

		//pasar el string a una clase que lo divida en palabras
		//PROVISORIO, DESPUES BORRAR
		ArrayList<String> palabras = this.dividirEnPalabras(oracion);
		
		//pasar las palabras a un metodo que chequee con que reglas matchea esas palabras
		ArrayList<Regla> reglasActivas = this.verificarReglas(reglasDisponibles, palabras);
		
		System.out.println("Activas:" +reglasActivas.size()+ "Usadas: "+reglasUsadas.size());
		
		if(!reglasActivas.isEmpty()) {
			//ver que regla ejecutar 
			Estrategia e = new Estrategia();
			e.setReglasActivas(reglasActivas);
			e.setReglasUsadas(reglasUsadas);
			
			//ejecutar la regla
			Regla reglaAEjecutar = e.buscarRegla();
			if(reglaAEjecutar!=null) {
				reglasUsadas.add(reglaAEjecutar);
				return reglaAEjecutar.getRespuesta();
			}else return "Perdon, no te entendi :(";
			
		}else {
			System.out.println("RESPUESTA: Perdon, no te entendi :(");
			return "Perdon, no te entendi :(";
		}
			
		
	}
	
	
	public ArrayList<Regla> verificarReglas(ArrayList<Regla> reglas, ArrayList<String> palabras){
		ArrayList<Regla> reglasActivas = new ArrayList<Regla>();
		for(Regla r : reglas) {
			if(r.verificaCondicion(palabras)) reglasActivas.add(r);
		}
		return reglasActivas;
	}
	
	public void cargarReglas() {
		LeerArchivo a = new LeerArchivo();
		this.reglasDisponibles = a.leerReglas();
	}
	public ArrayList<String> dividirEnPalabras(String oracion){
		ArrayList<String> palabras = new ArrayList<String>();
		int i=0;
		while(i<oracion.length()) {
			String palabra ="";
			while(i<oracion.length() && oracion.charAt(i)!=' ' ) {
				palabra+=oracion.charAt(i);
				i++;
			}
			palabras.add(palabra);
			i++;
		}
		return palabras;
	}
	
	
	
}
