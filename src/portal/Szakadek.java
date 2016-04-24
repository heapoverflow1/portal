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
	void kill(Jatekos e) throws Throwable{
		
		System.out.println(">Szakadek::kill(Ezredes)");
		e.fallAndDie();
		System.out.println("<Szakadek::kill(Ezredes)");
	}
	
	
	//!TODO - leírás + lentebbi !TODO
	public Pont ertesit(Pont regi, Szereplo sz){
		
		System.out.println(">Szakadek::ertesit(Pont)");
		
		//TODO!!!
		//NINCS KEZELVE AZ EZREDES KINYÍRÁS!
		//this.kill(Ezredes);
		
		System.out.println("<Szakadek::ertesit(Pont)");
		return position;
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		// TODO Auto-generated method stub
		
	}
}
