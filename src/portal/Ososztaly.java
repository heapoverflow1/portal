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
//	public Ososztaly() {
//		System.out.println(">Ososztaly::konstruktor");		
//		position = new Pont();
//		System.out.println("<Ososztaly::konstruktor");
//	}
	
	//
	protected void LoadImage(JLabel label, String path){
		BufferedImage img = null;
		ImageIcon icon = new ImageIcon(); 
		try {
		    img = ImageIO.read(new File(path));
		} catch (IOException e) {
			return;
		}		
		icon.setImage(img);
		Image scaleImage = icon.getImage().getScaledInstance(63, 63,Image.SCALE_DEFAULT);
		icon.setImage(scaleImage);
		label.setIcon(icon);
	}
	
	void Add(List<Ososztaly> ososzt){
		
		System.out.println(">Ososztaly::Add(List<Ososztaly>)");
		ososzt.add(this);
		System.out.println("<Ososztaly::Add(List<Ososztaly>)");
	}
	
	public abstract void draw(Container content, GridBagConstraints c);

}
