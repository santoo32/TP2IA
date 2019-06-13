package sttYtts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import productionsystem.Regla;

public class LeerArchivo {
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
	private String linea;
	
	public LeerArchivo() {
		
	}
	
	public ArrayList<Regla> leerReglas() {
		ArrayList<Regla> reglasDisponibles = new ArrayList<Regla>();
		try {
	         // Apertura del fichero y creacion de BufferedReader 
			//para poder hacer una lectura comoda (disponer del metodo readLine()) 
	         archivo = new File ("src/reglasCliente.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         linea = "";
	         //String nuevaLinea = "";
	         //EscribirArchivo es = new EscribirArchivo();
	         
	        while((linea=br.readLine())!=null) {      	
	        	//voy leyendo linea a linea y creando una regla
	        	
	        	Regla nuevaRegla = new Regla();
	        	ArrayList<String> condicion = new ArrayList<String>();
	        	int i=0;
	        	String palabra="";
	        	//cargo las condiciones 
	        	while(linea.charAt(i)!='*') {
	        		while(linea.charAt(i)!=' ') {
	        			palabra +=linea.charAt(i);
	        			i++;
	        		}
	        		condicion.add(palabra);
	        		palabra="";
	        		i++;
	        	}
	        	i++;
	        	//cargo la respuesta
	        	String respuesta="";
	        	while(linea.charAt(i)!='*') {
	        		respuesta+=linea.charAt(i);
	        		i++;
	        	}
	        	i++;
	        	String idAux="";
	        	while(linea.charAt(i)!='*') {
	        		idAux+=linea.charAt(i);
	        		i++;
	        	}
	        	int id = Integer.valueOf(idAux);
	        	i++;
	        	String prioridadAux="";
	        	while(linea.charAt(i)!='*') {
	        		prioridadAux+=linea.charAt(i);
	        		i++;
	        	}
	        	int prioridad = Integer.valueOf(prioridadAux);
	        	
	        	//creo la regla
	        	nuevaRegla.setCondicion(condicion);
	        	nuevaRegla.setRespuesta(respuesta);
	        	nuevaRegla.setId(id);
	        	nuevaRegla.setPrioridad(prioridad);
	        	reglasDisponibles.add(nuevaRegla);

	        	
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
		return reglasDisponibles;
	}
	
}
