package portal;

public class ZPM extends Ososztaly{
	
	/* Konstruktor
	 * A ZPM inicializalasa x, y koordinatakkal
	 */
	public ZPM(int x, int y) {
		position = new Pont(x,y);
	}
	
	public Pont ertesit(Pont regi){
		
		System.out.println(">ZPM::ertesit");
		//Mostant�l a ZPM fel van v�ve
		System.out.println("<ZPM::ertesit");
		return position;
	}
}
