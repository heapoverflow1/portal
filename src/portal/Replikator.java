package portal;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Replikator extends Szereplo {

	BufferedImage img = null;
	ImageIcon icon = new ImageIcon(); 
	JLabel kezdo_label = new JLabel();
	
	public Replikator(int x, int y) {
		super(x, y);
		
		try {
		    img = ImageIO.read(new File("bin/replicator_fel.png"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		kezdo_label.setIcon(icon);
		// TODO Auto-generated constructor stub
	}

	public void fallAndDie() {
		try {
			Jatek.palya.removeQueue.add(this);
			//Jatek.palya.objects.remove(this);
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void ertesit_shoot(Tolteny t) {		
		t.destroy();
		//Jatek.palya.removeQueue.add(this);
		fallAndDie();
	}
	
	public String toString(){
		return "R "+position.toString();
	}
	
	public void draw(Container content, GridBagConstraints c){
		content.add(kezdo_label, c);
	}
}
