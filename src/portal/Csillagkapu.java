package portal;


public class Csillagkapu implements Ertesit{
	SpecFal blue;
	SpecFal yellow;
	
	//!TODO - mikor lesz false-ra allitva?
	boolean feregjarat;
	
	
	/* Konstruktor
	 * beallitja a feregjaratot false-ra. Alapertelmezes.
	 */
	public Csillagkapu(int x, int y) {
		
		feregjarat = false;
		blue = null;
		yellow = null;
	}
	
	// Beallitja a kek privat SpecFal erteket a kapottra
	void setBlue(SpecFal s){
		
		System.out.println(">Csillagkapu::setBlue(SpecFal)");
		
		blue = s;
		if(yellow != null){
			this.makeFeregjarat();
		}
		
		System.out.println("<Csillagkapu::setBlue(SpecFal)");
	}
	
	// Beallitja a sarga privat SpecFal erteket a kapottra
	void setYellow(SpecFal s){
		
		System.out.println(">Csillagkapu::setYellow(SpecFal)");
		
		yellow = s;
		if(blue != null){
			this.makeFeregjarat();
		}
		
		System.out.println("<Csillagkapu::setYellow(SpecFal)");
	}
	
	//Keletkezik egy feregjarat, azaz a feregjarat erteket igazra allitjuk
	void makeFeregjarat(){
		
		System.out.println(">Csillagkapu::makeFeregjarat()");
		feregjarat = true;
		System.out.println("<Csillagkapu::makeFeregjarat()");
	}
	
	//!TODO
	// ez visszaadhatna true/false erteket es akkor azt nezzük, hogy mit adott vissza
	void entered(){
		
		System.out.println(">Csillagkapu::entered()");
		
		//!TODO
		
		System.out.println(">Csillagkapu::entered()");
		
	}
	
	/* Ha az EZREDES a sarga kapuba lep bele, akkor a kek kapuban jelenik meg,
	 * ha a kek kapuba lep, akkor a sarga kapuban jelenik meg
	 * Azaz az adott Pontot adjuk vissza neki. 
	 */
	public Pont ertesit(Pont innenlep) {		
		System.out.println(">Csillagkapu::ertesit(Pont)");		
		
		if(yellow.position.compareTo(innenlep)){
			
			System.out.println("<Csillagkapu::ertesit(Pont)");
			return blue.position;
		}
		else if(blue.position.compareTo(innenlep)){
			
			System.out.println("<Csillagkapu::ertesit(Pont)");
			return yellow.position;
		}else{
			
			System.out.println("<Csillagkapu::ertesit(Pont)");
			return null;
		}

	}
}
