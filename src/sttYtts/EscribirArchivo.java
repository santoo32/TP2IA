package sttYtts;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import productionsystem.*;

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
	
	public void escribirActivasRespuesta(ArrayList<Regla> reglasRespuestas, ArrayList<String> palabras, TipoPregunta preguntaActiva, ArrayList<TipoPregunta> preguntasHechas, ArrayList<Regla> reglasRespuestasUsadas) {
		try{
        	//Creo el fichero
        	nombre = "log.txt";
        	//Creo el txt. el parametro true es para que agregue al final del archivo (si es que ya está creado)
            fichero = new FileWriter(nombre,true);
            
            pw = new PrintWriter(fichero);
            String filtrarPor="";
            for(Regla r : reglasRespuestasUsadas) {
            	filtrarPor+=" FiltrarPor("+((ReglaRespuesta) r).getFiltrado()+")  ";
            }
            TipoPregunta tipoProducto=null;
            ArrayList<TipoPregunta> pregHechas = new ArrayList<TipoPregunta>();
            for(TipoPregunta tipo : preguntasHechas) {
            	if(tipo.equals(TipoPregunta.NOTEBOOK) || tipo.equals(TipoPregunta.TABLET) || tipo.equals(TipoPregunta.SMARTPHONE) || tipo.equals(TipoPregunta.TV)) tipoProducto=tipo;
            	else pregHechas.add(tipo);
            }
            //Escribo en el archivo
            pw.println("					BUSCANDO UNA RESPUESTA...");
            pw.println(" ");
            pw.println("MEMORIA DE TRABAJO:");
            pw.println(palabras +"   PreguntaActiva("+preguntaActiva+")  PreguntasHechas:"+ pregHechas+ filtrarPor);
            pw.println(" ");
            pw.println("FASE DE COTEJO:");
            pw.println("REGLAS ACTIVAS DE RESPUESTA:");
            for(Regla r : reglasRespuestas) {
            	pw.println(r.getId()+") P:"+r.getPrioridad()+" - "+((ReglaRespuesta) r).getCondicion()+" ^ PreguntaActiva("+((ReglaRespuesta) r).getTipoPregunta()+")===>"+
            ((ReglaRespuesta) r).getSalida()+ " ^ PreguntaHecha("+((ReglaRespuesta) r).getTipoPregunta()+") ^ FiltrarPor("+((ReglaRespuesta) r).getFiltrado()+")");
            }
            pw.println(" ");

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
	
	public void escribirFaseResolucion(String resolucion, Regla reglaEjecutada) {
		try{
        	//Creo el fichero
        	nombre = "log.txt";
        	//Creo el txt. el parametro true es para que agregue al final del archivo (si es que ya está creado)
            fichero = new FileWriter(nombre,true);
            
            pw = new PrintWriter(fichero);
            //Escribo en el archivo
            pw.println("FASE DE RESOLUCION:");
            pw.println("SE EJECUTA LA REGLA:"+reglaEjecutada.getId()+" UTILIZANDO: "+resolucion);
            pw.println(" ");
            

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
	
	public void escribirFaseDeEjecucionR(ArrayList<TipoPregunta> preguntasHechas, Regla reglaEjecutar) {
		try{
        	//Creo el fichero
        	nombre = "log.txt";
        	//Creo el txt. el parametro true es para que agregue al final del archivo (si es que ya está creado)
            fichero = new FileWriter(nombre,true);
            
            TipoPregunta tipoProducto=null;
            ArrayList<TipoPregunta> pregHechas = new ArrayList<TipoPregunta>();
            for(TipoPregunta tipo : preguntasHechas) {
            	if(tipo.equals(TipoPregunta.NOTEBOOK) || tipo.equals(TipoPregunta.TABLET) || tipo.equals(TipoPregunta.SMARTPHONE) || tipo.equals(TipoPregunta.TV)) tipoProducto=tipo;
            	else pregHechas.add(tipo);
            }
            
            pw = new PrintWriter(fichero);
            
            //Escribo en el archivo
            pw.println("FASE DE EJECUCION:");
            pw.println("PreguntasHechas:"+pregHechas+"  FiltrarPor("+((ReglaRespuesta) reglaEjecutar).getFiltrado()+")");
            pw.println(" ");
            

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
	public void escribirActivasPregunta(ArrayList<String> palabras, ArrayList<Regla> reglasPregunta, TipoPregunta preguntaActiva, ArrayList<TipoPregunta> preguntasHechas, ArrayList<Regla> reglasRespuestasUsadas) {
		try{
        	//Creo el fichero
        	nombre = "log.txt";
        	//Creo el txt. el parametro true es para que agregue al final del archivo (si es que ya está creado)
            fichero = new FileWriter(nombre,true);
            TipoPregunta tipoProducto=null;
            ArrayList<TipoPregunta> pregHechas = new ArrayList<TipoPregunta>();
            for(TipoPregunta tipo : preguntasHechas) {
            	if(tipo.equals(TipoPregunta.NOTEBOOK) || tipo.equals(TipoPregunta.TABLET) || tipo.equals(TipoPregunta.SMARTPHONE) || tipo.equals(TipoPregunta.TV)) tipoProducto=tipo;
            	else pregHechas.add(tipo);
            }
            String filtrarPor="";
            for(Regla r : reglasRespuestasUsadas) {
            	filtrarPor+=" FiltrarPor("+((ReglaRespuesta) r).getFiltrado()+")  ";
            }
            
            pw = new PrintWriter(fichero);
            //Escribo en el archivo
            pw.println("					BUSCANDO UNA PREGUNTA...");
            pw.println(" ");
            pw.println("MEMORIA DE TRABAJO:");
            pw.println(palabras +" PreguntaActiva("+preguntaActiva+")  PreguntasHechas:"+ pregHechas+filtrarPor);
            pw.println(" ");
            pw.println("FASE DE COTEJO:");
            pw.println("REGLAS ACTIVAS DE PREGUNTA:");
            for(Regla r : reglasPregunta) {
            	pw.println(r.getId()+") P:"+r.getPrioridad()+" - PreguntasHechas("+pregHechas+") ^ FiltrarPor("+tipoProducto+")===>"+((ReglaPregunta) r).getSalida()+" ^ PreguntaActiva("+((ReglaPregunta) r).getTipoPregunta()+")");
            }
            pw.println(" ");

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
	public void escribirFaseDeEjecucionP(Regla reglaEjecutar) {
		try{
        	//Creo el fichero
        	nombre = "log.txt";
        	//Creo el txt. el parametro true es para que agregue al final del archivo (si es que ya está creado)
            fichero = new FileWriter(nombre,true);
            
            pw = new PrintWriter(fichero);
            
            //Escribo en el archivo
            pw.println("FASE DE EJECUCION:");
            pw.println("PreguntaActiva("+((ReglaPregunta) reglaEjecutar).getTipoPregunta()+")");
            pw.println(" ");
            pw.println("--------------------------------------------------------------------------------------------------------");
            pw.println(" ");
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
