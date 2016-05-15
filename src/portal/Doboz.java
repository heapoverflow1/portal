package portal;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Doboz extends Ososztaly implements Drawable{
	boolean isLifted = false;
	static int weight=1;
	
	BufferedImage img = null;
	ImageIcon icon = new ImageIcon(); 
	JLabel kezdo_label = new JLabel();
	
	/* Konstruktor
	 * A DOBOZ inicializalasa x, y koordinatakkal
	 */
	public Doboz(int x, int y) {		
		position = new Pont(x,y);
		
		try {
		    img = ImageIO.read(new File("bin/doboz.png"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		Image scaleImage = icon.getImage().getScaledInstance(63, 63,Image.SCALE_DEFAULT);
		icon.setImage(scaleImage);
		kezdo_label.setIcon(icon);
	}
	
	public Doboz(int x, int y, int w) {		
		position = new Pont(x,y);
		weight=w;
		
		try {
		    img = ImageIO.read(new File("bin/doboz.png"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		kezdo_label.setIcon(icon);
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
	
	public void draw(Graphics g){
		//TODO!!!
	}
}
