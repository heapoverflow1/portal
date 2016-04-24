package portal;

//!TODO LIST
//toltenykezeles: nyitva atengedi, zarva blokkolja

public class Ajto extends Fal implements Ertesit{
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
		isOpen = true;
	}
	
	//Ajtocsukas
	void close(){
		isOpen = false;
	}
	
	//fal ertesitjenek felulirasa, ha nyitva, ezredes tud arra lepni, egyebkent falkent viselkedik - TG
	public Pont ertesit(Pont regi, Szereplo sz){		
		if(isOpen){
			return position;			
		}
		else{
			return regi;
		}
	}
	public void ertesit_shoot(Tolteny t){
		t.destroy();
	}
}
