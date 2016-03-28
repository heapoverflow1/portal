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
		System.out.println(">Csillagkapu::setBlue");
		blue = s;
		System.out.println("<Csillagkapu::setBlue");
	}
	
	// Beállítja a sárga privát SpecFal értékét a kapottra
	void setYellow(SpecFal s){
		System.out.println(">Csillagkapu::setYellow");
		yellow = s;
		System.out.println("<Csillagkapu::setYellow");
	}
	
	//Keletkezik egy féregjárat, azaz a féregjárat értékét igazra állítjuk
	void makeFeregjarat(){
		System.out.println(">Csillagkapu::makeFeregjarat");
		feregjarat = true;
		System.out.println("<Csillagkapu::makeFeregjarat");
	}
	
	// ez visszaadhatna true/false értéket és akkor azt nézzük, hogy mit adott vissza
	void entered(){
		
	}
}
