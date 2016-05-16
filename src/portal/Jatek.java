package portal;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class Jatek {
	static Jatekter palya;
	
	public static View view;
	
	private static final Irany JOBBRA = Irany.JOBBRA;
	static Jatekos E = new Jatekos(1, 2, Szin.KEK);
	static Jatekos Jaffa = new Jatekos(1, 1, Szin.ZOLD);
	static Replikator rep = new Replikator(3,3);
	
	public static Irany getDirFromString(String pms){
		Irany dir = Irany.JOBBRA;
		if (pms.compareToIgnoreCase("j")==0){
			dir = Irany.JOBBRA;
		}else if (pms.compareToIgnoreCase("b")==0){
			dir = Irany.BALRA;
		}else if (pms.compareToIgnoreCase("f")==0){
			dir = Irany.FEL;
		}else if (pms.compareToIgnoreCase("l")==0){
			dir = Irany.LE;
		}
		return dir;
	}
	
	public static Szin getColorFromString(String pms){
		Szin clr = Szin.KEK;
		if (pms.compareToIgnoreCase("s")==0){
			clr = Szin.SARGA;
		}else if (pms.compareToIgnoreCase("z")==0){
			clr = Szin.ZOLD;
		}else if (pms.compareToIgnoreCase("p")==0){
			clr = Szin.PIROS;
		}else if (pms.compareToIgnoreCase("k")==0){
			clr = Szin.KEK;
		}
		return clr;		
	}
	
	public static void main(String[] args) throws Throwable{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    
	    boolean palyaLoaded = false;
	    palya = new Jatekter();
	    view = new View(palya);
	    
	    view.Init();
	}
	
	public static void NewGame(String path){
		List<String> objektumLista;
		try{
			Path megnyitando = Paths.get(path);
			objektumLista = Files.readAllLines(megnyitando);
		}catch (Exception e){
			return;
		}
		palya.removeAll();
		palya.add(E);
		palya.add(Jaffa);

		//Map<Integer, Merleg> merlegek = new HashMap<Integer, Merleg>();
		Map<Integer, Ajto> ajtok = new HashMap<Integer, Ajto>();
		
		String palyaMeret = objektumLista.get(0);
		String adatok[] = palyaMeret.split(",");
	    palya.setWidth(Integer.parseInt(adatok[0]));
	    palya.setHeight(Integer.parseInt(adatok[1]));
	    objektumLista.remove(0);
	    
		for (String egysor : objektumLista){
			adatok = egysor.split(",");
			if (adatok[0].equalsIgnoreCase("F")){
				palya.add(new Fal(Integer.parseInt(adatok[1])-1, Integer.parseInt(adatok[2])-1));
			}
			else if (adatok[0].equalsIgnoreCase("S")){
				palya.add(new SpecFal(Integer.parseInt(adatok[1])-1, Integer.parseInt(adatok[2])-1, palya.kapumgr));
			}
			else if (adatok[0].equalsIgnoreCase("T")){
				palya.add(new Szakadek(Integer.parseInt(adatok[1])-1, Integer.parseInt(adatok[2])-1));
			}
			else if (adatok[0].equalsIgnoreCase("D")){
				palya.add(new Doboz(Integer.parseInt(adatok[1])-1, Integer.parseInt(adatok[2])-1, Integer.parseInt(adatok[3])));
			}
			else if (adatok[0].equalsIgnoreCase("Z")){
				palya.add(new ZPM(Integer.parseInt(adatok[1])-1, Integer.parseInt(adatok[2])-1));
			}
			else if (adatok[0].equalsIgnoreCase("A")){
				Ajto cucc = new Ajto(Integer.parseInt(adatok[1])-1, Integer.parseInt(adatok[2])-1);
				ajtok.put(Integer.parseInt(adatok[3]), cucc);
				palya.add(cucc);
			}
			else if (adatok[0].equalsIgnoreCase("M")){
				palya.add(new Merleg(Integer.parseInt(adatok[1])-1, Integer.parseInt(adatok[2])-1, ajtok.get(Integer.parseInt(adatok[3])), Integer.parseInt(adatok[4])));
			}
			else if (adatok[0].equalsIgnoreCase("E")){
				E.position.setX(Integer.parseInt(adatok[1])-1);
				E.position.setY(Integer.parseInt(adatok[2])-1);
			}
			else if (adatok[0].equalsIgnoreCase("J")){
				Jaffa.position.setX(Integer.parseInt(adatok[1])-1);
				Jaffa.position.setY(Integer.parseInt(adatok[2])-1);
			}
			else if (adatok[0].equalsIgnoreCase("R")){
				rep.position.setX(Integer.parseInt(adatok[1])-1);
				rep.position.setY(Integer.parseInt(adatok[2])-1);
				rep.dead=false;
				palya.add(rep);
				Timer timer = new Timer();
				timer.schedule( new ReplicatorMover(), 1000, 1000);
			}
			//Ezredes, m�rleg, ajt�
		}
		view.Update();
	}
	
	
}