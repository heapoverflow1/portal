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
		t.destroy();
	}
	
	public Pont ertesit(Pont regi){
		System.out.println(">Pont::ertesit");
		System.out.println("<Pont::ertesit");
		return regi;
	}
}
