package portal;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Fal extends Ososztaly implements Drawable{ 
	private JLabel kezdo_label=new JLabel();
	
	/* Konstruktor
	 * A FAL inicializalasa x, y koordinatakkal
	 */
	public Fal(int x, int y) {
		position = new Pont(x,y);
		LoadImage(kezdo_label, "bin/fal.jpg");
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
	
	public void draw(Container content, GridBagConstraints c){
		content.add(kezdo_label, c);
	}
}
