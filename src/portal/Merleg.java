package portal;

public class Merleg extends Ososztaly{
	boolean isPressed;
	Ajto nyitando;
	
	//Konstruktor
	public Merleg(Ajto nyitando) {
		isPressed=false;
		this.nyitando = nyitando;
	}
	
	//Azt vizsg�lja, van-e s�lya a m�rlegen
	void weighted(){
		if(true/*van e ugyanazon a koordin�t�n valami?*/){			
		//k�ne, hogy melyik ajt�t nyissuk, melyik tartozik hozz�
			
		isPressed = true;
		}
	}
}
