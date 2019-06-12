package sttYtts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerArchivo {
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
	private String linea;
	
	public LeerArchivo() {
		
	}
	
	public void leer() {
		try {
	         // Apertura del fichero y creacion de BufferedReader 
			//para poder hacer una lectura comoda (disponer del metodo readLine())
	         archivo = new File ("GramaticaNueva.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         linea = "";
	         String nuevaLinea = "";
	         EscribirArchivo es = new EscribirArchivo();
	         
	        while((linea=br.readLine())!=null) {      	
	        	//Hacer algo con lo que se va leyendo
	        	 /*nuevaLinea = linea.replaceAll("\\s"," | ");
	        	 es.escribir("", nuevaLinea,"Lo mismo pero con barra");*/
	        }
	        	 
	     }catch(Exception e){
	         e.printStackTrace();
	     }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
	
}
