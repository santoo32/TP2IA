package domain;

public class Tv {
	private String marca;
	private Double precio;
	private int pulgadas;
	private String tipo; //LED O SMART
	private String resolucion; //HD, FULL HD o 4K
	
	
	public Tv(String marca, Double precio, int pulgadas, String tipo, String resolucion) {
		super();
		this.marca = marca;
		this.precio = precio;
		this.pulgadas = pulgadas;
		this.tipo = tipo;
		this.resolucion = resolucion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	
	public String toString() {
		return this.marca +" Pulgadas: "+this.pulgadas + " Resolucion "+ this.resolucion + " Tipo: " + this.tipo   + " $"+this.precio;  
	}

}
