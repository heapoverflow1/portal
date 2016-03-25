package portal;


import java.util.List;

public abstract class Ososztaly {
	
	//ArrayList<Integer> position;
	//a 0. helyen az X az 1. helyen az Y koordináta van.
	public int position[];
	
	//Konstruktor
	public Ososztaly() {
		System.out.println(">Ososztaly konstruktor");		
		position = new int[2];
		System.out.println("<Ososztaly konstruktor");
	}
	
	//
	void Add(List<Ososztaly> ososzt)
	{
		System.out.println(">Ososztaly Add");
		ososzt.add(this);
		System.out.println("<Ososztaly Add");
	}
	
	
	
	

}
