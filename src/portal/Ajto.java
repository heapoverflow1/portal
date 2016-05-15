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

public class Ajto extends Fal implements Ertesit, Drawable{
	boolean isOpen;
	
	BufferedImage img = null;
	ImageIcon icon = new ImageIcon(); 
	static JLabel label_closed = new JLabel();
	
	BufferedImage img2 = null;
	ImageIcon icon2 = new ImageIcon(); 
	static JLabel label_open = new JLabel();
	
	
	/* Konstruktor
	 * Az AJTO inicializalasa x, y koordinatakkal
	 * Meghivja az os (FAL) konstruktorat
	 */
	public Ajto(int x, int y){		
		super(x,y);		
		isOpen = false;
		
		try {
		    img = ImageIO.read(new File("bin/ajto.png"));
		    img2 = ImageIO.read(new File("bin/ajto_nyitva.png"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		icon2.setImage(img2);
		Image scaleImage = icon.getImage().getScaledInstance(63, 63,Image.SCALE_DEFAULT);
		Image scaleImage2 = icon2.getImage().getScaledInstance(63, 63,Image.SCALE_DEFAULT);
		icon.setImage(scaleImage);
		icon2.setImage(scaleImage2);
		label_closed.setIcon(icon);
		label_open.setIcon(icon2);
	}
	
	//Ajtonyitas
	void open(){
		isOpen = true;
	}
	
	//Ajtocsukas
	void close(){
		isOpen = false;
	}
	
	//fal ertesitjenek felulirasa, ha nyitva, ezredes tud arra lepni, egyebkent falkent viselkedik - TG
	public Pont ertesit(Pont regi, Szereplo sz){		
		if(isOpen){
			return position;			
		}
		else{
			return regi;
		}
	}
	public void ertesit_shoot(Tolteny t){
		//Ha töltényt lõttek ránk, megsemmisítjük,
		//hiszen ez nem egy speciális fal
		if (!isOpen) t.alive=false;
	}
	
	public String toString(){
		if (isOpen) return "A";
		else return "a";
	}
	
	public void draw(Container content, GridBagConstraints c){
		if (isOpen) content.add(label_open, c);
		else content.add(label_closed, c);
	}
}
