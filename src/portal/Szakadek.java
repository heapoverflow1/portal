package portal;

public class Szakadek extends Ososztaly {
	
	//Konstruktor
	public Szakadek() {}
	
	//Doboz megsemmisítése, ha beleesett
	void destroy(Doboz d) throws Throwable{
		d.destroy();
	}
	
	//Ezredes megsemmisítése, ha beleesett
	void kill(Ezredes e){
		e.fallAndDie();
	}
}
