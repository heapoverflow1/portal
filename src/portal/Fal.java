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
	
	BufferedImage img = null;
	ImageIcon icon = new ImageIcon(); 
	JLabel kezdo_label = new JLabel();
	
	/* Konstruktor
	 * A FAL inicializalasa x, y koordinatakkal
	 */
	public Fal(int x, int y) {
		position = new Pont(x,y);
		try {
		    img = ImageIO.read(new File("bin/fal.jpg"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		Image scaleImage = icon.getImage().getScaledInstance(63, 63,Image.SCALE_DEFAULT);
		icon.setImage(scaleImage);
		kezdo_label.setIcon(icon);
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
