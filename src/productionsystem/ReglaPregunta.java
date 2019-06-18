package productionsystem;

import java.util.ArrayList;

public class ReglaPregunta extends Regla{
	private TipoPregunta tipoPregunta;
	private ArrayList<TipoPregunta> condicion;
	private String salida;
	
	
	public ReglaPregunta() {
	}
	public ReglaPregunta(TipoPregunta tipoPregunta, ArrayList<TipoPregunta> condicion, String salida) {
		super();
		this.tipoPregunta = tipoPregunta;
		this.condicion = condicion;
		this.salida = salida;
		this.setEspecificidad(condicion.size());
	}
	public TipoPregunta getTipoPregunta() {
		return tipoPregunta;
	}
	public void setTipoPregunta(TipoPregunta tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}
	public ArrayList<TipoPregunta> getCondicion() {
		return condicion;
	}
	public void setCondicion(ArrayList<TipoPregunta> condicion) {
		this.condicion = condicion;
		this.setEspecificidad(condicion.size());
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	
	public boolean verificarPregunta(ArrayList<TipoPregunta> preguntasHechas) {
		int contador =0;
		int cantTipos = this.condicion.size();
		for(TipoPregunta t1 : this.condicion) {
			for(TipoPregunta t2 : preguntasHechas) {
				if(t1.equals(t2)) contador++;
			}
		}
		this.setNovedad(contador);
		if(contador==cantTipos) return true;
		else return false;
	}
}
