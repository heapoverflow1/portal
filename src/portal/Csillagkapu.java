package portal;


public class Csillagkapu implements Ertesit{
	SpecFal blue;
	SpecFal yellow;
	
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
		//Ha van s�rga l�trehozva, f�regj�rat l�trehoz�sa.
		//K�l�n h�v�st nem ig�nyel.
		System.out.println("<Csillagkapu::setBlue(SpecFal)");
	}
	
	// Beallitja a sarga privat SpecFal erteket a kapottra
	void setYellow(SpecFal s){
		System.out.println(">Csillagkapu::setYellow(SpecFal)");
		//Ha van k�k l�trehozva, f�regj�rat l�trehoz�sa.
		//K�l�n h�v�st nem ig�nyel.
		System.out.println("<Csillagkapu::setYellow(SpecFal)");
	}
	
	//Keletkezik egy feregjarat, azaz a feregjarat erteket igazra allitjuk
	void makeFeregjarat(){
		//Bels� m�k�d�shez kell, a szkeletonban szerepe nincs.
	}
	
	// ez visszaadhatna true/false erteket es akkor azt nezz�k, hogy mit adott vissza
	void entered(){		
		System.out.println(">Csillagkapu::entered()");		
		System.out.println("<Csillagkapu::entered()");		
	}
	
	/* Ha az EZREDES a sarga kapuba lep bele, akkor a kek kapuban jelenik meg,
	 * ha a kek kapuba lep, akkor a sarga kapuban jelenik meg
	 * Azaz az adott Pontot adjuk vissza neki. 
	 */
	public Pont ertesit(Pont innenlep) {		
		System.out.println(">Csillagkapu::ertesit(Pont)");
		//A bels� m�k�d�s r�sze, hogy milyen Pontot adunk vissza, k�l�n k�rd�st nem ig�nyel.
		System.out.println("<Csillagkapu::ertesit(Pont)");
		return null;
	}
}
