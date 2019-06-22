package chatbot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import domain.Notebook;
import domain.Smartphone;
import domain.Tablet;
import domain.Tv;
import productionsystem.Estrategia;
import productionsystem.NoDuplicacion;
import productionsystem.Regla;
import productionsystem.ReglaPregunta;
import productionsystem.ReglaRespuesta;
import productionsystem.ReglaVendedor;
import productionsystem.TipoPregunta;
import stanfordCoreNLP.StanfordDemo;
import sttYtts.EscribirArchivo;
import sttYtts.LeerArchivo;
import tp2iav1.pkg0.interfazPrincipal;


public class AgenteBasadoEnConocimiento {
	private TipoPregunta preguntaActiva;
	private ArrayList<TipoPregunta> preguntasHechas;
    private ArrayList<ReglaPregunta> reglasPreguntasDisponibles;
    private ArrayList<Regla> reglasPreguntasUsadas;
    private ArrayList<ReglaRespuesta> reglasRespuestasDisponibles;
    private ArrayList<Regla> reglasRespuestasUsadas;
    private ArrayList<ReglaVendedor> reglasVendedorDisponibles;
    private ArrayList<Regla> reglasVendedorUsadas;
    private Recomendacion recomendacion;
    private StanfordDemo sd = new StanfordDemo();
    
	public AgenteBasadoEnConocimiento() {
		this.reglasRespuestasDisponibles = new ArrayList<ReglaRespuesta>();
		this.reglasPreguntasDisponibles = new ArrayList<ReglaPregunta>();
		this.reglasVendedorDisponibles = new ArrayList<ReglaVendedor>();
		this.setVariables();
		this.cargarReglas();
		this.recomendacion = new Recomendacion();
		sd.normalizarPalabras("hola");
	}
	

	public void setVariables() {
		this.preguntaActiva=TipoPregunta.TIPOPRODUCTO;
		this.preguntasHechas = new ArrayList<TipoPregunta>();
		this.reglasRespuestasUsadas = new ArrayList<Regla>();
		this.reglasPreguntasUsadas = new ArrayList<Regla>();
		this.reglasVendedorUsadas = new ArrayList<Regla>();
			
	}


