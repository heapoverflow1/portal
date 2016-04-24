package portal;

public class ZPM extends Ososztaly{
	
	/* Konstruktor
	 * A ZPM inicializalasa x, y koordinatakkal
	 */
	public ZPM(int x, int y) {
		position = new Pont(x,y);
	}
	
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi, Szereplo sz){
				
		//Mostantol a ZPM fel van veve
		/*!TODO - fel is kene venni tenylegesen	
		 * ezredes.collectZPM()
		 */
		 
		//meg kéne semmisíteni magát, illetve növelni a ZMPCOUNT-ot. Probléma :
			// a replilátor is egy szereplo, ergo õ is fel tudja venni a ZPM-et ilyen módon,
		// meg kéne oldani hogy ne tudja ezt megtenni.
		
		return position;
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		//  simán tovább engedi nem csinál vele semmit
		
	}
}
