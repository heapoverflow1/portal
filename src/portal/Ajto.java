package portal;

public class Ajto extends Fal{
	boolean isOpen;
	
	//Konstruktor
	public Ajto(){
		System.out.println(">Ajto::konstruktor");
		isOpen = false;
		System.out.println("<Ajto::konstruktor");
	}
	
	//Ajt�nyit�s
	void open(){
		System.out.println(">Ajto::open");
		isOpen = true;
		System.out.println("<Ajto::open");
	}
	
	//Ajt�csuk�s
	void close(){
		System.out.println(">Ajto::close");
		isOpen = false;
		System.out.println("<Ajto::close");
	}

}
