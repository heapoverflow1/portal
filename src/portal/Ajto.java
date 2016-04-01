package portal;

//!TODO LIST
//toltenykezeles: nyitva atengedi, zarva blokkolja

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
	
	//fal ertesitjenek felulirasa, ha nyitva, ezredes tud arra lepni, egyebkent falkent viselkedik - TG
	public Pont ertesit(Pont regi){		
		System.out.println(">Ajto::ertesit(Pont)");
		//Ajt� �llapota nem sz�ks�ges, mintk�t esetben ugyan�gy t�r vissza
		System.out.println("<Ajto::ertesit(Pont)");
		return regi;
	}

}
