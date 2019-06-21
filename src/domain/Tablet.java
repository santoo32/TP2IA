package domain;

public class Tablet {
	private String marca;
	private Double precio;
	private Double tamPantalla;
	private Double memoriaRam; //EN GIGAS
	private Double memoriaRom; //EN GIGAS
	private Double resolucionCamara; //En megapixeles
	
	
	public Tablet(String marca, Double precio, Double tamPantalla, Double memoriaRam, Double memoriaRom,
			Double resolucionCamara) {
		super();
		this.marca = marca;
		this.precio = precio;
		this.tamPantalla = tamPantalla;
		this.memoriaRam = memoriaRam;
		this.memoriaRom = memoriaRom;
		this.resolucionCamara = resolucionCamara;
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
	public Double getTamPantalla() {
		return tamPantalla;
	}
	public void setTamPantalla(Double tamPantalla) {
		this.tamPantalla = tamPantalla;
	}
	public Double getMemoriaRam() {
		return memoriaRam;
	}
	public void setMemoriaRam(Double memoriaRam) {
		this.memoriaRam = memoriaRam;
	}
	public Double getMemoriaRom() {
		return memoriaRom;
	}
	public void setMemoriaRom(Double memoriaRom) {
		this.memoriaRom = memoriaRom;
	}
	public Double getResolucionCamara() {
		return resolucionCamara;
	}
	public void setResolucionCamara(Double resolucionCamara) {
		this.resolucionCamara = resolucionCamara;
	}
	
	public String toString() {
		return this.marca +" RAM: "+this.memoriaRam + " DISCO: " + this.memoriaRom + "GB "+ this.tamPantalla + "'' Camara: " + this.resolucionCamara + " $"+this.precio;  
	}
	

}
