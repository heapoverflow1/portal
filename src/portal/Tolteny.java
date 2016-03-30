package portal;

public class Tolteny extends Ososztaly{
	boolean type_kek;
	
	/* Konstruktor
	 * A TOLTENY inicializalasa blueType-ra
	 * !TODO 
	 * ez kell? x, y koordinatakkal
	 */
	public Tolteny(boolean blueType) {
		type_kek = blueType;
	}
	
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi){
		
		System.out.println(">Tolteny::ertesit(Pont)");
		System.out.println("<Tolteny::ertesit(Pont)");
		return position;
	}
	
	
	//!TODO
	void shoot(){
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
