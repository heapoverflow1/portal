package portal;

import portal.Ezredes.Irany;

public class Tolteny extends Ososztaly{
	boolean type_kek;
	
	/* Konstruktor
	 * A TOLTENY inicializalasa blueType-ra
	 * !TODO 
	 * ez kell? x, y koordinatakkal -WM
	 * Beletettem, így van kezdopozicioja -WM
	 */
	public Tolteny(boolean blueType, Pont pos) {
		
		type_kek = blueType;
		position = pos;
	}
	
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi){
		
		System.out.println(">Tolteny::ertesit(Pont)");
		System.out.println("<Tolteny::ertesit(Pont)");
		return position;
	}
	
	
	//!TODO
	void shoot(Irany irany){
		System.out.println(">Tolteny::shoot()");
		
		//!TODO
		
		System.out.println("<Tolteny::shoot()");
	}
	
	//!TODO
	void destroy(){
		System.out.println(">Tolteny::destroy()");
		
		//!TODO
		
		System.out.println("<Tolteny::destroy()");
		
	}

}
