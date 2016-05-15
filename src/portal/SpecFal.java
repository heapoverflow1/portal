package portal;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SpecFal extends Fal {
    
    /* Konstruktor
     * Az SPECFAL inicializalasa x, y koordinatakkal
     * Meghivja az os (FAL) konstruktorat
     */
    Csillagkapu kapuKezelo;
    
	BufferedImage img = null;
	ImageIcon icon = new ImageIcon(); 
	JLabel kezdo_label = new JLabel();
    
    public SpecFal(int x, int y, Csillagkapu ez) {
        super(x,y);
        kapuKezelo = ez;
        
        try {
		    img = ImageIO.read(new File("bin/specfal.jpg"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		kezdo_label.setIcon(icon);
    }
    
    public void ertesit_shoot(Tolteny t){
        kapuKezelo.SetCsk(this, t.getColor());
        t.destroy();
    }

    public Pont getTeleportPos(){
        return this.position;
    }
    
    //A Kapukezelõhöz fordulunk, aki a mi pozíciónk alapján visszadja,
    //hogy végül hova kerül a szereplõ
    public Pont ertesit(Pont regi, Szereplo sz){
        return kapuKezelo.checkCsk(this, regi);
    }
    
    @Override
    public void draw(Graphics g){
		//TODO!!!
	}
}