package portal;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Merleg extends Ososztaly implements Ertesit, Drawable{
	Ajto nyitando;
	Stack<Doboz> dobozok=new Stack<Doboz>();
	int currentWeight=0;
	int openWeight;
	
	BufferedImage img = null;
	ImageIcon icon = new ImageIcon(); 
	JLabel kezdo_label = new JLabel();
	
	/* Konstruktor
	 * A MERLEG inicializalasa x, y koordinatakkal
	 */
	public Merleg(int x, int y, Ajto nyitando, int openWeight) {
			
		position = new Pont(x, y);
		this.nyitando = nyitando;
		this.openWeight=openWeight;
		try {
		    img = ImageIO.read(new File("bin/merleg_NOGO.png"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		kezdo_label.setIcon(icon);
		
	}
	
	//rarak egy dobozt a merlegre, sulyaval noveli
	public void addDoboz(Doboz d){
		dobozok.push(d);
		currentWeight+=Doboz.weight;
		weighted();
		
	}

	//leveszi a legfolso dobozt a merlegrol, csokken a suly
	public Doboz removeTopDoboz(){
		if(!dobozok.empty()){
			currentWeight-=Doboz.weight;
			weighted();
			return dobozok.pop();
		}
		return null;
	}
	
	//ezredes raall a merlegre
	public void ezredesStepsOn(){
		currentWeight+=Jatekos.weight;
		weighted();
	}
	
	//ezredes leszall a merlegrol
	public void ezredesStepsOff(){
			currentWeight-=Jatekos.weight;
			weighted();
	}
	
	public Pont ertesit(Pont regi, Szereplo sz){
		if(position.compareTo(regi)){
			//ha lelepnek rola
			ezredesStepsOff();
		}
		else			
			//ha ralepnek
			ezredesStepsOn();
		return position;
	}
	
	//megnezi, van-e eleg suly a merlegen az ajto kinyitasahoz
	void weighted(){
		
		
		
		if(currentWeight>=openWeight){
			nyitando.open();		
		}
		else{
			nyitando.close();
		}
		
		
	}


	@Override
	public void ertesit_shoot(Tolteny t) {
		// TODO Auto-generated method stub
		
	}
	
	public void draw(Graphics g){
		//TODO!!!
	}
}
