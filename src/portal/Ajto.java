package portal;

public class Ajto extends Fal{
	boolean isOpen;
	
	//Konstruktor
	public Ajto(){
		isOpen = false;
	}
	
	//Ajtónyitás
	void open(){
		isOpen = true;
	}
	
	//Ajtócsukás
	void close(){
		isOpen = false;
	}

}
