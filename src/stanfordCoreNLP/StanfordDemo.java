package stanfordCoreNLP;

import java.io.*;
import java.text.Normalizer;
import java.util.*;

import edu.stanford.nlp.coref.CorefCoreAnnotations;

import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.io.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.semgraph.SemanticGraphEdge;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.simple.Token;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.*;

/** This class demonstrates building and using a Stanford CoreNLP pipeline. */
public class StanfordDemo {	
	

	public StanfordDemo() { 		
	}
	
	public ArrayList<Palabra> identificarPalabras(String texto){
		ArrayList<Palabra> palabras = new ArrayList<>();
		String sampleSpanishText = texto;
		//Creo la anotación y las propiedades.
		Annotation spanishAnnotation = new Annotation(sampleSpanishText);
		Properties spanishProperties = StringUtils.argsToProperties(new String[]{"-props", "StanfordCoreNLP-spanish.properties"});
		spanishProperties.setProperty("annotators",  "tokenize, ssplit, pos, lemma, ner, depparse, kbp");
		//Creo un pipeline.
		StanfordCoreNLP pipeline = new StanfordCoreNLP(spanishProperties);
		pipeline.annotate(spanishAnnotation);
		
		// Una anotación es un mapa con claves de clase para los tipos de análisis lingüístico.
		// Puedes obtener y usar los distintos análisis individualmente.
		List<CoreMap> sentences = spanishAnnotation.get(CoreAnnotations.SentencesAnnotation.class);	
		//Verifico que haya sentencia y que la misma no esté vacía. 
		if (sentences != null && ! sentences.isEmpty()) {
			//Obtengo la primera sentencia/oración 
		    CoreMap sentence = sentences.get(0);
		    //Por cada palabra identificada la agrego  
		    for (CoreMap token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {	    	  
		      palabras.add(new Palabra(token.get(CoreAnnotations.TextAnnotation.class) , token.get(CoreAnnotations.PartOfSpeechAnnotation.class)));
		    }
		}
		
		return palabras;
	}
	
	public void normalizar(ArrayList<Palabra> palabras) {
		//Elimino los signos de puntuación como los puntos, comas, etc.
		eliminarPuntuaciones(palabras);
		for (Palabra p : palabras) {
			//Elimino a minúscula
			pasarAMinuscula(p);
			//Elimino acentos
			eliminarAcentos(p);
			//Si la palabra es un verbo...
			/*if(p.getParte().equalsIgnoreCase("VERB")) {
				//... lo paso a infinitivo
				pasarAInfinitivo(p);
			}*/
		}
		
	}

	private void pasarAInfinitivo(Palabra p) {
		
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
		//Creo una copia para ir iterando sobre él
		ArrayList<Palabra> pAux = new ArrayList<>();
		pAux.addAll(palabras);
		
		for(Palabra p : pAux) {
			//Si p es un signo de puntuación...
			if(p.getParte().equalsIgnoreCase("PUNCT")) {
				//...lo remuevo del ArrayList original
				palabras.remove(p);
			}
		}
		/*System.out.println("LUEGO DE ELIMINAR LA PUNTUACÓN");
		for(Palabra p : palabras) {
			System.out.println(p.getPalabra()+" , "+p.getParte());
		}*/
	}
	
	
	
}



