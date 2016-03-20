package portal;

public class Csillagkapu {
	SpecFal blue;
	SpecFal yellow;
	// mikor lesz false-ra állítva?
	boolean feregjarat;
	
	
	/* Konstruktor
	 * beállítja a féregjáratot false-ra. Alapértelmezés.
	 */
	public Csillagkapu() {
		feregjarat = false;
	}
	
	// Beállítja a kék privát SpecFal értékét a kapottra
	void setBlue(SpecFal s){
		blue = s;
	}
	
	// Beállítja a sárga privát SpecFal értékét a kapottra
	void setYellow(SpecFal s){
		yellow = s;
	}
	
	//Keletkezik egy féregjárat, azaz a féregjárat értékét igazra állítjuk
	void makeFeregjarat(){
		feregjarat = true;
	}
	
	// ez visszaadhatna true/false értéket és akkor azt nézzük, hogy mit adott vissza
	void entered(){
		
	}
}
