package sttYtts;

import javax.speech.*;
import javax.speech.recognition.*;
import tp2iav1.pkg0.interfazPrincipal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
 
public class Escucha extends ResultAdapter{
	private static Recognizer recognizer;
	private String respuesta = "";
	private interfazPrincipal intUI;
	private FileReader grammarCliente;
	private FileReader grammarVendedor;
	private RuleGrammar rgCliente;
	private RuleGrammar rgVendedor;
	private boolean cliente = true;
	
	public Escucha() {
	}
	
	@Override
	//ResultEvent señala cambios de estado y de datos de los resultados del reconocimiento
	// Recibe el evento RESULT_ACCEPTED: imprímelo, limpie, salga
 	public void resultAccepted(ResultEvent re) {
	 	try {
	 		respuesta = ""; 			
 			
	 		Result res = (Result)(re.getSource());
	 		//Obtiene palabra por palabra (también guarda los espacios)
	 		ResultToken tokens[] = res.getBestTokens(); 
	 		
	 		//Almacena en la variable respuesta lo que se escuchó
	 		for (int i=0; i < tokens.length; i++){
	 			//System.out.println("tokens: "+tokens[i].getSpokenText());
	 			respuesta+= tokens[i].getSpokenText()+" ";
	 		}
	 		
	 		System.out.println("Usuario>> "+respuesta);	 		
	 		
	 		if(respuesta.trim().equals("Desactivar")) {
	 			this.terminarEscucha();
		 		intUI.dejarDeEscuchar();
 			}else {
 				if(respuesta.trim().equals("Borrar")) {
 			 		intUI.actualizarTexto("",true);
 	 			}else {
 	 				if(respuesta.trim().equals("Enviar")) {
 	 					intUI.enviar();
 	 				}else {
 	 	 				intUI.actualizarTexto(respuesta,false); 	 					
 	 				}
 	 		 		
 	 			}
 			}
	 	}catch(Exception ex){
	 		System.out.println("Ha ocurrido algo inesperado " + ex);
	 	}
 	}
		
	public void terminarEscucha() {
		if(recognizer != null) {
			recognizer.pause();
		}
	}
		
	public void empezarEscucha(interfazPrincipal i, boolean esCliente) {
		System.out.println("cliente: "+cliente+"	esCliente: "+esCliente);
		//Si el recognizer ya está inicializado y no cambio de modo
		if(recognizer != null && cliente == esCliente) {
			System.out.println("SIGO NORMAL");
			try {
				//Sigo normal
				recognizer.resume();
			} catch (AudioException | EngineStateError e) {
				e.printStackTrace();
			}
		}else {
			//Si cambio de modo
			if(cliente != esCliente) {
				System.out.println("Cambio de modo");
				//Desalojo el reconocedor
				try {
					recognizer.deallocate();
				} catch (EngineException | EngineStateError e) {
					e.printStackTrace();
				}
			} 			
			this.intUI = i;
			System.out.println("PRIMERA VEZ");
			escucha(esCliente);
		}
	}
 
 	private void escucha(boolean esCliente){
 		try{
 			//Crea el reconocedor para el Lcoale por defecto
 			recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
 			
 			//Pide el recurso
 			recognizer.allocate();
 			
 			//Lee el archivo donde se encuentra el diccionario (Misma ubicación del proyecto)
 			grammarCliente = new FileReader("GramaticaCliente.txt"); 
 			grammarVendedor = new FileReader("GramaticaVendedor.txt");
 			
 			if(esCliente) {
 				//Carga la gramática disponible.
 	 			rgCliente = recognizer.loadJSGF(grammarCliente);
 				//Habilito la gramática
 				rgCliente.setEnabled(true);
 				cliente = true;
				System.out.println("Seteo gramática cliente al inicio");
 			}else {
 				//Carga la gramática disponible.
 				rgVendedor = recognizer.loadJSGF(grammarVendedor);
 				//Habilito la gramática
				rgVendedor.setEnabled(true);
				cliente = false;
				System.out.println("Seteo gramática vendedor al inicio");
 			}
 			 			
 			//Agrega un listener al reconocedor para obtener los resultados
 			recognizer.addResultListener(this);
 			
 			//Guarda los cambios en el reconocedor
 			recognizer.commitChanges();
 			
 			//Pide el enfoque
 			recognizer.requestFocus();
 			
 			//Empieza a escuchar
 			recognizer.resume();
 			System.out.println("Empieze Dictado");
 			
 		}catch (Exception e){
 			System.out.println("Exception en " + e.toString());
 			e.printStackTrace();
 			System.exit(0);
 		}
 		
 	} 	
	 	
}

