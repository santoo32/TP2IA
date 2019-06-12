package sttYtts;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribirArchivo {
	FileWriter fichero = null;
    PrintWriter pw = null;
    String nombre = "";
	
	public EscribirArchivo() {
		
	}
	
	public void escribir(String autor,  String oracion, String nombreDocumento) {        
        try{
        	//Creo el fichero
        	nombre = nombreDocumento.concat(".txt");
        	//Creo el txt. el parametro true es para que agregue al final del archivo (si es que ya está creado)
            fichero = new FileWriter(nombre,true);
            
            pw = new PrintWriter(fichero);
            //Escribo en el archivo
            pw.println(autor+">> "+oracion);

        }catch (Exception e){
            e.printStackTrace();
        } finally {
           try {
        	   // finally para asegurarnos que se cierra el fichero.
        	   if (fichero != null) {
        		   fichero.close();
        	   }
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	

}
