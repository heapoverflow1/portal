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
	
	public Pont ertesit(Pont regi){
		
		System.out.println(">Tolteny::ertesit");
		System.out.println("<Tolteny::ertesit");
		return position;
	}
	
	
	//!TODO
	void shoot(){}
	
	//!TODO
	void destroy(){}

}
