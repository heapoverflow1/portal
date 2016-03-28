package portal;


//!TODO
// Ez nem kell leszármazzon az Ososztalybol?  -WM
public class Csillagkapu {
	SpecFal blue;
	SpecFal yellow;
	//!TODO
	// mikor lesz false-ra allitva?
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
		System.out.println(">Csillagkapu::setBlue");
		blue = s;
		if(yellow != null){
			this.makeFeregjarat();
		}
		System.out.println("<Csillagkapu::setBlue");
	}
	
	// Beallitja a sarga privat SpecFal erteket a kapottra
	void setYellow(SpecFal s){
		System.out.println(">Csillagkapu::setYellow");
		yellow = s;
		if(blue != null){
			this.makeFeregjarat();
		}
		System.out.println("<Csillagkapu::setYellow");
	}
	
	//Keletkezik egy feregjarat, azaz a feregjarat erteket igazra allitjuk
	void makeFeregjarat(){
		System.out.println(">Csillagkapu::makeFeregjarat");
		feregjarat = true;
		System.out.println("<Csillagkapu::makeFeregjarat");
	}
	
	// ez visszaadhatna true/false erteket es akkor azt nezzük, hogy mit adott vissza
	void entered(){
		
	}
}
