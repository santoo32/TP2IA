package productionsystem;

import java.util.ArrayList;
import java.util.List;

import sttYtts.EscribirArchivo;

public class Estrategia {
	private List<Regla> reglasActivas;
	private List<Regla> reglasUsadas;
	private String resolucion;

	public Estrategia() {
		super();
	}

	public List<Regla> getReglasActivas() {
		return reglasActivas;
	}
	public void setReglasActivas(List<Regla> reglasActivas) {
		this.reglasActivas = reglasActivas;
	}
	public List<Regla> getReglasUsadas() {
		return reglasUsadas;
	}
	public void setReglasUsadas(List<Regla> reglasUsadas) {
		this.reglasUsadas = reglasUsadas;
	}
	public void agregarUsada(Regla r) {
		this.reglasUsadas.add(r);
	}


	public Regla buscarRegla(boolean mode) {
		Regla r = new Regla();
		ArrayList<Regla> aux = new ArrayList<Regla>();
		EscribirArchivo ea = new EscribirArchivo();
		resolucion="";
		//Orden a seguir: NO DUPLICACION - NOVEDAD - ESPECIFICIDAD - PRIORIDAD - ALEATORIO
		
		//probar con no duplicacion
		aux = this.noDuplicacion();
		if(aux.size()==1) {
			r= aux.get(0); System.out.println("Se uso la estrategia No duplicacion ");}
		else {
			//probar con novedad
			this.reglasActivas=aux;
			aux=this.novedad();
			if(aux.size()==1) {
				r=aux.get(0);System.out.println("Se uso la estrategia Novedad "); 
			}else {
				//probar con especificidad
				this.reglasActivas = aux;
				aux=this.especificidad();
				if(aux.size()==1) {
					r= aux.get(0); System.out.println("Se uso la estrategia Especificidad ");}
				else {
					//probar con prioridad
					this.reglasActivas = aux;
					aux=this.prioridad();
					if(aux.size()==1) {
						r= aux.get(0); System.out.println("Se uso la estrategia Prioridad ");}
					else {
						//probar con novedad
						this.reglasActivas = aux;
						Aleatorio a = new Aleatorio();
						r = a.random(this.reglasActivas); System.out.println("Se uso la estrategia Aleatorio ");resolucion+=" Aleatorio ";
					}
					
				}
			}
			
		}
		if(mode)
			ea.escribirFaseResolucion(resolucion, r);
		else 
			ea.escribirFaseResolucionV(resolucion, r);
		return r;
	}
	
	public ArrayList<Regla> noDuplicacion(){
		ArrayList<Regla> rtdo = new ArrayList<Regla>();
		NoDuplicacion np = new NoDuplicacion();
		rtdo = np.noDuplication(reglasActivas, reglasUsadas);
		if(rtdo.size()!=reglasActivas.size()) this.resolucion+="No duplicacion";
		if(rtdo.size() > 1) {
			return rtdo;} 
		else if (rtdo.size()==0)
			return (ArrayList<Regla>) this.reglasActivas;
		else return rtdo;
		
	}
	
	public ArrayList<Regla> especificidad(){
		ArrayList<Regla> rtdo = new ArrayList<Regla>();
		Especificidad e = new Especificidad();
		rtdo = e.specificity(this.reglasActivas);
		if(rtdo.size()!=reglasActivas.size())resolucion+=" Especificidad ";
		if(rtdo.size() > 1) {
			return rtdo;}
		else if (rtdo.size()==0)
			return (ArrayList<Regla>) this.reglasActivas;
		else return rtdo;
	}
	
	public ArrayList<Regla> prioridad(){
		ArrayList<Regla> rtdo = new ArrayList<Regla>();
		Prioridad p = new Prioridad();
		rtdo = p.priority(this.reglasActivas);
		if(rtdo.size()!=reglasActivas.size())resolucion+=" Prioridad ";
		if(rtdo.size() > 1) {
			return rtdo;}
		else if (rtdo.size()==0)
			return (ArrayList<Regla>) this.reglasActivas;
		else return rtdo;
	}
	public ArrayList<Regla> novedad(){
		ArrayList<Regla> rtdo = new ArrayList<Regla>();
		Novedad n = new Novedad();
		rtdo = n.novelty(this.reglasActivas);
		if(rtdo.size()!=reglasActivas.size()) resolucion+=" Novedad ";
		if(rtdo.size() > 1) {
			 return rtdo;}
		else if (rtdo.size()==0)
			return (ArrayList<Regla>) this.reglasActivas;
		else return rtdo;
	}
	
	
	
}
