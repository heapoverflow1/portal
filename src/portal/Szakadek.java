package portal;

public class Szakadek extends Ososztaly {
	
	/* Konstruktor
	 * A SZAKADEK inicializalasa x, y koordinatakkal
	 */
	public Szakadek(int x, int y) {		
		this.position = new Pont(x,y);		
	}
	
	//Doboz megsemmisit�se, ha beleesett
	void destroy(Doboz d) throws Throwable{
		
		System.out.println(">Szakadek::destroy(Doboz)");
		d.destroy();
		System.out.println("<Szakadek::destroy(Doboz)");
	}
	
	//Ezredes megsemmisit�se, ha beleesett
	void kill(Ezredes e) throws Throwable{
		
		System.out.println(">Szakadek::kill(Ezredes)");
		e.fallAndDie();
		System.out.println("<Szakadek::kill(Ezredes)");
	}
	
	
	//!TODO - le�r�s + lentebbi !TODO
	public Pont ertesit(Pont regi){
		
		System.out.println(">Szakadek::ertesit(Pont)");
		
		//TODO!!!
		//NINCS KEZELVE AZ EZREDES KINY�R�S!
		//this.kill(Ezredes);
		
		System.out.println("<Szakadek::ertesit(Pont)");
		return position;
	}
}
