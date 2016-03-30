package portal;


import java.util.List;

public abstract class Ososztaly {
	
	//ArrayList<Integer> position; Helyett sajat osztalyt, a Pontot hasznaljuk.
	public Pont position;
	
	
	//Konstruktor
	/**Szerintem ide nem kell konstruktor  -WM*/
//	public Ososztaly() {
//		System.out.println(">Ososztaly::konstruktor");		
//		position = new Pont();
//		System.out.println("<Ososztaly::konstruktor");
//	}
	
	//
	void Add(List<Ososztaly> ososzt){
		
		System.out.println(">Ososztaly::Add");
		ososzt.add(this);
		System.out.println("<Ososztaly::Add");
	}
	
	public abstract Pont ertesit(Pont innenlep);
	

}
