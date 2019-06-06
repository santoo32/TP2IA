package chatbot;

public class ChatbotMain {
	public static void main(String[] args)  {
		//LLAMAR A LA INTERFAZ
		AgenteBasadoEnConocimiento a = new AgenteBasadoEnConocimiento();
		a.start("Hola");
	}
}
