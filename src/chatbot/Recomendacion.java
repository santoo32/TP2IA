package chatbot;

import domain.*;
import productionsystem.TipoPregunta;

import java.util.ArrayList;

public class Recomendacion {
	private ArrayList<Notebook> notebooks;
	private ArrayList<Smartphone> smartphones;
	private ArrayList<Tablet> tablets;
	private ArrayList<Tv> tvs;
	private ArrayList<Notebook> resultadoN;
	private ArrayList<Smartphone> resultadoS;
	private ArrayList<Tablet> resultadoT;
	private ArrayList<Tv> resultadoV;
	
	public Recomendacion() {
		this.notebooks = new ArrayList<Notebook>();
		this.smartphones = new ArrayList<Smartphone>();
		this.tablets = new ArrayList<Tablet>();
		this.tvs = new ArrayList<Tv>();
		this.resultadoN = new ArrayList<Notebook>();
		this.resultadoS = new ArrayList<Smartphone>();
		this.resultadoT = new ArrayList<Tablet>();
		this.resultadoV = new ArrayList<Tv>();
	}

	public ArrayList<Notebook> getNotebooks() {
		return notebooks;
	}

	public void setNotebooks(ArrayList<Notebook> notebooks) {
		this.notebooks = notebooks;
	}

	public ArrayList<Smartphone> getSmartphones() {
		return smartphones;
	}

	public void setSmartphones(ArrayList<Smartphone> smartphones) {
		this.smartphones = smartphones;
	}

	public ArrayList<Tablet> getTablets() {
		return tablets;
	}

	public void setTablets(ArrayList<Tablet> tablets) {
		this.tablets = tablets;
	}

	public ArrayList<Tv> getTvs() {
		return tvs;
	}

	public void setTvs(ArrayList<Tv> tvs) {
		this.tvs = tvs;
	}
	
	public void filtrar(TipoPregunta tipo, String filtrado) {
		switch(tipo) {
		case TIPOPRODUCTO: this.filtrarTipo(filtrado);
			break;
		case USO: this.filtrarUso(filtrado);
			break;
		case PRECIO: this.filtrarPrecio(filtrado);
		case TAMPANTALLA:
			break;
		case RESPANTALLA:
			break;
		case RAM:
			break;
		case ROM:
			break;
		case CAMARA:
			break;
		case SO:
			break;
		}
		
	}

	private void filtrarPrecio(String filtrado) {
		
		
	}

	private void filtrarUso(String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("diseno")) {
			for(Notebook n: resultadoN) {
				if(n.isPlacaDeVideo()) aux.add(n);
			}
			resultadoN = aux;
		}else if(filtrado.equals("programar")) {
			for(Notebook n: resultadoN) {
				if(n.getProcesador().equals("Intel core i7") || n.getProcesador().equals("Intel core i5")) aux.add(n);
			}
			resultadoN = aux;
		}else if(filtrado.equals("oficina")) {
			for(Notebook n: resultadoN) {
				if(!n.isPlacaDeVideo()) aux.add(n);
			}
			resultadoN = aux;
		}
		
	}

	private void filtrarTipo(String filtrado) {
		if(filtrado.equals("notebook")) this.resultadoN.addAll(this.notebooks);
		else if(filtrado.equals("smartphone")) this.resultadoS.addAll(this.smartphones);
		else if(filtrado.equals("tablet")) this.resultadoT.addAll(this.tablets);
		else if(filtrado.equals("tv")) this.resultadoV.addAll(this.tvs);
	}
}
