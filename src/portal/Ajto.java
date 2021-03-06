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

	JLabel label_closed = new JLabel();
	JLabel label_open = new JLabel();	
	
	/* Konstruktor
	 * Az AJTO inicializalasa x, y koordinatakkal
	 * Meghivja az os (FAL) konstruktorat
	 */
	public Ajto(int x, int y){		
		super(x,y);		
		isOpen = false;
		
		LoadImage(label_open, "bin/ajto_nyitva.png");
		LoadImage(label_closed, "bin/ajto.png");
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
		//Ha t�lt�nyt l�ttek r�nk, megsemmis�tj�k,
		//hiszen ez nem egy speci�lis fal
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
