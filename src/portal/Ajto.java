package portal;

public class Ajto extends Fal{
	boolean isOpen;
	
	//Konstruktor
	public Ajto(){
		isOpen = false;
	}
	
	//Ajt�nyit�s
	void open(){
		isOpen = true;
	}
	
	//Ajt�csuk�s
	void close(){
		isOpen = false;
	}

}
