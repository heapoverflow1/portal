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

	void destroy() throws Throwable{
		Jatek.palya.objects.remove(this);
		this.finalize();
	}

	//Az ertesit interfesz megvalositasa miatt szukseges, hogy fel lehessen venni a jatekter objektumai koze. A doboz sajat poziciojaval ter vissza.
	//Egy kesobbi bovites alkalmaval kaphat a metodus nagyobb szerepet, ha pl. be szeretnenk allitani, hogy legyenek olyan dobozok, amikkel nem lehet egy mezore lepni.

	@Override
	public Pont ertesit(Pont innenlep, Szereplo sz) {
		// TODO Auto-generated method stub
		return position;
	}

	public void ertesit_shoot(Tolteny t) {
		//A doboz nem akadályozza meg a töltény útját	
	}
}
