package portal;

public class Ajto extends Fal{
	boolean isOpen;
	
	/* Konstruktor
	 * Az AJTO inicializ�l�sa x, y koordin�t�kkal
	 */
	public Ajto(int x, int y){
		System.out.println(">Ajto::konstruktor");
		
		isOpen = false;		
		position = new Pont(x,y);
		
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
