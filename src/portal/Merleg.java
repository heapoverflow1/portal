package portal;

public class Merleg extends Ososztaly{
	boolean isPressed;
	Ajto nyitando;
	
	/* Konstruktor
	 * A MERLEG inicializalasa x, y koordinatakkal
	 */
	public Merleg(int x, int y, Ajto nyitando) {
		
		isPressed = false;
		position = new Pont(x, y);
		this.nyitando = nyitando;
	}
	
	
	//!TODO
	//Azt vizsgalja, van-e sulya a merlegen
	void weighted(){
		if(true/*van e ugyanazon a koordinatan valami?*/){			
		//kene, hogy melyik ajtot nyissuk, melyik tartozik hozza
			
		isPressed = true;
		}
	}
}
