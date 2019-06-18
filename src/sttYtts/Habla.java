package sttYtts;

import java.util.Locale;

import javax.speech.*;
import javax.speech.synthesis.*;
 
public class Habla {
	private EscribirArchivo escribir = new EscribirArchivo();
	
	public Habla() {		
	}
	
 	public void leer(String oracion) {
 		try { 
 			String say = oracion;			
 			
 			//Crea el sintonizador para el Locale por defecto
 			Synthesizer synth = Central.createSynthesizer(null);
 			
 			//Asigna el recurso
 			synth.allocate();
 			
 			//Activa el sintonizador
 			synth.resume();
 			
 			//Imprime por consola lo que dice
 	 		System.out.println("Chatbot>> "+say);
 	 			
 	 		//Escribo en el txt
 	 		escribir.escribir("Chatbot", say, "Prueba");
 	 			
 	 		////Setea lo que tiene que decir (say) y un listener de ser necesario en este caso null
 	 		synth.speakPlainText(say,null); 	
 	 			
 	 		//Se bloquea hasta que la cola esté vacía (no hay que decir más nada)
 	 		synth.waitEngineState(Synthesizer.QUEUE_EMPTY);
 			 			
	 		//Desocupa el recurso
	 		synth.deallocate();
 
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 	}
}