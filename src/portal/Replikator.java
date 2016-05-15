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
	
	JLabel fel = new JLabel();
	JLabel le = new JLabel();
	JLabel jobb = new JLabel();
	JLabel bal = new JLabel();
	
	public Replikator(int x, int y) {
		super(x, y);
		
		LoadImage(fel, "bin/replicator_fel.png");
		LoadImage(le, "bin/replicator_le.png");
		LoadImage(jobb, "bin/replicator_jobb.png");
		LoadImage(bal, "bin/replicator_bal.png");
		// TODO Auto-generated constructor stub
	}

	public void fallAndDie() {
		dead = true;
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
		if (irany==Irany.JOBBRA) content.add(jobb, c);
		else if (irany==Irany.BALRA) content.add(bal, c);
		else if (irany==Irany.FEL) content.add(fel, c);
		else content.add(le, c);
	}
}
