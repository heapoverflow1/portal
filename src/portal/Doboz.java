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
<<<<<<< HEAD
		isLifted = true;
=======
		
		
		isLifted = true;
		
>>>>>>> refs/remotes/origin/master
	}
	
	//Doboz letevese
	public void Drop(){
<<<<<<< HEAD
		isLifted = false;
=======
		
		
		isLifted = false;
		
>>>>>>> refs/remotes/origin/master
	}
	
	//Doboz helyenek allitasa
	public void setPosition(Pont uj){
<<<<<<< HEAD
		if (isLifted)
			position = uj;
	}

	//Az ertesit interfesz megvalositasa miatt szukseges, hogy fel lehessen venni a jatekter objektumai koze. A doboz sajat poziciojaval ter vissza.
	//Egy kesobbi bovites alkalmaval kaphat a metodus nagyobb szerepet, ha pl. be szeretnenk allitani, hogy legyenek olyan dobozok, amikkel nem lehet egy mezore lepni.

	public Pont ertesit(Pont regi, Szereplo sz){
		return position;
=======
		
		
		if (isLifted)
			position = uj;
		
>>>>>>> refs/remotes/origin/master
	}
	

	
	//Doboz megszunik
<<<<<<< HEAD
	void destroy() throws Throwable{		
		this.finalize();
=======
	void destroy() throws Throwable{
		
		
		this.finalize();
		
	}

	@Override
	public Pont ertesit(Pont innenlep, Szereplo sz) {
		// TODO Auto-generated method stub
		return position;
>>>>>>> refs/remotes/origin/master
	}

	public void ertesit_shoot(Tolteny t) {
		//A doboz nem akadályozza meg a töltény útját	
	}
}
