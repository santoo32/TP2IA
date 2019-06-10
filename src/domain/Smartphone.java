package domain;

public class Smartphone {
	private String marca;
	private Double precio;
	private Double tamPantalla;
	private Double resolucionCamara; //en megapixeles (la trasera)
	private Integer memoriaRom; //EN GIGAS
	private Integer memoriaRam; //EN GIGAS
	private String SO; //Android o IOS
	
	
	public Smartphone(String marca, Double precio, Double tamPantalla, Double resolucionCamara, Integer memoriaRom,
			Integer memoriaRam, String sO) {
		super();
		this.marca = marca;
		this.precio = precio;
		this.tamPantalla = tamPantalla;
		this.resolucionCamara = resolucionCamara;
		this.memoriaRom = memoriaRom;
		this.memoriaRam = memoriaRam;
		SO = sO;
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
	public Double getResolucionCamara() {
		return resolucionCamara;
	}
	public void setResolucionCamara(Double resolucionCamara) {
		this.resolucionCamara = resolucionCamara;
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
	public String getSO() {
		return SO;
	}
	public void setSO(String sO) {
		SO = sO;
	}
	
	
	
}
