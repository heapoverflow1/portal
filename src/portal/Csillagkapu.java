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

public class Csillagkapu implements Drawable{
	SpecFal[] falak;	
	boolean[] Feregjarat;
	
	//Ezeket kellhet kirajzolni:
	JLabel kek_GO = new JLabel();
	JLabel kek_NOGO = new JLabel();
	JLabel piros_GO = new JLabel();
	JLabel piros_NOGO = new JLabel();
	JLabel sarga_GO = new JLabel();
	JLabel sarga_NOGO = new JLabel();
	JLabel zold_GO = new JLabel();
	JLabel zold_NOGO = new JLabel();
	
	//Ugyanez a megoldas az oszosztalynal, de a Csillagkapu kezelo nem
	//leszarmazottja az oszosztalynak
	//Kommentezest lasd ott.
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
	
	/* Konstruktor
	 * beallitja a feregjaratot false-ra. Alapertelmezes.
	 */
	public Csillagkapu() {
		
		Feregjarat = new boolean[2];
		falak = new SpecFal[4];
		for (int i=0;i<4;i++){
			falak[i]=null;
		}
		
		//A kepek betoltese:
		LoadImage(kek_GO, "bin/portal_kek_GO.png");
		LoadImage(kek_NOGO, "bin/portal_kek_NOGO.png");
		LoadImage(piros_GO, "bin/portal_piros_GO.png");
		LoadImage(piros_NOGO, "bin/portal_piros_NOGO.png");
		LoadImage(sarga_GO, "bin/portal_sarga_GO.png");
		LoadImage(sarga_NOGO, "bin/portal_sarga_NOGO.png");
		LoadImage(zold_GO, "bin/portal_zold_GO.png");
		LoadImage(zold_NOGO, "bin/portal_zold_NOGO.png");	
	}
	
	//Ez eredetileg Contains lett volna, de megtetszett az elgepeles
	public boolean Contaion(SpecFal fal){
		for (int i=0;i<4;i++){
			if (falak[i]==fal) return true;
		}
		return false;
	}
	
	// Beallitja a kek privat SpecFal erteket a kapottra
	public boolean SetCsk(SpecFal pos, Szin color){
		falak[color.getValue()] = pos;
		//a megfelelõ színhez tároljuk, hogy melyik fal tartozik
		Szin masik = null;
		//megszerezzük, hogy milyen színû a párja
		switch(color){
			case SARGA:
				masik = Szin.KEK;
				break;
			case KEK:
				masik = Szin.SARGA;
				break;
			//a sárgának a kék,
			case ZOLD:
				masik = Szin.PIROS;
				break;
			case PIROS:
				masik = Szin.ZOLD;
				break;
			//a zöldnek a piros
			default:
				break;
		}
		//elkerüljük a nullpointerexceptiont az ellenõrzéssel
		if (masik!=null && falak[masik.getValue()]==null){
			Feregjarat[color.getValue()/2]=true;
			return true;
		}
		return false;
	}

	//Megnezzuk, hogy teleportal-e a Jatekos.
	public Pont checkCsk(SpecFal fal, Pont innenjon){
		for (int i=0;i<4;i++){
			if (fal==falak[i]){
				//Ha csillagkapura lepett, es a feregjarat aktiv, a kapu tuloldalara kerul
				//A parok: 0-1, 2-3. Azaz ha paros sorszamu kapura lepett,
				//az eggyel nagyobb, ha paratlan sorszamura, az eggyel kisebb
				//SpecFal poziciojára lép
				if (i%2==0 && falak[i+1]!=null) return falak[i+1].getTeleportPos();
				if (i%2==1 && falak[i-1]!=null) return falak[i-1].getTeleportPos();
				return innenjon;
			}
		}
		//Egyebkent nem mozdulhat, hiszen fal van ott
		return innenjon;
	}
	
	public String toString(){
		String visszaEzzel="";
		for (int i=0;i<4;i++){
			if (falak[i]!=null) visszaEzzel += falak[i].position.toString() +"\r\n";
		}
		return visszaEzzel;
	}
	
	public void draw(Container content, GridBagConstraints c){
		//0-4 darab Csillagkapu kirajzolasa.
		//Rengeteg lehetoseg van, a kapuk nem feltetlen aktivak
		
		//Az aktivsag megvizsgalasa
		//mindket kapu eseten!
		boolean sargakek = false;
		boolean zoldpiros = false;
		if (falak[Szin.KEK.getValue()]!=null && falak[Szin.SARGA.getValue()]!=null){sargakek=true;}
		if (falak[Szin.ZOLD.getValue()]!=null && falak[Szin.PIROS.getValue()]!=null){zoldpiros=true;}
		
		Pont pos;
		
		//Ha az adott kapu letezik, odatesszuk az ikont
		if (falak[Szin.KEK.getValue()]!=null){
			pos = falak[Szin.KEK.getValue()].position;
			c.gridx = pos.getX();
			c.gridy = pos.getY();
			if (sargakek) content.add(kek_GO, c);
			else content.add(kek_NOGO, c);
		}
		
		if (falak[Szin.SARGA.getValue()]!=null){
			pos = falak[Szin.SARGA.getValue()].position;
			c.gridx = pos.getX();
			c.gridy = pos.getY();
			if (sargakek) content.add(sarga_GO, c);
			else content.add(sarga_NOGO, c);
		}
		
		if (falak[Szin.ZOLD.getValue()]!=null){
			pos = falak[Szin.ZOLD.getValue()].position;
			c.gridx = pos.getX();
			c.gridy = pos.getY();
			if (zoldpiros) content.add(zold_GO, c);
			else content.add(zold_NOGO, c);
		}

		if (falak[Szin.PIROS.getValue()]!=null){
			pos = falak[Szin.PIROS.getValue()].position;
			c.gridx = pos.getX();
			c.gridy = pos.getY();
			if (zoldpiros) content.add(piros_GO, c);
			else content.add(piros_NOGO, c);
		}
	}
}
