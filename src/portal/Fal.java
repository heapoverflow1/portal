package portal;

public class Fal extends Ososztaly{
	
	/* Konstruktor
	 * A FAL inicializalasa x, y koordinatakkal
	 */
	public Fal(int x, int y) {
		position = new Pont(x,y);
	}
	
	
	void blockTolteny(Tolteny t){
		System.out.println(">Fal::blockTolteny(Tolteny)");
		
		t.destroy();
		
		System.out.println("<Fal::blockTolteny(Tolteny)");
	}
	
	public Pont ertesit(Pont regi){
		return null;
	}
}
