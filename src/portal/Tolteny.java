package portal;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;

public class Tolteny extends Ososztaly implements Drawable{
	Szin szin;
	boolean alive = true;
	
	/* Konstruktor
	 * A TOLTENY inicializalasa blueType-ra
	 * !TODO 
	 * ez kell? x, y koordinatakkal -WM
	 * Beletettem, így van kezdopozicioja -WM
	 */
	public Tolteny(Szin sz, Pont pos) {
		
		szin = sz;
		position = new Pont(pos);
	}
	
	//!TODO
	void shoot(Irany irany) throws Throwable{
		
		int TTL = 100;
		//!TODO
		while (alive && TTL>0){
			Pont p= this.position;
			int y =0;
			 switch (irany) {
			 
			 case FEL: 
				 y = p.getY()-1;
				 p.setY(y); 
				 break;
				 
			 case LE:
				 y = p.getY()+1;
				 p.setY(y); 
				 break;
				 
			 case JOBBRA:
				 y = p.getX()+1;
				 p.setX(y); 
				 break;
				 
			 case BALRA:
				 y = p.getX()-1;
				 p.setX(y); 
				 break;
			 }
			//System.out.println("Tolteny mozog: "+p.toString());
			Jatek.palya.checkfield_shoot(p, this);
			TTL--;
			if (alive)
			 position=p;		
		}
		this.finalize();
		
	}
	
	//Ha vegunk, akkor az aktualis kor meg vegigmegy, utana a shoot
	//fv-ben hivodik a finalize
	void destroy(){
		this.alive=false;
		Jatek.view.Update();
	}

	@Override
	public Pont ertesit(Pont innenlep, Szereplo sz) {
		return position;
		//A lepest nem akadalyozza meg, ha valaki rajtunk halad keresztul
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		//Nem utkozhetunk ossze masik toltennyel
	}
	
	Szin getColor(){		
		return szin;
	}
	
	public void draw(Container content, GridBagConstraints c){
		//TODO!!!
	}
}
