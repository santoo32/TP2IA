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
	private String tipo;
	
	public Recomendacion() {
		this.cargarProductos();
		this.setVariables();
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
	
	public String recomendar() {
		String respuesta="";
		if(tipo.equals("notebook")) {
			for(Notebook n : this.resultadoN)
				respuesta += n.toString() + "\n"; 
		}
		else if(tipo.equals("smartphone")) {
			for(Smartphone n : this.resultadoS)
				respuesta += n.toString() + "\n";
		}
		else if(tipo.equals("tablet")) {
			for(Tablet n : this.resultadoT)
				respuesta += n.toString() + "\n";
		}
		else if(tipo.equals("tv")) {
			for(Tv n : this.resultadoV)
				respuesta += n.toString() + "\n";
		}
		return respuesta;
	}
	public void setVariables() {
		this.resultadoN = new ArrayList<Notebook>();
		this.resultadoS = new ArrayList<Smartphone>();
		this.resultadoT = new ArrayList<Tablet>();
		this.resultadoV = new ArrayList<Tv>();
		this.resultadoN.addAll(this.notebooks);
		this.resultadoS.addAll(this.smartphones);
		this.resultadoT.addAll(this.tablets);
		this.resultadoV.addAll(this.tvs);
		this.tipo="";
	}
	
	

	public void filtrar(TipoPregunta tipo, String filtrado) {
		switch(tipo) {
		case TIPOPRODUCTO: this.filtrarTipo(filtrado);
			break;
		case USO: this.filtrarUso(filtrado);
			break;
		case PRECIO: this.filtrarPrecio(filtrado);
			break;
		case TAMPANTALLA: this.filtrarPantalla(filtrado);
			break;
		case RESPANTALLA: this.filtrarResolucion(filtrado);
			break;
		case RAM: this.filtrarRam(filtrado);
			break;
		case ROM: this.filtrarRom(filtrado);
			break;
		case CAMARA: this.filtrarCamara(filtrado);
			break;
		case SO: this.filtrarSO(filtrado);
			break;
		}
		
	}

	private void filtrarCamara(String filtrado) {
		if(tipo.equals("smartphone")) this.filtrarCamaraSmartphone(13.0,filtrado);
		else if(tipo.equals("tablet")) this.filtrarCamaraTablet(5.0,filtrado);
		
		//smartphone 13
		//tablet 5
		
	}

	private void filtrarCamaraTablet(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("camarabuena")) {
			for(Tablet n : this.resultadoT) {
				if(n.getResolucionCamara()>d) aux.add(n);
			}
		}else if(filtrado.equals("camaranormal")) {
			for(Tablet n : this.resultadoT) {
				if(n.getResolucionCamara()<=d) aux.add(n);
			}
		}
		this.resultadoT=aux;
		
	}

	private void filtrarCamaraSmartphone(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("camarabuena")) {
			for(Smartphone n : this.resultadoS) {
				if(n.getResolucionCamara()>d) aux.add(n);
			}
		}else if(filtrado.equals("camaranormal")) {
			for(Smartphone n : this.resultadoS) {
				if(n.getResolucionCamara()<=d) aux.add(n);
			}
		}
		this.resultadoS=aux;
		
	}

	private void filtrarRom(String filtrado) {
		if(tipo.equals("notebook")) this.filtrarRomNotebook(500.0,filtrado);
		else if(tipo.equals("smartphone")) this.filtrarRomSmartphone(16.0,filtrado);
		else if(tipo.equals("tablet")) this.filtrarRomTablet(16.0,filtrado);
		
		//notebook 500
		//smartphone 16
		//tablet 16
		
	}

	private void filtrarRomTablet(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("mucharam")) {
			for(Tablet n : this.resultadoT) {
				if(n.getMemoriaRom()>d) aux.add(n);
			}
		}else if(filtrado.equals("pocaram")) {
			for(Tablet n : this.resultadoT) {
				if(n.getMemoriaRom()<=d) aux.add(n);
			}
		}
		this.resultadoT=aux;
		
	}

	private void filtrarRomSmartphone(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("muchodisco")) {
			for(Smartphone n : this.resultadoS) {
				if(n.getMemoriaRom()>d) aux.add(n);
			}
		}else if(filtrado.equals("pocodisco")) {
			for(Smartphone n : this.resultadoS) {
				if(n.getMemoriaRom()<=d) aux.add(n);
			}
		}
		this.resultadoS=aux;
		
	}

	private void filtrarRomNotebook(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("muchodisco")) {
			for(Notebook n : this.resultadoN) {
				if(n.getMemoriaRom()>d) aux.add(n);
			}
		}else if(filtrado.equals("pocodisco")) {
			for(Notebook n : this.resultadoN) {
				if(n.getMemoriaRom()<=d) aux.add(n);
			}
		}
		this.resultadoN=aux;
		
	}

	private void filtrarRam(String filtrado) {
		if(tipo.equals("notebook")) this.filtrarRamNotebook(4.0,filtrado);
		else if(tipo.equals("smartphone")) this.filtrarRamSmartphone(4.0,filtrado);
		else if(tipo.equals("tablet")) this.filtrarRamTablet(2.0,filtrado);
		
		//notebook 4
		//smartphone 4
		//tablet 2
		
	}

	private void filtrarRamTablet(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("mucharam")) {
			for(Tablet n : this.resultadoT) {
				if(n.getMemoriaRam()>d) aux.add(n);
			}
		}else if(filtrado.equals("pocaram")) {
			for(Tablet n : this.resultadoT) {
				if(n.getMemoriaRam()<=d) aux.add(n);
			}
		}
		this.resultadoT=aux;
		
	}

	private void filtrarRamSmartphone(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("mucharam")) {
			for(Smartphone n : this.resultadoS) {
				if(n.getMemoriaRam()>d) aux.add(n);
			}
		}else if(filtrado.equals("pocaram")) {
			for(Smartphone n : this.resultadoS) {
				if(n.getMemoriaRam()<=d) aux.add(n);
			}
		}
		this.resultadoS=aux;
		
	}

	private void filtrarRamNotebook(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("mucharam")) {
			for(Notebook n : this.resultadoN) {
				if(n.getMemoriaRam()>d) aux.add(n);
			}
		}else if(filtrado.equals("pocaram")) {
			for(Notebook n : this.resultadoN) {
				if(n.getMemoriaRam()<=d) aux.add(n);
			}
		}
		this.resultadoN=aux;
		
	}

	private void filtrarSO(String filtrado) {
		ArrayList aux = new ArrayList();
		for(Smartphone s : this.resultadoS) {
			if(s.getSO().equals(filtrado)) aux.add(s);
		}
		this.resultadoS=aux;
	}

	private void filtrarResolucion(String filtrado) {
		ArrayList aux = new ArrayList();
		if(tipo.equals("notebook")) {
			for(Notebook n : this.resultadoN) {
				if(n.getResolucion().equals(filtrado)) aux.add(n);
			}
			resultadoN=aux;
		}
		else if(tipo.equals("tv")) {
			for(Tv n : this.resultadoV) {
				if(n.getResolucion().equals(filtrado)) aux.add(n);
			}
			resultadoV=aux;
		}
		
	}

	private void filtrarPantalla(String filtrado) {
		if(tipo.equals("notebook")) this.filtrarPantallaNotebook(14.0,filtrado);
		else if(tipo.equals("tv"))this.filtrarPantallaTv(40.0,filtrado);
		//notebook- 14
		//tv 40
		
	}

	private void filtrarPantallaTv(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("grande")) {
			for(Tv n : this.resultadoV) {
				if(n.getPulgadas()>=d) aux.add(n);
			}
		}else if(filtrado.equals("chica")) {
			for(Tv n : this.resultadoV) {
				if(n.getPulgadas()<=d) aux.add(n);
			}
		}
		this.resultadoV=aux;
		
	}

	private void filtrarPantallaNotebook(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("grande")) {
			for(Notebook n : this.resultadoN) {
				if(n.getTamPantalla()>=d) aux.add(n);
			}
		}else if(filtrado.equals("chica")) {
			for(Notebook n : this.resultadoN) {
				if(n.getTamPantalla()<=d) aux.add(n);
			}
		}
		this.resultadoV=aux;
		
		
	}

	private void filtrarPrecio(String filtrado) {
		
		if(tipo.equals("notebook")) this.filtrarPrecioNotebook(40000.0,filtrado);
		else if(tipo.equals("smartphone")) this.filtrarPrecioSmartphone(15000.0,filtrado);
		else if(tipo.equals("tablet")) this.filtrarPrecioTablet(10000.0,filtrado);
		else if(tipo.equals("tv"))this.filtrarPrecioTv(20000.0,filtrado);
		//notebook- 40000
		//smartphone 15000
		//tablet 10000
		//tv 20000
		
	}

	

	private void filtrarPrecioTv(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("gastarmucho")) {	
			for(Tv n : this.resultadoV) {
				if(n.getPrecio()>=d) aux.add(n);
			}
		}else if(filtrado.equals("gastarpoco")) {
			for(Tv n : this.resultadoV) {
				if(n.getPrecio()<=d) aux.add(n);
			}
		}
		
		this.resultadoV=aux;
	}

	private void filtrarPrecioTablet(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("gastarmucho")) {
			for(Tablet n : this.resultadoT) {
				if(n.getPrecio()>=d) aux.add(n);
			}
		}else if(filtrado.equals("gastarpoco")) {
			for(Tablet n : this.resultadoT) {
				if(n.getPrecio()<=d) aux.add(n);
			}
		}
		this.resultadoT=aux;

		
	}

	private void filtrarPrecioSmartphone(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("gastarmucho")) {
			for(Smartphone n : this.resultadoS) {
				if(n.getPrecio()>=d) aux.add(n);
			}
		}else if(filtrado.equals("gastarpoco")) {
			for(Smartphone n : this.resultadoS) {
				if(n.getPrecio()<=d) aux.add(n);
			}
		}
		this.resultadoS=aux;
		
	}

	private void filtrarPrecioNotebook(double d, String filtrado) {
		ArrayList aux = new ArrayList();
		if(filtrado.equals("gastarmucho")) {
			for(Notebook n : this.resultadoN) {
				if(n.getPrecio()>=d) aux.add(n);
			}
		}else if(filtrado.equals("gastarpoco")) {
			for(Notebook n : this.resultadoN) {
				if(n.getPrecio()<=d) aux.add(n);
			}
		}
		this.resultadoN=aux;
		
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
		if(filtrado.equals("notebook")) tipo="notebook";
		else if(filtrado.equals("smartphone")) tipo="smartphone";
		else if(filtrado.equals("tablet")) tipo="tablet";
		else if(filtrado.equals("tv"))tipo="tv";
	}
	private void cargarProductos() {
		//Notebooks
	       this.notebooks = new ArrayList<Notebook>();
	       
	       notebooks.add(new Notebook(17999.0, "LENOVO", "Intel Celeron", 13, "HD", 120, 2, false));
	       notebooks.add(new Notebook(3600.0, "Acer", "Intel core i5", 15, "HD", 1000, 4, false));
	       notebooks.add(new Notebook(50000.0, "Acer", "Intel core i7", 15, "HD", 1000, 8, false));
	       notebooks.add(new Notebook(57985.0, "Asus", "Intel core i5", 15, "FULL HD", 1000, 8, true));
	       notebooks.add(new Notebook(65000.0, "HP", "Intel core i7", 15, "FULL HD", 256, 8, false));
	       notebooks.add(new Notebook(80000.0, "MacBook Air", "Intel core i5", 13, "FULL HD", 128, 8, false));
	       
	       //Smartphones
	       this.smartphones = new ArrayList<Smartphone>();
	       
	       smartphones.add(new Smartphone("Moto", 10000.0, 5.7, 13.0, 16, 2, "android"));
	       smartphones.add(new Smartphone("LG", 14000.0, 5.3, 13.0, 32, 3, "android"));
	       smartphones.add(new Smartphone("Samsung", 15280.0, 6.0, 16.0, 32, 3, "android"));
	       smartphones.add(new Smartphone("Samsung", 55000.0, 6.0, 16.0, 128, 8, "android"));
	       smartphones.add(new Smartphone("Iphone", 45000.0, 5.5, 12.0, 32, 3, "ios"));
	       smartphones.add(new Smartphone("Iphone", 58500.0, 5.8, 12.0, 64, 4, "ios"));
	       
	       //Tablets
	        this.tablets = new ArrayList<Tablet>();
	        
	        tablets.add(new Tablet("Samsung", 11000.0, 9.6, 1.5, 8.0, 5.0));
	        tablets.add(new Tablet("Huawei", 6000.0, 7.0, 1.0, 16.0, 2.0));
	        tablets.add(new Tablet("Nexus", 15500.0, 8.9, 2.0, 32.0, 8.0));
	        tablets.add(new Tablet("Apple", 34000.0, 10.5, 3.0, 64.0, 8.0));
	        
	        //TVs
	        this.tvs = new ArrayList<Tv>();
	        
	        tvs.add(new Tv("Noblex", 19500.0, 50, "Smart", "FULL HD"));
	        tvs.add(new Tv("BGH", 26000.0, 50, "Smart", "4K"));
	        tvs.add(new Tv("LG", 12000.0, 32, "Smart", "FULL HD"));
	        tvs.add(new Tv("Sony", 57494.0, 60, "Smart", "4K"));
	        tvs.add(new Tv("Samsung", 30000.0, 55, "Smart", "FULL HD"));
		
	}
}
