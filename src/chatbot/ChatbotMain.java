package chatbot;

import domain.Notebook;
import domain.Smartphone;
import domain.Tablet;
import domain.Tv;
import static java.time.Clock.system;
import java.util.ArrayList;
import tp2iav1.pkg0.interfazPrincipal;

public class ChatbotMain {
    
    public static AgenteBasadoEnConocimiento a;
    
	public static void main(String[] args)  {

        a = new AgenteBasadoEnConocimiento();
		
        //LLAMAR A LA INTERFAZ
       interfazPrincipal ventana = new interfazPrincipal(a);
       ventana.setLocationRelativeTo(null);
       ventana.setVisible(true);
       
       
      
       //Notebooks
       ArrayList<Notebook> listaNotebooks = new ArrayList<Notebook>();
       
       listaNotebooks.add(new Notebook(17999.0, "LENOVO", "Intel Celeron", 13, "HD", 120, 2, false));
       listaNotebooks.add(new Notebook(3600.0, "Acer", "Intel core i5", 15, "HD", 1000, 4, false));
       listaNotebooks.add(new Notebook(50000.0, "Acer", "Intel core i7", 15, "HD", 1000, 8, false));
       listaNotebooks.add(new Notebook(57985.0, "Asus", "Intel core i5", 15, "Full HD", 1000, 8, true));
       listaNotebooks.add(new Notebook(65000.0, "HP", "Intel core i7", 15, "Full HD", 256, 8, false));
       listaNotebooks.add(new Notebook(80000.0, "MacBook Air", "Intel core i5", 13, "Full HD", 128, 8, false));
       
       //Smartphones
       ArrayList<Smartphone> listaSmartphones = new ArrayList<Smartphone>();
       
       listaSmartphones.add(new Smartphone("Moto", 10000.0, 5.7, 13.0, 16, 2, "Android"));
       listaSmartphones.add(new Smartphone("LG", 14000.0, 5.3, 13.0, 32, 3, "Android"));
       listaSmartphones.add(new Smartphone("Samsung", 15280.0, 6.0, 16.0, 32, 3, "Android"));
       listaSmartphones.add(new Smartphone("Samsung", 55000.0, 6.0, 16.0, 128, 8, "Android"));
       listaSmartphones.add(new Smartphone("Iphone", 45000.0, 5.5, 12.0, 32, 3, "Ios"));
       listaSmartphones.add(new Smartphone("Iphone", 58500.0, 5.8, 12.0, 64, 4, "Ios"));
       
       //Tablets
        ArrayList<Tablet> listaTablets = new ArrayList<Tablet>();
        
        listaTablets.add(new Tablet("Samsung", 11000.0, 9.6, 1.5, 8.0, 5.0));
        listaTablets.add(new Tablet("Huawei", 6000.0, 7.0, 1.0, 16.0, 2.0));
        listaTablets.add(new Tablet("Nexus", 15500.0, 8.9, 2.0, 32.0, 8.0));
        listaTablets.add(new Tablet("Apple", 34000.0, 10.5, 3.0, 64.0, 8.0));
        
        //TVs
        ArrayList<Tv> listaTvs = new ArrayList<Tv>();
        
        listaTvs.add(new Tv("Noblex", 19500.0, 50, "Smart", "Full HD"));
        listaTvs.add(new Tv("BGH", 26000.0, 50, "Smart", "4K"));
        listaTvs.add(new Tv("LG", 12000.0, 32, "Smart", "Full HD"));
        listaTvs.add(new Tv("Sony", 57494.0, 60, "Smart", "4K"));
        listaTvs.add(new Tv("Samsung", 30000.0, 55, "Smart", "Full HD"));
 
    }
}
