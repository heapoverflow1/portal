package portal;

public class Csillagkapu {
	SpecFal blue;
	SpecFal yellow;
	// mikor lesz false-ra �ll�tva?
	boolean feregjarat;
	
	
	/* Konstruktor
	 * be�ll�tja a f�regj�ratot false-ra. Alap�rtelmez�s.
	 */
	public Csillagkapu() {
		feregjarat = false;
	}
	
	// Be�ll�tja a k�k priv�t SpecFal �rt�k�t a kapottra
	void setBlue(SpecFal s){
		blue = s;
	}
	
	// Be�ll�tja a s�rga priv�t SpecFal �rt�k�t a kapottra
	void setYellow(SpecFal s){
		yellow = s;
	}
	
	//Keletkezik egy f�regj�rat, azaz a f�regj�rat �rt�k�t igazra �ll�tjuk
	void makeFeregjarat(){
		feregjarat = true;
	}
	
	// ez visszaadhatna true/false �rt�ket �s akkor azt n�zz�k, hogy mit adott vissza
	void entered(){
		
	}
}
