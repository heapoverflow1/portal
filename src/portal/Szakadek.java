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

public class Szakadek extends Ososztaly implements Drawable {

	BufferedImage img = null;
	ImageIcon icon = new ImageIcon(); 
	JLabel kezdo_label = new JLabel();
	
	/*
	 * Konstruktor A SZAKADEK inicializalasa x, y koordinatakkal
	 */
	public Szakadek(int x, int y) {
		this.position = new Pont(x, y);
		try {
		    img = ImageIO.read(new File("bin/szakadek.png"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		Image scaleImage = icon.getImage().getScaledInstance(63, 63,Image.SCALE_DEFAULT);
		icon.setImage(scaleImage);
		kezdo_label.setIcon(icon);
		
	}

	// Doboz megsemmisit�se, ha beleesett
	void destroy(Doboz d) throws Throwable {
		Jatek.palya.removeQueue.add(d);
		d.destroy();
	}

	// Ezredes megsemmisit�se, ha beleesett
	void kill(Szereplo e) throws Throwable {
		Jatek.palya.removeQueue.add(e);//Jatek.palya.remove(e);
		if (e.getClass() == Replikator.class) {
			e.fallAndDie();
			//Jatek.palya.remove(this);
			Jatek.palya.removeQueue.add(this);
			this.finalize();
			//Replikator eseten megsemmisulunk
		} else {
			e.fallAndDie();
		}
	}

	//Ha rank kiserlne meg lepni egy szereplo, eltavolitjuk a jatekbol
	public Pont ertesit(Pont regi, Szereplo sz) {
		try {
			kill(sz);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return position;
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		//A toltenyt nem semmisitjuk meg
	}
	
	public void draw(Container content, GridBagConstraints c){
		content.add(kezdo_label, c);
	}
}
