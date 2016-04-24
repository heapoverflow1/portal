package portal;

public class Fal extends Ososztaly{
	
	/* Konstruktor
	 * A FAL inicializalasa x, y koordinatakkal
	 */
	public Fal(int x, int y) {
		position = new Pont(x,y);
	}
	
	/* !TODO
	 * Valahogy meg kene csinalni, hogy ne legyen hasznalhato a SPECFAL*ban
	 * Lehet annyi is eleg, hogy overrideoljuk es semmit nem csinalunk benne :D
	 * bar ez nem szep
	 * -WM
	 */
	void blockTolteny(Tolteny t){
		System.out.println(">Fal::blockTolteny(Tolteny)");
		
		t.destroy();
		
		System.out.println("<Fal::blockTolteny(Tolteny)");
	}
	
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi){
		
		System.out.println(">Fal::ertesit(Pont)");
		System.out.println("<Fal::ertesit(Pont)");
		return regi;
	}

	@Override
	public Pont ertesit(Pont innenlep, Szereplo sz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		// TODO Auto-generated method stub
		
	}
}
