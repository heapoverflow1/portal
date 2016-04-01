package portal;

public class Szakadek extends Ososztaly {
	
	/* Konstruktor
	 * A SZAKADEK inicializalasa x, y koordinatakkal
	 */
	public Szakadek(int x, int y) {		
		this.position = new Pont(x,y);		
	}
	
	//Doboz megsemmisitése, ha beleesett
	void destroy(Doboz d) throws Throwable{
		
		System.out.println(">Szakadek::destroy(Doboz)");
		d.destroy();
		System.out.println("<Szakadek::destroy(Doboz)");
	}
	
	//Ezredes megsemmisitése, ha beleesett
	void kill(Ezredes e) throws Throwable{
		
		System.out.println(">Szakadek::kill(Ezredes)");
		e.fallAndDie();
		System.out.println("<Szakadek::kill(Ezredes)");
	}
	
	
	
	public Pont ertesit(Pont regi){
		return null;
	}
}
