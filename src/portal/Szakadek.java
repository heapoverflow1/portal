package portal;

public class Szakadek extends Ososztaly {
	
	//Konstruktor
	public Szakadek(int x, int y) {
		System.out.println(">Szakadek::konstruktor");
		this.position = new Pont(x,y);		
		System.out.println("<Szakadek::konstruktor");
	}
	
	//Doboz megsemmisítése, ha beleesett
	void destroy(Doboz d) throws Throwable{
		System.out.println(">Szakadek::destroy");
		d.destroy();
		System.out.println("<Szakadek::destroy");
	}
	
	//Ezredes megsemmisítése, ha beleesett
	void kill(Ezredes e) throws Throwable{
		System.out.println(">Szakadek::kill");
		e.fallAndDie();
		System.out.println("<Szakadek::kill");
	}
}
