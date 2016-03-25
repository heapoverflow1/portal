package portal;

public class Szakadek extends Ososztaly {
	
	//Konstruktor
	public Szakadek() {}
	
	//Doboz megsemmis�t�se, ha beleesett
	void destroy(Doboz d) throws Throwable{
		d.destroy();
	}
	
	//Ezredes megsemmis�t�se, ha beleesett
	void kill(Ezredes e){
		e.fallAndDie();
	}
}
