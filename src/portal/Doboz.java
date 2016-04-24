package portal;

public class Doboz extends Ososztaly{
	boolean isLifted = false;
	static int weight=1;
	
	/* Konstruktor
	 * A DOBOZ inicializalasa x, y koordinatakkal
	 */
	public Doboz(int x, int y) {		
		position = new Pont(x,y);		
	}
	
	//Doboz felemelese
	public void Lift(){
		isLifted = true;
	}
	
	//Doboz letevese
	public void Drop(){
		isLifted = false;
	}
	
	//Doboz helyenek allitasa
	public void setPosition(Pont uj){
		if (isLifted)
			position = uj;
	}

	//Az ertesit interfesz megvalositasa miatt szukseges, hogy fel lehessen venni a jatekter objektumai koze. A doboz sajat poziciojaval ter vissza.
	//Egy kesobbi bovites alkalmaval kaphat a metodus nagyobb szerepet, ha pl. be szeretnenk allitani, hogy legyenek olyan dobozok, amikkel nem lehet egy mezore lepni.

	public Pont ertesit(Pont regi, Szereplo sz){
		return position;
	}
	
	//Doboz megszunik
	void destroy() throws Throwable{		
		this.finalize();
	}

	public void ertesit_shoot(Tolteny t) {
		//A doboz nem akadályozza meg a töltény útját	
	}
}
