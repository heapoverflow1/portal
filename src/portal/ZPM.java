package portal;

public class ZPM extends Ososztaly{
	
	/* Konstruktor
	 * A ZPM inicializalasa x, y koordinatakkal
	 */
	public ZPM(int x, int y) {
		position = new Pont(x,y);
	}
	
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi){
		
		System.out.println(">ZPM::ertesit(Pont)");
		
		//Mostantol a ZPM fel van veve
		/*!TODO - fel is kene venni tenylegesen	
		 * ezredes.collectZPM()
		 */
		
		System.out.println("<ZPM::ertesit(Pont)");
		return position;
	}
}
