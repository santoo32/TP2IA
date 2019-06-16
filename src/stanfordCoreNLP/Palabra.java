package stanfordCoreNLP;

public class Palabra {
	private String palabra;
	private String parte;
	
	public Palabra(String palabra, String parte) {
		super();
		this.palabra = palabra;
		this.parte = parte;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public String getParte() {
		return parte;
	}

	public void setParte(String parte) {
		this.parte = parte;
	}
	

}
