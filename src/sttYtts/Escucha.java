package sttYtts;

import javax.speech.*;
import javax.speech.recognition.*;
import tp2iav1.pkg0.interfazPrincipal;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Locale;
 
public class Escucha extends ResultAdapter{
	private static Recognizer recognizer;
	private String respuesta = "";
	private interfazPrincipal intUI;
	private FileReader grammarCliente;
	private FileReader grammarVendedor;
	RuleGrammar rgCliente;
	RuleGrammar rgVendedor;
	
	public Escucha() {
	}
	
	@Override
	//ResultEvent se�ala cambios de estado y de datos de los resultados del reconocimiento
	// Recibe el evento RESULT_ACCEPTED: impr�melo, limpie, salga
 	public void resultAccepted(ResultEvent re) {
	 	try {
	 		respuesta = ""; 			
 			
	 		Result res = (Result)(re.getSource());
	 		//Obtiene palabra por palabra (tambi�n guarda los espacios)
	 		ResultToken tokens[] = res.getBestTokens(); 
	 		
	 		//Almacena en la variable respuesta lo que se escuch�
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
	 		
	 		//Escribo en el txt
	 		//escribir.escribir("Usuario",respuesta, "Prueba");
	 		
	 		//trim() elimina los espacios en blanco antes y despu�s de cada palabra
	 		/*if(respuesta.trim().equals("fin")){
	 			//Libera el recurso
	 			recognizer.deallocate(); 			
	 			lee.leer("Hasta la vista baby!");
	 			return;
	 		}else{
	 			if(respuesta.trim().equals("Faltan 5 pe")) {
	 				recognizer.suspend();
	 				lee.leer("pa comprar ese vi");
	 				recognizer.resume();
	 			}else {		 
	 				if(respuesta.trim().contentEquals("Union de Santa Fe")) {
	 					recognizer.suspend();
		 				lee.leer("El due�o de la ciudad");
		 				recognizer.resume();
	 				}else {
	 					//Suspende el reconocedor
		 				recognizer.suspend();	
		 				lee.leer(respuesta);
		 				//Activa el reconocedor
		 				recognizer.resume();
	 				}	 				
	 			}
	 		}*/
	 	}catch(Exception ex){
	 		System.out.println("Ha ocurrido algo inesperado " + ex);
	 	}
 	}
		
	public void terminarEscucha() {
		if(recognizer != null) {
			//recognizer.suspend();
			recognizer.pause();
		}
	}
		
	public void empezarEscucha(interfazPrincipal i, boolean esCliente) {
		System.out.println("Vendedor: "+ !esCliente+"	Cliente: "+ esCliente);
		
		if(recognizer != null) {
			/*if(esCliente) {
				if (!rgCliente.isActive()) {
					rgCliente.setEnabled(true);
					rgVendedor.setEnabled(false);
					System.out.println("Seteo gram�tica cliente");
				}
			}else {
				if (!rgVendedor.isActive()) {
					rgCliente.setEnabled(false);
					rgVendedor.setEnabled(true);
					System.out.println("Seteo gram�tica vendedor");
				}
				
			}*/
			try {
				recognizer.resume();
				
			} catch (AudioException e) {
				e.printStackTrace();
			} catch (EngineStateError e) {
				e.printStackTrace();
			}
		}else {
			this.intUI = i;
			escucha(esCliente);
		}
	}
 
 	private void escucha(boolean esCliente){
 		try{
 			//Crea el reconocedor para el Lcoale por defecto
 			recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
 			
 			//Pide el recurso
 			recognizer.allocate();
 			
 			//Lee el archivo donde se encuentra el diccionario (Misma ubicaci�n del proyecto)
 			grammarCliente =new FileReader("GramaticaCliente.txt"); 
 			grammarVendedor = new FileReader("GramaticaVendedor.txt");
 			
 			//Carga la gram�tica disponible.
 			rgCliente = recognizer.loadJSGF(grammarCliente);
 			//rgVendedor = recognizer.loadJSGF(grammarVendedor);
 			
 			//if(esCliente) {
 				//Habilito la gram�tica
 				rgCliente.setEnabled(true);
				/*rgVendedor.setEnabled(false);
				System.out.println("Seteo gram�tica cliente al inicio");
 			}else {
 				rgCliente.setEnabled(false);
				rgVendedor.setEnabled(true);
				System.out.println("Seteo gram�tica vendedor al inicio");
 			}*/
 			 			
 			//Agrega un listener al reconocedor para obtener los resultados
 			recognizer.addResultListener(this/*new Escucha(this.intUI)*/);
 			
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

