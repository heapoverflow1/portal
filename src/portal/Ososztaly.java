package portal;


import java.util.ArrayList;
import java.util.List;

public abstract class Ososztaly {
	
	//ArrayList<Integer> position; Helyett saját osztályt, a Pontot használjuk.
	public Pont position;
	
	//Konstruktor
	public Ososztaly() {
		System.out.println(">Ososztaly::konstruktor");		
		position = new Pont();
		System.out.println("<Ososztaly::konstruktor");
	}
	
	//
	void Add(List<Ososztaly> ososzt)
	{
		System.out.println(">Ososztaly::Add");
		ososzt.add(this);
		System.out.println("<Ososztaly::Add");
	}
	
	
	
	
	//Ide pedig szerintem kéne egy notify fv, hogy mindegyiknek legyen, és azt lehessen hívni

}
