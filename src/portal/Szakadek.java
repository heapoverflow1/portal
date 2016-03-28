package portal;

public class Szakadek extends Ososztaly {
	
	//Konstruktor
	public Szakadek(int x, int y) {
		this.position.add(new Pont(x,y));
	}
	
	//Doboz megsemmis�t�se, ha beleesett
	void destroy(Doboz d) throws Throwable{
		System.out.println(">Szakadek::destroy");
		d.destroy();
		System.out.println("<Szakadek::destroy");
	}
	
	//Ezredes megsemmis�t�se, ha beleesett
	void kill(Ezredes e) throws Throwable{
		System.out.println(">Szakadek::kill");
		e.fallAndDie();
		System.out.println("<Szakadek::kill");
	}
}
