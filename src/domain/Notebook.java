package domain;

public class Notebook {
	private Double precio;
	private String marca;
	private String procesador;
	private Double tamPantalla;
	private String resolucion; //HD O FULL HD
	private Double memoriaRom; //EN GIGAS
	private Double memoriaRam; //EN GIGAS
	private boolean placaDeVideo; //true si tiene sino false
	
	public Notebook(Double precio, String marca, String procesador, Double tamPantalla, String resolucion,
			Double memoriaRom, Double memoriaRam, boolean placaDeVideo) {
		super();
		this.precio = precio;
		this.marca = marca;
		this.procesador = procesador;
		this.tamPantalla = tamPantalla;
		this.resolucion = resolucion;
		this.memoriaRom = memoriaRom;
		this.memoriaRam = memoriaRam;
		this.placaDeVideo = placaDeVideo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getProcesador() {
		return procesador;
	}
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	public Double getTamPantalla() {
		return tamPantalla;
	}
	public void setTamPantalla(Double tamPantalla) {
		this.tamPantalla = tamPantalla;
	}
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public Double getMemoriaRom() {
		return memoriaRom;
	}
	public void setMemoriaRom(Double memoriaRom) {
		this.memoriaRom = memoriaRom;
	}
	public Double getMemoriaRam() {
		return memoriaRam;
	}
	public void setMemoriaRam(Double memoriaRam) {
		this.memoriaRam = memoriaRam;
	}
	public boolean isPlacaDeVideo() {
		return placaDeVideo;
	}
	public void setPlacaDeVideo(boolean placaDeVideo) {
		this.placaDeVideo = placaDeVideo;
	}
	
	
}
