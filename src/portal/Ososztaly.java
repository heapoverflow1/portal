package portal;

import java.util.ArrayList;
import java.util.List;

public abstract class Ososztaly {
	ArrayList<Ososztaly> position;
	
	//Konstruktor
	public Ososztaly() {
		position = new ArrayList<Ososztaly>();
	}
	
	//
	void Add(List<Ososztaly> ososzt){}
	
	//Ide pedig szerintem kéne egy notify fv, hogy mindegyiknek legyen, és azt lehessen hívni

}
