package portal;

public abstract class Szereplo extends Ososztaly {
	Irany irany;	
	
	/* Konstruktor
	 * A SZEREPLO a jatek elejen jobbra all
	 * A SZEREPLO inicializalasa x, y koordinatakkal
	 */
	public Szereplo(int x, int y){
		position = new Pont(x, y);
		irany = Irany.JOBBRA;
	}
	
	/* JATEKOS mozgatasa irany iranyba
	 * irany valtozoja beallitasa
	 * Megprobal lepni a JATEKOS egyet az adott iranyba,
	 * majd megkeri a JATEKTER-et, hogy hivja meg az adott
	 * pozicion levo dolognak az ERTESIT fuggvenyet, ami visszater egy
	 * adott pozicioval a targytol fuggoen ( ha FAL, akkor a regi pozicio, azaz nem leptunk,
	 * ha MERLEG, akkor az uj pozicio, tehat leptunk)
	 */
	public void move (Irany i){	
		this.irany = i;
		Pont ujhely = new Pont(position);
		ujhely.move(irany);
		position = Jatek.palya.checkfield(position, ujhely);
	}
	
	/*  SZEREPLO leesik, ezaltal meghal, vege a jateknak 
	 */
	
	public void fallAndDie(){
		
		try {
			this.finalize();
			
		} catch (Throwable e) {			
			e.printStackTrace();
		}		
		
	}

	/*  Egymasra ralephetnek a SZEREPLOk, ezert az ertesit fuggveny
	 *  visszaadja az adott jatekos poziciojat 
	 */
	public Pont ertesit(Pont innenlep, Szereplo sz) {
		
		return position;
	}

	/*  Atmehet a SZEREPLOn a TOLTENY ezert nem csinalunk semmit a TOLTENNYEL
	 *  Feluldefinialva a REPLIKATORban
	 */
	public void ertesit_shoot(Tolteny t) {		
		
	}
	

}