	public String start(String oracion, boolean mode){
		String respuesta="";
		Estrategia e = new Estrategia();
		EscribirArchivo ea = new EscribirArchivo();
		//pasar el string a una clase que lo divida en palabras
		ArrayList<String> palabras = sd.normalizarPalabras(oracion);
		
		if(mode) {//cliente
			
			TipoPregunta productoActual;
			
			//pasar las palabras a un metodo que chequee con que reglas matchea esas palabras
			ArrayList<Regla> reglasRespuestaActivas = this.verificarReglasRespuestas(reglasRespuestasDisponibles, palabras, preguntaActiva);
			if(!reglasRespuestaActivas.isEmpty())
				ea.escribirActivasRespuesta(reglasRespuestaActivas, palabras, this.preguntaActiva, this.preguntasHechas, this.reglasRespuestasUsadas);
			this.cargarNovedad();
			
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
				ea.escribirFaseDeEjecucionR(preguntasHechas, respuestaEjecutar);
				
				//refinar los productos
				if(respuestaEjecutar.getFiltrado().equals("notebook")) this.preguntasHechas.add(TipoPregunta.NOTEBOOK);
				else if(respuestaEjecutar.getFiltrado().equals("smartphone")) this.preguntasHechas.add(TipoPregunta.SMARTPHONE);
				else if(respuestaEjecutar.getFiltrado().equals("tv")) this.preguntasHechas.add(TipoPregunta.TV);
				else if(respuestaEjecutar.getFiltrado().equals("tablet")) this.preguntasHechas.add(TipoPregunta.TABLET);
				
				recomendacion.filtrar(respuestaEjecutar.getTipoPregunta(), respuestaEjecutar.getFiltrado());
				
				//elegir una pregunta
				//buscar preguntas activas
				ArrayList<Regla> reglasPreguntasActivas = this.verificarReglasPreguntas();
				if(!reglasPreguntasActivas.isEmpty()) {
					ea.escribirActivasPregunta(palabras,reglasPreguntasActivas, this.preguntaActiva, this.preguntasHechas, this.reglasRespuestasUsadas);
					//elijo una segun estrategia
					e.setReglasActivas(reglasPreguntasActivas);
					e.setReglasUsadas(reglasPreguntasUsadas);
					ReglaPregunta preguntaEjecutar = (ReglaPregunta) e.buscarRegla();
					ea.escribirFaseDeEjecucionP(preguntaEjecutar);
					this.preguntaActiva=preguntaEjecutar.getTipoPregunta();
					respuesta+="\n"+preguntaEjecutar.getSalida();
				}else { //recomendar
					
					String r = recomendacion.recomendar();
					if(!r.isEmpty()) {
						respuesta="Te puedo recomendar esto: \n";
						respuesta+=r;
					}else respuesta += "No tengo nada para recomendarte :(\n";
					DateFormat dateFormat = new SimpleDateFormat("HH:mm");
					Date date = new Date();
					respuesta+="- - - - - - - - - - - - - - - - - - - - -" + "\n";
					respuesta+=dateFormat.format(date)+ " Asistente:           " + "Hola!, ¿Que necesitas?" + "\n";
					
					
					//vaciar todas las variables
					recomendacion.setVariables();
					this.setVariables();
					
				}
				
				
				return respuesta;
			}else return "Creo que no me respondiste :S";
		}else {//vendedor
			
			//ver las reglas activas
			ArrayList<Regla> reglasVendedorActivas = this.verificarReglasVendedor(this.reglasVendedorDisponibles, palabras);
			
			if(!reglasVendedorActivas.isEmpty()) {
				e.setReglasActivas(reglasVendedorActivas);
				e.setReglasUsadas(reglasVendedorUsadas);
				ReglaVendedor reglaEjecutar = (ReglaVendedor) e.buscarRegla();
				
				//filtrar los productos
				Recomendacion reco = new Recomendacion();
				reco.filtrar(TipoPregunta.TIPOPRODUCTO, reglaEjecutar.getTipoProducto());
				reco.filtrar(reglaEjecutar.getTipoPregunta(), reglaEjecutar.getFiltrado());
				
				
				return reglaEjecutar.getSalida()+"\n" + reco.recomendar();
				
			}else return "No te entendi";
			
		}
		
	}
	
	private void cargarNovedad() {
		for(ReglaRespuesta r : reglasRespuestasDisponibles) {
			r.cargarNovedad(this.preguntaActiva);
		}
		for(ReglaPregunta r : reglasPreguntasDisponibles) {
			r.cargarNovedad(this.preguntaActiva);
		}
		
	}


	private ArrayList<Regla> verificarReglasVendedor(ArrayList<ReglaVendedor> reglasVendedorDisponibles,
			ArrayList<String> palabras) {
		
		ArrayList<Regla> aux = new ArrayList<Regla>();
		for(ReglaVendedor r : reglasVendedorDisponibles) {
			if(r.verificarCondicion(palabras)) aux.add(r);
		}
		
		return aux;
	}


	public String recomendar() {
		String respuesta="";
		String r = recomendacion.recomendar();
		respuesta+=r;
		this.setVariables();
		return respuesta;
		
	}
	
	public Recomendacion getRecomendacion() {
		return recomendacion;
	}
	public void setRecomendacion(Recomendacion recomendacion) {
		this.recomendacion = recomendacion;
	}
	private ArrayList<Regla> verificarReglasPreguntas() {
		ArrayList<Regla> reglasPreguntasActivas = new ArrayList<Regla>();
		for(ReglaPregunta r : this.reglasPreguntasDisponibles) {
			if(r.verificarPregunta(this.preguntasHechas)) reglasPreguntasActivas.add(r);
		}
		return this.eliminarRepetidas(reglasPreguntasActivas);
	}


	private ArrayList<Regla> eliminarRepetidas(ArrayList<Regla> reglasPreguntasActivas) {
		boolean encontrado = false;
		if(!reglasPreguntasUsadas.isEmpty()) {
			ArrayList<Regla> aux = new ArrayList<Regla>();
			for(Regla r1: reglasPreguntasActivas) {
				for(Regla r2 : this.reglasPreguntasUsadas) {
					if(r1.getId()==r2.getId()) encontrado = true;
				}
				if(!encontrado) aux.add(r1);
				encontrado=false;
			}
			return aux;
		}else return reglasPreguntasActivas;
		
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
		this.reglasVendedorDisponibles = a.leerReglasVendedor();
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
