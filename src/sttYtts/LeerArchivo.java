package sttYtts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import productionsystem.Regla;
import productionsystem.ReglaPregunta;
import productionsystem.ReglaRespuesta;
import productionsystem.TipoPregunta;

public class LeerArchivo {
	File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
	private String linea;
	
	public LeerArchivo() {
		
	}
	
	public ArrayList<ReglaRespuesta> leerReglasClienteRespuesta() {
		ArrayList<ReglaRespuesta> reglasDisponibles = new ArrayList<ReglaRespuesta>();
		try {
	         // Apertura del fichero y creacion de BufferedReader 
			//para poder hacer una lectura comoda (disponer del metodo readLine()) 
	         archivo = new File ("src/reglasClienteRespuesta.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         linea = "";
	         //String nuevaLinea = "";
	         //EscribirArchivo es = new EscribirArchivo();
	         
	        while((linea=br.readLine())!=null) {      	
	        	//voy leyendo linea a linea y creando una regla
	        	
	        	ReglaRespuesta nuevaRegla = new ReglaRespuesta();
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
	        	//cargo el id
	        	String idAux="";
	        	while(linea.charAt(i)!='*') {
	        		idAux+=linea.charAt(i);
	        		i++;
	        	}
	        	int id = Integer.valueOf(idAux);
	        	i++;
	        	//cargo la prioridad
	        	String prioridadAux="";
	        	while(linea.charAt(i)!='*') {
	        		prioridadAux+=linea.charAt(i);
	        		i++;
	        	}
	        	int prioridad = Integer.valueOf(prioridadAux);
	        	i++;
	        	String tipoPregunta="";
	        	while(linea.charAt(i)!='*') {
	        		tipoPregunta+=linea.charAt(i);
	        		i++;
	        	}
	        	TipoPregunta tipo = this.buscarTipo(tipoPregunta);
	        	i++;
	        	String filtrado="";
	        	while(linea.charAt(i)!='*') {
	        		filtrado+=linea.charAt(i);
	        		i++;
	        	}
	        	//creo la regla
	        	nuevaRegla.setCondicion(condicion);
	        	nuevaRegla.setSalida(respuesta);
	        	nuevaRegla.setId(id);
	        	nuevaRegla.setPrioridad(prioridad);
	        	nuevaRegla.setTipoPregunta(tipo);
	        	nuevaRegla.setFiltrado(filtrado);
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
	public ArrayList<ReglaPregunta> leerReglasClientePregunta() {
		ArrayList<ReglaPregunta> reglasDisponibles =  new ArrayList<ReglaPregunta>();
		try {
			archivo = new File ("src/reglasClientePregunta.txt");
			fr = new FileReader (archivo);
	        br = new BufferedReader(fr);
	        linea = "";
	        while((linea=br.readLine())!=null) {
	        	ReglaPregunta nuevaRegla = new ReglaPregunta();
	        	ArrayList<TipoPregunta> condicion = new ArrayList<TipoPregunta>();
	        	int i=0;
	        	String palabra="";
	        	//cargo las condiciones 
	        	while(linea.charAt(i)!='*') {
	        		while(linea.charAt(i)!=' ') {
	        			palabra +=linea.charAt(i);
	        			i++;
	        		}
	        		condicion.add(this.buscarTipo(palabra));
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
	        	//cargo el tipo de pregunta
	        	String tipoPregunta ="";
	        	while(linea.charAt(i)!='*') {
	        		tipoPregunta+=linea.charAt(i);
	        		i++;
	        	}
	        	i++;
	        	TipoPregunta tipo = this.buscarTipo(tipoPregunta);
	        	//cargo el id
	        	String idAux="";
	        	while(linea.charAt(i)!='*') {
	        		idAux+=linea.charAt(i);
	        		i++;
	        	}
	        	int id = Integer.valueOf(idAux);
	        	i++;
	        	//cargo la prioridad
	        	String prioridadAux="";
	        	while(linea.charAt(i)!='*') {
	        		prioridadAux+=linea.charAt(i);
	        		i++;
	        	}
	        	int prioridad = Integer.valueOf(prioridadAux);
	        	i++;
	        	
	        	//creo la regla
	        	nuevaRegla.setCondicion(condicion);
	        	nuevaRegla.setSalida(respuesta);
	        	nuevaRegla.setId(id);
	        	nuevaRegla.setPrioridad(prioridad);
	        	nuevaRegla.setTipoPregunta(tipo);
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
	
	public TipoPregunta buscarTipo(String cadena) {
		TipoPregunta resultado = TipoPregunta.TIPOPRODUCTO;
		if(cadena.contentEquals("USO")) resultado = TipoPregunta.USO;
		else if(cadena.contentEquals("TIPOPRODUCTO")) resultado = TipoPregunta.TIPOPRODUCTO;
		else if(cadena.contentEquals("PRECIO")) resultado = TipoPregunta.PRECIO;
		else if(cadena.contentEquals("TAMPANTALLA")) resultado = TipoPregunta.TAMPANTALLA;
		else if(cadena.contentEquals("RESPANTALLA")) resultado = TipoPregunta.RESPANTALLA;
		else if(cadena.contentEquals("RAM")) resultado = TipoPregunta.RAM;
		else if(cadena.contentEquals("ROM")) resultado = TipoPregunta.ROM;
		else if(cadena.contentEquals("CAMARA")) resultado = TipoPregunta.CAMARA;
		else if(cadena.contentEquals("SO")) resultado = TipoPregunta.SO;
		else if(cadena.contentEquals("NOTEBOOK")) resultado = TipoPregunta.NOTEBOOK;
		else if(cadena.contentEquals("TV")) resultado = TipoPregunta.TV;
		else if(cadena.contentEquals("TABLET")) resultado = TipoPregunta.TABLET;
		else if(cadena.contentEquals("SMARTPHONE")) resultado = TipoPregunta.SMARTPHONE;
		
		return resultado;
	}
	
}
