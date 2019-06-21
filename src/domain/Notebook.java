package domain;

public class Notebook {
	private Double precio;
	private String marca;
	private String procesador;
	private Integer tamPantalla;
	private String resolucion; //HD O FULL HD
	private Integer memoriaRom; //EN GIGAS
	private Integer memoriaRam; //EN GIGAS
	private boolean placaDeVideo; //true si tiene sino false
	
	public Notebook(Double precio, String marca, String procesador, Integer tamPantalla, String resolucion,
			Integer memoriaRom, Integer memoriaRam, boolean placaDeVideo) {
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
	public Integer getTamPantalla() {
		return tamPantalla;
	}
	public void setTamPantalla(Integer tamPantalla) {
		this.tamPantalla = tamPantalla;
	}
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public Integer getMemoriaRom() {
		return memoriaRom;
	}
	public void setMemoriaRom(Integer memoriaRom) {
		this.memoriaRom = memoriaRom;
	}
	public Integer getMemoriaRam() {
		return memoriaRam;
	}
	public void setMemoriaRam(Integer memoriaRam) {
		this.memoriaRam = memoriaRam;
	}
	public boolean isPlacaDeVideo() {
		return placaDeVideo;
	}
	public void setPlacaDeVideo(boolean placaDeVideo) {
		this.placaDeVideo = placaDeVideo;
	}
	
	public String toString() {
		return this.marca + " " + this.procesador +" Ram: "+this.memoriaRam + "GB DISCO: " + this.memoriaRom + "GB "+ this.tamPantalla + "'' " + this.resolucion + " $"+this.precio;  
	}
	
}
