package portal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Jatek {
	static Jatekter palya;
	
	private static final Irany JOBBRA = Irany.JOBBRA;
	static Jatekos E = new Jatekos(1, 2, Szin.KEK);
	static Jatekos Jaffa = new Jatekos(1, 1, Szin.SARGA);
	
	public static void listSzereplo(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("Szereplok:");
		for (Ososztaly i : ref){
			if(i.getClass() == Jatekos.class)
				System.out.println(i.toString());		
		}
	}
	public static void listFal(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("Falak:");
		for (Ososztaly i : ref){
			if(i.getClass() == Fal.class){
				System.out.println(i.position.toString());
			}
		}			
	}
	
	public static void listSpecfal(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = palya.getObjects();
		System.out.println("Specfalak:");
		for (Ososztaly i : ref){
			if(i.getClass() == SpecFal.class){
				System.out.println(i.position.toString());
			}
		}			
	}
	public static void listCsillagkapu(){
		System.out.println("Csillagkapuk:");
		System.out.println(palya.kapumgr.toString());
	}
	
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
		palya = new Jatekter();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    while ((s = in.readLine()) != null && s.length() != 0){
	    	String[] params = s.split(" ");
	    	if (params[0].compareTo("loadMap")==0){
	    		if (params[1].compareTo("moveTest")==0){
	    			//System.out.println("MoveTest loaded!");
	    			E.position=new Pont(1, 1);
	    			palya.add(E);
	    			palya.add(new Fal(1, 2));
	    		}
	    		else if (params[1].compareTo("shootAndHitTest")==0){
	    			//System.out.println("MoveTest loaded!");
	    			E.position=new Pont(1, 1);
	    			palya.add(E);
	    			palya.add(new Fal(0, 1));
	    			palya.add(new SpecFal(1, 3, palya.kapumgr));
	    			palya.add(new SpecFal(1, 0, palya.kapumgr));
	    		}
	    	}else if (params[0].compareTo("listSzereplo")==0){
    			listSzereplo();
    		}else if (params[0].compareTo("listFal")==0){
    			listFal();
    		}else if (params[0].compareTo("listSpecfal")==0){
    			listSpecfal();
    		}else if (params[0].compareTo("listCsillagkapu")==0){
    			listCsillagkapu();
    		}else if (params[0].compareTo("move")==0){
    			Irany dir = getDirFromString(params[2]);    			
    			if (params[1].compareTo("E")==0){
    				E.move(dir);
    				System.out.println(E.toString());
    			}else if (params[1].compareTo("J")==0){
    				Jaffa.move(dir);
    				System.out.println(Jaffa.toString());
    			}
    		}else if (params[0].compareTo("shoot")==0){
    			Szin color = getColorFromString(params[1]);
    			Irany dir = getDirFromString(params[3]);
    			if (params[2].compareTo("E")==0){
    				E.setTolteny(color);
    				E.setIrany(dir);
    				E.shoot();
    			}else if (params[2].compareTo("J")==0){
    				Jaffa.setTolteny(color);
    				Jaffa.setIrany(dir);
    				Jaffa.shoot();
    			}
    		}
	    	// An empty line or Ctrl-Z terminates the program
	    }
	}
}
