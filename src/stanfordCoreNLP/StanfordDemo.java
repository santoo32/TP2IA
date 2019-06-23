package stanfordCoreNLP;

import java.text.Normalizer;
import java.util.*;

import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.*;

/** This class demonstrates building and using a Stanford CoreNLP pipeline. */
public class StanfordDemo {	
	

	public StanfordDemo() { 		
	}
	
	public ArrayList<Palabra> identificarPalabras(String texto){
		ArrayList<Palabra> palabras = new ArrayList<>();
		String sampleSpanishText = texto;
		//Creo la anotaci�n y las propiedades.
		Annotation spanishAnnotation = new Annotation(sampleSpanishText);
		Properties spanishProperties = StringUtils.argsToProperties(new String[]{"-props", "StanfordCoreNLP-spanish.properties"});
		spanishProperties.setProperty("annotators",  "tokenize, ssplit, pos, lemma, ner, depparse, kbp");
		//Creo un pipeline.
		StanfordCoreNLP pipeline = new StanfordCoreNLP(spanishProperties);
		pipeline.annotate(spanishAnnotation);
		
		// Una anotaci�n es un mapa con claves de clase para los tipos de an�lisis ling��stico.
		// Puedes obtener y usar los distintos an�lisis individualmente.
		List<CoreMap> sentences = spanishAnnotation.get(CoreAnnotations.SentencesAnnotation.class);	
		//Por cada sentencia identificada...
		for(CoreMap sent : sentences) {
			//y por cada palabra identificada la agrego  
		    for (CoreMap token : sent.get(CoreAnnotations.TokensAnnotation.class)) {	    	  
		      palabras.add(new Palabra(token.get(CoreAnnotations.TextAnnotation.class) , token.get(CoreAnnotations.PartOfSpeechAnnotation.class)));
		    }
		}
		
		return palabras;
	}
	
	public void normalizar(ArrayList<Palabra> palabras) {
		//Elimino los signos de puntuaci�n como los puntos, comas, etc.
		eliminarPuntuaciones(palabras);
		for (Palabra p : palabras) {
			//Elimino a min�scula
			pasarAMinuscula(p);
			//Si es adjetivo o sustantivo lo paso a singular //X es para la tablet que no se porque no me la clasifica
			if(p.getParte().equalsIgnoreCase("ADJ")|| p.getParte().equalsIgnoreCase("X") || p.getParte().equalsIgnoreCase("PROPN") || p.getParte().equalsIgnoreCase("NOUN") || p.getPalabra().startsWith("notebook")) {
				pluralASingular(p);
			}
			//Elimino acentos
			eliminarAcentos(p);
			//Si la palabra es un verbo...
			if(p.getParte().equalsIgnoreCase("VERB")) {
				//... lo paso a infinitivo
				pasarAInfinitivo(p);
			}
		}
		
	}

	private void pasarAInfinitivo(Palabra p) {
		String s = p.getPalabra();
		//Comparo los prefijos para pasarlo a infinitivo
		if (s.startsWith("necesit")) {
			p.setPalabra("necesitar");
		}
		if (s.startsWith("quer") || s.startsWith("quier")) {
			p.setPalabra("querer");
		}
		if (s.startsWith("busc")) {
			p.setPalabra("buscar");
		}
		if (s.startsWith("pregunt")) {
			p.setPalabra("preguntar");
		}
		if (s.startsWith("jug")) {
			p.setPalabra("jugar");
		}
		if (s.startsWith("program")) {
			p.setPalabra("programar");
		}
		if (s.startsWith("codific")) {
			p.setPalabra("codificar");
		}
		if (s.startsWith("desarroll")) {
			p.setPalabra("desarrollar");
		}
		if (s.startsWith("gast")) {
			p.setPalabra("gastar");
		}
	}
	
	private void pluralASingular(Palabra p) {
		String s = p.getPalabra();		
		String aux;
		//Si termina en -is -> -y
		if(s.endsWith("is")) {
			aux = s.substring(0, s.length()-2); //length -1 me retorna el string sin la �ltima letra, -2 me retorna el string sin las �ltimas 2 letras
			p.setPalabra(aux.concat("y"));
		}else {
			//Si termina en -ces -> -z
			if(s.endsWith("ces")) {
				//M�todo substring(�ndice de inicio, �ndice de fin sin incluirlo)
				aux = s.substring(0, s.length()-3); //length -1 me retorna el string sin la �ltima letra, -3 me retorna el string sin las �ltimas 3 letras
				p.setPalabra(aux.concat("z"));
			}else {
				//Si termina en -es -> sacar es 
				if(s.endsWith("es")) {
					aux = s.substring(0, s.length()-2); //length -1 me retorna el string sin la �ltima letra, -2 me retorna el string sin las �ltimas 2 letras
					p.setPalabra(aux);
				}else {
					//Si termina en -s -> sacar s
					if(s.endsWith("s")) {
						aux = s.substring(0, s.length()-1); //length -1 me retorna el string sin la �ltima letra
						p.setPalabra(aux);
					}
				}
			}
		}		
	}

	private void eliminarAcentos(Palabra p) {
		String s = p.getPalabra();
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
	    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    	    
	    p.setPalabra(s);
	    //System.out.println("Sin acento: "+p.getPalabra());
	}

	private void pasarAMinuscula(Palabra p) {
		p.setPalabra(p.getPalabra().toLowerCase());
	}

	private void eliminarPuntuaciones(ArrayList<Palabra> palabras) {		
		//Creo una copia para ir iterando sobre �l
		ArrayList<Palabra> pAux = new ArrayList<>();
		pAux.addAll(palabras);
		
		for(Palabra p : pAux) {
			//Si p es un signo de puntuaci�n...
			if(p.getParte().equalsIgnoreCase("PUNCT")) {
				//...lo remuevo del ArrayList original
				palabras.remove(p);
			}
		}
		/*System.out.println("LUEGO DE ELIMINAR LA PUNTUAC�N");
		for(Palabra p : palabras) {
			System.out.println(p.getPalabra()+" , "+p.getParte());
		}*/
	}
	
	public ArrayList<String> normalizarPalabras(String oracion){
		ArrayList<String> resultado = new ArrayList<String>();
		ArrayList<Palabra> aux = this.identificarPalabras(oracion);
		this.normalizar(aux);
		for(Palabra p : aux) {
			resultado.add(p.getPalabra());
		}
		
		return resultado;
	}
	
	
}



