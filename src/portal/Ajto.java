package portal;

import java.awt.Graphics;
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
	JLabel kezdo_label = new JLabel();
	
	
	
	/* Konstruktor
	 * Az AJTO inicializalasa x, y koordinatakkal
	 * Meghivja az os (FAL) konstruktorat
	 */
	public Ajto(int x, int y){		
		super(x,y);		
		isOpen = false;
		
		try {
		    img = ImageIO.read(new File("bin/ajto.png"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		kezdo_label.setIcon(icon);
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
	
	public void draw(Graphics g){
		//TODO!!!
	}
}
