package productionsystem;

import java.util.ArrayList;

public class ReglaRespuesta extends Regla{
	private TipoPregunta tipoPregunta;
	private ArrayList<String> condicion;
	private String filtrado;
	private String salida;
	
	public ReglaRespuesta() {
	}
	
	public ReglaRespuesta(TipoPregunta tipoPregunta, ArrayList<String> condicion, String filtrado, String salida) {
		super();
		this.tipoPregunta = tipoPregunta;
		this.condicion = condicion;
		this.filtrado = filtrado;
		this.salida = salida;
		this.setEspecificidad(condicion.size());
	}

	public TipoPregunta getTipoPregunta() {
		return tipoPregunta;
	}
	public void setTipoPregunta(TipoPregunta tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}
	public ArrayList<String> getCondicion() {
		return condicion;
	}
	public void setCondicion(ArrayList<String> condicion) {
		this.condicion = condicion;
		this.setEspecificidad(condicion.size());
	}
	public String getFiltrado() {
		return filtrado;
	}
	public void setFiltrado(String filtrado) {
		this.filtrado = filtrado;
	}
	
	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public boolean verificarCondicion(ArrayList<String> palabras, TipoPregunta preguntaActiva) {
		int contador =0;
		int cantPalabras = this.condicion.size();
		for(String s1 : palabras) {
			for(String s2 : this.condicion) {
				if(s1.equals(s2)) contador++;
			}
		}
		if(contador==cantPalabras && preguntaActiva.equals(tipoPregunta))
			return true;
		else return false;
	}
	
	public void cargarNovedad(TipoPregunta tipo) {
		if(tipo.equals(this.tipoPregunta)) this.setNovedad(true);
		else this.setNovedad(false);
	}
	
	
}
