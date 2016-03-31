package portal;


public class Ajto extends Fal{
	boolean isOpen;
	
	/* Konstruktor
	 * Az AJTO inicializalasa x, y koordinatakkal
	 * Meghivja az os (FAL) konstruktorat
	 */
	public Ajto(int x, int y){
		
		super(x,y);		
		isOpen = false;		
	}
	
	//Ajtonyitas
	void open(){
		
		System.out.println(">Ajto::open()");
		isOpen = true;
		System.out.println("<Ajto::open()");
	}
	
	//Ajtocsukas
	void close(){
		
		System.out.println(">Ajto::close()");
		isOpen = false;
		System.out.println("<Ajto::close()");
	}

}
