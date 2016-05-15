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

public class Jatekos extends Szereplo implements Drawable{
	Doboz doboz;
	Szin tolteny_szin;	
	private int zpmcount;	
	static int weight;
	
	JLabel ezredes_fel = new JLabel();
	JLabel ezredes_le = new JLabel();
	JLabel ezredes_jobb = new JLabel();
	JLabel ezredes_bal = new JLabel();
	JLabel jaffa = new JLabel();
	
	/* Konstruktor
	 * A JATEKOS a konstruktorban kapott SZINu toltenye van.
	 * Meghivja az ososztalyanak a konstruktorat (beallitja a poziciot es kezdoiranyt)
	 */
	public Jatekos(int x, int y, Szin sz) {
		super(x,y);
		zpmcount = 0;
		weight = 1;		
		tolteny_szin = sz;		
		doboz = null;
		
		LoadImage(ezredes_fel, "bin/ezredes_fel.png");
		LoadImage(ezredes_le, "bin/ezredes_le.png");
		LoadImage(ezredes_bal, "bin/ezredes_bal.png");
		LoadImage(ezredes_jobb, "bin/ezredes_jobb.png");
		LoadImage(jaffa, "bin/jaffa.png");
	}
	
	/* JATEKOS mozgatasa irany iranyba
	 * irany valtozoja beallitasa
	 * Megprobal lepni a JATEKOS egyet az adott iranyba,
	 * majd megkeri a JATEKTER-et, hogy hivja meg az adott
	 * pozicion levo dolognak az ERTESIT fuggvenyet, ami visszater egy
	 * adott pozicioval a targytol fuggoen ( ha FAL, akkor a regi pozicio, azaz nem leptunk,
	 * ha MERLEG, akkor az uj pozicio, tehat leptunk)
	 */	
	public void move(Irany irany){	
		this.irany = irany;
		
		Pont ujhely = new Pont(position);
		ujhely.move(irany);
		position = Jatek.palya.checkfield(position, ujhely, this);
		if (doboz != null) doboz.setPosition(position);
				
	}
	
	//!TODO - JATEKOS meghalasa utan VEGE a jateknak
	public void fallAndDie(){
							
	}
	
	
	/*  Letrehoz egy uj toltenyt a beallitott szinnel
	 * 	Majd kilovi, azaz meghivja a TOLTENY SHOOT metodusat 
	 */
	void shoot() throws Throwable{
		
		Tolteny t1 = new Tolteny(tolteny_szin, position);
		t1.shoot(irany);
		
	}
	
	/*  Ugyanazon pozicion levo DOBOZ kerese a JATEKTERTOL,
	 *  majd felemeles attol fuggoen, hogy MERLEGen volt a DOBOZ vagy nem
	 *  
	 */
	void lift(){			
		
		//ha mar van a kezeben doboz akkor visszater
		if (doboz != null){
			
			return;		
		}			
		
		//ha merlegen all, akkor a merleg stackjebol szedje le a legfelsot, egyebkent csak vegye fel a dobozt
		Merleg m = Jatek.palya.getMerleg(position);
		if(m != null){
			
			doboz=m.removeTopDoboz();
		}else{
			
			doboz = Jatek.palya.getDoboz(position);
		}
		
		doboz = Jatek.palya.getDoboz(position);
		
		if (doboz!=null)
			doboz.Lift();
		
	}
	
	/*  Doboz letevese, ezaltal az ezredes DOBOZ valtozojanak NULL-ra allitasa
	 *  
	 */
	void drop(){		
		if (doboz==null) return;
		Pont newPosition=new Pont(doboz.position);
		
		//a dobozt arra szeretnem elmozditani, amerre az ezredes nez
		newPosition.move(irany);
		
		//megnezem hogy merlegre teszi-e a dobozt
		Merleg m = Jatek.palya.getMerleg(newPosition);
		
		//ha falba akarnank tenni a dobozt, visszater
		//ha van mar doboz az uj pozicioban, es az nem merlegen all, akkor visszater
		//zpm-re se tegyuk
		for (Ososztaly i : Jatek.palya.objects){
			if (i.position.compareTo(newPosition) && (i instanceof Fal)){
				return;
			}
			else if(i.position.compareTo(newPosition) && (i instanceof Doboz) && (m == null)){
				return;
			}
			else if(i.position.compareTo(newPosition) && (i instanceof ZPM)){
				return;
			}
			else if(i.position.compareTo(newPosition) && (i instanceof Szakadek)){
				try {
					doboz.destroy();
				} catch (Throwable e) {
					e.printStackTrace();
				}
				return;
			}
		}
		
		//ha eljutott idaig akkor mar biztos az uj pozicioba fog kerulni
		doboz.position=newPosition;
		
		//ha merlegre tesszuk, akkor hozzaadjuk a merleg stackjehez
		if(m != null){
			m.addDoboz(doboz);
		}
		
		doboz.Drop();
		doboz = null;
				
	}
	
	//A JATEKOS felvett egy ZPM-et, a zpmcount novelese.
	void collectZPM(){
					
		zpmcount++;		
	}
	
	//Visszaadja a ZPMCOUNT erteket
	int getZPMcount(){
				
		return zpmcount;
	}
	
	//Tolteny valtasa
	void changeTolteny(){		
		if (tolteny_szin ==  Szin.KEK)
			tolteny_szin = Szin.SARGA;
		else if (tolteny_szin ==  Szin.SARGA)
			tolteny_szin = Szin.KEK;
		else if (tolteny_szin ==  Szin.PIROS)
			tolteny_szin = Szin.ZOLD;
		else if (tolteny_szin ==  Szin.ZOLD)
			tolteny_szin = Szin.PIROS;	
	}
	
	public void setIrany(Irany erre){
		this.irany=erre;
	}
	
	public void setTolteny(Szin erre){
		if ((erre==Szin.KEK || erre==Szin.SARGA) && (tolteny_szin==Szin.KEK || tolteny_szin==Szin.SARGA))
			tolteny_szin=erre;
		if ((erre==Szin.ZOLD || erre==Szin.PIROS) && (tolteny_szin==Szin.ZOLD || tolteny_szin==Szin.PIROS))
			tolteny_szin=erre;
	}
	
	public String toString(){
		if (tolteny_szin==Szin.KEK || tolteny_szin==Szin.SARGA){
			return "E "+position.toString();
		}
		return "J "+position.toString();
	}
	
	public void draw(Container content, GridBagConstraints c){
		if (tolteny_szin==Szin.KEK || tolteny_szin==Szin.SARGA){
			if (irany==Irany.JOBBRA) content.add(ezredes_jobb, c);
			else if (irany==Irany.BALRA) content.add(ezredes_bal, c);
			else if (irany==Irany.FEL) content.add(ezredes_fel, c);
			else content.add(ezredes_le, c);
		}
		else content.add(jaffa, c);
	}
	
}
