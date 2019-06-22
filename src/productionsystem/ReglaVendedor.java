package productionsystem;

import java.util.ArrayList;

public class ReglaVendedor extends Regla{
	private TipoPregunta tipoPregunta;
	private ArrayList<String> condicion;
	private String filtrado;
	private String salida;
	private String tipoProducto;
	
	public ReglaVendedor() {
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
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public boolean verificarCondicion(ArrayList<String> palabras) {
		int contador =0;
		int cantPalabras = this.condicion.size();
		for(String s1 : palabras) {
			for(String s2 : this.condicion) {
				if(s1.equals(s2)) contador++;
			}
		}
		this.setNovedad(contador);
		if(contador==cantPalabras)
			return true;
		else return false;
	}
}
