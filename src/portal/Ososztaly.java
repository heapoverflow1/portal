package portal;


import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Ososztaly implements Ertesit, Drawable{
	//ArrayList<Integer> position; Helyett sajat osztalyt, a Pontot hasznaljuk.
	public Pont position;

	//Konstruktor
	/**Szerintem ide nem kell konstruktor  -WM*/	
	
	//Méretezett kép betöltése - a leszármazott oszátlyok használják
	protected void LoadImage(JLabel label, String path){
		BufferedImage img = null;
		ImageIcon icon = new ImageIcon(); 
		try {
		    img = ImageIO.read(new File(path));
		    //Kep betoltese
		} catch (IOException e) {
			return;
		}		
		icon.setImage(img);
		//A kep atmeretezese. Most 63*63 a szabvany. Ha valtozik, csak itt kell atirni.
		Image scaleImage = icon.getImage().getScaledInstance(63, 63,Image.SCALE_DEFAULT);
		icon.setImage(scaleImage);
		//Hozzaadjuk a JLabelhez
		label.setIcon(icon);
	}
	
	void Add(List<Ososztaly> ososzt){
		ososzt.add(this);
	}
	
	//Itt is jelezzük, hogy szükséges a Drawable interfesz megvalositasa:
	public abstract void draw(Container content, GridBagConstraints c);

}
