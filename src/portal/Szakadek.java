package portal;

public class Szakadek extends Ososztaly {
	
	/* Konstruktor
	 * A SZAKADEK inicializalasa x, y koordinatakkal
	 */
	public Szakadek(int x, int y) {
		System.out.println(">Szakadek::konstruktor");
		this.position = new Pont(x,y);		
		System.out.println("<Szakadek::konstruktor");
	}
	
	//Doboz megsemmisitése, ha beleesett
	void destroy(Doboz d) throws Throwable{
		System.out.println(">Szakadek::destroy");
		d.destroy();
		System.out.println("<Szakadek::destroy");
	}
	
	//Ezredes megsemmisitése, ha beleesett
	void kill(Ezredes e) throws Throwable{
		System.out.println(">Szakadek::kill");
		e.fallAndDie();
		System.out.println("<Szakadek::kill");
	}
	
	public Pont ertesit(Pont regi){		
		System.out.println(">Szakadek::ertesit");
		//TODO!!!
		//NINCS KEZELVE AZ EZREDES KINYÍRÁS!
		//this.kill(Ezredes);
		System.out.println("<Szakadek::ertesit");
		return position;
	}
}
