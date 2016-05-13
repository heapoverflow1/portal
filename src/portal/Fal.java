package portal;

import java.awt.Graphics;

public class Fal extends Ososztaly implements Drawable{
	
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

	

	@Override
	public Pont ertesit(Pont innenlep, Szereplo sz) {
		return innenlep;
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		
		t.alive=false;
		
	}
	
	public void draw(Graphics g){
		//TODO!!!
	}
}
