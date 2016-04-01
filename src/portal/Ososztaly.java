package portal;


import java.util.List;

public abstract class Ososztaly implements Ertesit{
	public Pont position;
	
	void Add(List<Ososztaly> ososzt){
		
		System.out.println(">Ososztaly::Add(List<Ososztaly>)");
		ososzt.add(this);
		System.out.println("<Ososztaly::Add(List<Ososztaly>)");
	}

}
