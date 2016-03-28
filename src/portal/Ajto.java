package portal;

public class Ajto extends Fal{
	boolean isOpen;
	
	/* Konstruktor
	 * Az AJTO inicializálása x, y koordinátákkal
	 */
	public Ajto(int x, int y){
		System.out.println(">Ajto::konstruktor");
		
		isOpen = false;		
		position = new Pont(x,y);
		
		System.out.println("<Ajto::konstruktor");
	}
	
	//Ajtónyitás
	void open(){
		System.out.println(">Ajto::open");
		isOpen = true;
		System.out.println("<Ajto::open");
	}
	
	//Ajtócsukás
	void close(){
		System.out.println(">Ajto::close");
		isOpen = false;
		System.out.println("<Ajto::close");
	}

}
