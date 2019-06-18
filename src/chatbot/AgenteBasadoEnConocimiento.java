package chatbot;

import java.util.ArrayList;

import domain.Notebook;
import domain.Smartphone;
import domain.Tablet;
import domain.Tv;
import productionsystem.Estrategia;
import productionsystem.NoDuplicacion;
import productionsystem.Regla;
import productionsystem.ReglaPregunta;
import productionsystem.ReglaRespuesta;
import productionsystem.TipoPregunta;
import stanfordCoreNLP.StanfordDemo;
import sttYtts.LeerArchivo;
import tp2iav1.pkg0.interfazPrincipal;


public class AgenteBasadoEnConocimiento {
	private TipoPregunta preguntaActiva;
	private ArrayList<TipoPregunta> preguntasHechas;
    private ArrayList<ReglaPregunta> reglasPreguntasDisponibles;
    private ArrayList<Regla> reglasPreguntasUsadas;
    private ArrayList<ReglaRespuesta> reglasRespuestasDisponibles;
    private ArrayList<Regla> reglasRespuestasUsadas;
    //productos disponibles
    private ArrayList<Notebook> notebooks;
    private ArrayList<Smartphone> smartphones;
    private ArrayList<Tablet> tablets;
    private ArrayList<Tv> tvs;
    
	public AgenteBasadoEnConocimiento() {
		this.preguntaActiva=TipoPregunta.TIPOPRODUCTO;
		this.preguntasHechas = new ArrayList<TipoPregunta>();
		this.reglasRespuestasDisponibles = new ArrayList<ReglaRespuesta>();
		this.reglasRespuestasUsadas = new ArrayList<Regla>();
		this.reglasPreguntasDisponibles = new ArrayList<ReglaPregunta>();
		this.reglasPreguntasUsadas = new ArrayList<Regla>();
		this.cargarReglas();
	}
	

	public String start(String oracion, boolean mode){
		String respuesta="";
		TipoPregunta productoActual;
		Estrategia e = new Estrategia();
		
		//pasar el string a una clase que lo divida en palabras
		StanfordDemo sd = new StanfordDemo();
		ArrayList<String> palabras = sd.normalizarPalabras(oracion);
		//pasar las palabras a un metodo que chequee con que reglas matchea esas palabras
		ArrayList<Regla> reglasRespuestaActivas = this.verificarReglasRespuestas(reglasRespuestasDisponibles, palabras, preguntaActiva);
		
		if(!reglasRespuestaActivas.isEmpty()){
		//quiere decir que lo que ingreso el usuario corresponde a la pregunta hecha
			//se elige una y el chatbot responde
			e.setReglasActivas(reglasRespuestaActivas);
			e.setReglasUsadas(reglasRespuestasUsadas);
			ReglaRespuesta respuestaEjecutar = (ReglaRespuesta) e.buscarRegla();
			reglasRespuestasUsadas.add(respuestaEjecutar);
			this.preguntasHechas.add(this.preguntaActiva);
			this.reglasPreguntasUsadas=this.filtrarPreguntas();
			respuesta+=respuestaEjecutar.getSalida();
			
			//refinar los productos
			if(respuestaEjecutar.getFiltrado().equals("notebook")) this.preguntasHechas.add(TipoPregunta.NOTEBOOK);
			else if(respuestaEjecutar.getFiltrado().equals("smartphone")) this.preguntasHechas.add(TipoPregunta.SMARTPHONE);
			else if(respuestaEjecutar.getFiltrado().equals("tv")) this.preguntasHechas.add(TipoPregunta.TV);
			else if(respuestaEjecutar.getFiltrado().equals("tablet")) this.preguntasHechas.add(TipoPregunta.TABLET);
			
			//elegir una pregunta
			//buscar preguntas activas
			ArrayList<Regla> reglasPreguntasActivas = this.verificarReglasPreguntas();
			if(!reglasPreguntasActivas.isEmpty()) {
				//elijo una segun estrategia
				e.setReglasActivas(reglasPreguntasActivas);
				e.setReglasUsadas(reglasPreguntasUsadas);
				ReglaPregunta preguntaEjecutar = (ReglaPregunta) e.buscarRegla();
				this.preguntaActiva=preguntaEjecutar.getTipoPregunta();
				respuesta+="\n"+preguntaEjecutar.getSalida();
			}else { //recomendar
				respuesta="Te recomiendo esto:";
				
				//vaciar todas las variables
			}
			
			
			return respuesta;
		}else return "Creo que no me respondiste :S";
	}
	
	
	private ArrayList<Regla> verificarReglasPreguntas() {
		ArrayList<Regla> reglasPreguntasActivas = new ArrayList<Regla>();
		for(ReglaPregunta r : this.reglasPreguntasDisponibles) {
			if(r.verificarPregunta(this.preguntasHechas)) reglasPreguntasActivas.add(r);
		}
		if(reglasPreguntasUsadas.size()==reglasPreguntasActivas.size()) return new ArrayList<Regla>();
		else return reglasPreguntasActivas;
	}


	public ArrayList<Regla> verificarReglasRespuestas(ArrayList<ReglaRespuesta> reglas, ArrayList<String> palabras, TipoPregunta preguntaActiva){
		ArrayList<Regla> reglasActivas = new ArrayList();
		for(ReglaRespuesta r : reglas) {
			if(r.verificarCondicion(palabras, preguntaActiva)) reglasActivas.add(r);
		}
		return reglasActivas;
	}
	
	public void cargarReglas() {
		LeerArchivo a = new LeerArchivo();
		this.reglasRespuestasDisponibles = a.leerReglasClienteRespuesta();
		this.reglasPreguntasDisponibles = a.leerReglasClientePregunta();
	}
	public ArrayList<Regla> filtrarPreguntas(){
		ArrayList<Regla> reglasUsadas = new ArrayList<Regla>();
		for(ReglaPregunta r : this.reglasPreguntasDisponibles) {
			for(TipoPregunta t: this.preguntasHechas) {
				if(t.equals(r.getTipoPregunta())) 
					reglasUsadas.add(r);
			}
		}
		
		return reglasUsadas;
	}
	/*public ArrayList<String> dividirEnPalabras(String oracion){
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
	}*/
	
	
	
}
