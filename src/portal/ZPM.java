package portal;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ZPM extends Ososztaly implements Drawable{
	
	BufferedImage img = null;
	ImageIcon icon = new ImageIcon(); 
	JLabel kezdo_label = new JLabel();
	
	/* Konstruktor
	 * A ZPM inicializalasa x, y koordinatakkal
	 */
	public ZPM(int x, int y) {
		position = new Pont(x,y);
		
		try {
		    img = ImageIO.read(new File("bin/zpm.gif"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		kezdo_label.setIcon(icon);
	}
	
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi, Szereplo sz){
				
		//Mostantol a ZPM fel van veve
		/*!TODO - fel is kene venni tenylegesen	
		 * ezredes.collectZPM()
		 */
		if (sz instanceof Jatekos){
			((Jatekos) sz).collectZPM();
		}
		Jatek.palya.removeQueue.add(this);
		//meg k�ne semmis�teni mag�t, illetve n�velni a ZMPCOUNT-ot. Probl�ma :
			// a replil�tor is egy szereplo, ergo � is fel tudja venni a ZPM-et ilyen m�don,
		// meg k�ne oldani hogy ne tudja ezt megtenni.
		
		return position;
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		//  sim�n tov�bb engedi nem csin�l vele semmit
		
	}
	
	public void draw(Graphics g){
		//TODO!!!
	}
}
