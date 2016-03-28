package portal;

public class Merleg extends Ososztaly{
	boolean isPressed;
	Ajto nyitando;
	
	//Konstruktor
	public Merleg(Ajto nyitando) {
		isPressed=false;
		this.nyitando = nyitando;
	}
	
	//Azt vizsgálja, van-e súlya a mérlegen
	void weighted(){
		if(true/*van e ugyanazon a koordinátán valami?*/){			
		//kéne, hogy melyik ajtót nyissuk, melyik tartozik hozzá
			
		isPressed = true;
		}
	}
}
