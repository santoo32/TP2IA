package chatbot;

import static java.time.Clock.system;
import tp2iav1.pkg0.interfazPrincipal;

public class ChatbotMain {
    
    public static AgenteBasadoEnConocimiento a;
    
	public static void main(String[] args)  {

		a = new AgenteBasadoEnConocimiento();
		
        //LLAMAR A LA INTERFAZ
       interfazPrincipal ventana = new interfazPrincipal(a);
       ventana.setLocationRelativeTo(null);
       ventana.setVisible(true);
                
                //prueba
               /* ventana.setBotText("hola");
                ventana.setBotText("que tal");
                ventana.setBotText("que tal");*/
                
	}
}
