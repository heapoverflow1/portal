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
		 
		//meg k�ne semmis�teni mag�t, illetve n�velni a ZMPCOUNT-ot. Probl�ma :
			// a replil�tor is egy szereplo, ergo � is fel tudja venni a ZPM-et ilyen m�don,
		// meg k�ne oldani hogy ne tudja ezt megtenni.
		
		return position;
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		//  sim�n tov�bb engedi nem csin�l vele semmit
		
	}
}
