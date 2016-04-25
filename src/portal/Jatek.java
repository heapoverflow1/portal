package portal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Jatek {
	static Jatekter palya;
	
	private static final Irany JOBBRA = Irany.JOBBRA;
	static Jatekter J = new Jatekter();
	static Jatekos E = new Jatekos(1, 2, Szin.KEK);
	static Jatekos Jaffa = new Jatekos(1, 1, Szin.SARGA);
	
	public static void listSzereplo(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		J.getObjects(ref);
		System.out.println("Szereplok:");
		for (Ososztaly i : ref){
			if(i.getClass() != Jatekos.class){
				ref.remove(i);
			}else{
				System.out.println(i.toString());
			}			
		}
	}
	public static void listFal(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		J.getObjects(ref);
		System.out.println("Falak:");
		for (Ososztaly i : ref){
			if(i.getClass() != Fal.class){
				ref.remove(i);
			}else{
				System.out.println(i.position.toString());
			}
		}
			
	}
	
	public static void main(String[] args) throws IOException{
		palya = new Jatekter();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    while ((s = in.readLine()) != null && s.length() != 0){
	    	String[] params = s.split(" ");
	    	if (params[0].compareTo("loadMap")==0){
	    		if (params[1].compareTo("moveTest")==0){
	    			E.position=new Pont(1, 1);
	    			palya.add(E);
	    			palya.add(new Fal(1, 2));
	    		}
	    	}else if (params[0].compareTo("listSzereplo")==0){
    			listSzereplo();
    		}else if (params[0].compareTo("listFal")==0){
    			listFal();
    		}else if (params[0].compareTo("move")==0){
    			Irany dir = Irany.JOBBRA;
    			if (params[2].compareToIgnoreCase("j")==0){
    				dir = Irany.JOBBRA;
    			}else if (params[2].compareToIgnoreCase("b")==0){
    				dir = Irany.BALRA;
    			}else if (params[2].compareToIgnoreCase("f")==0){
    				dir = Irany.FEL;
    			}else if (params[2].compareToIgnoreCase("l")==0){
    				dir = Irany.LE;
    			}
    			
    			if (params[1].compareTo("E")==0){
    				E.move(dir);
    				System.out.println(E.toString());
    			}else if (params[1].compareTo("J")==0){
    				Jaffa.move(dir);
    				System.out.println(Jaffa.toString());
    			}
    		}
	    	System.out.println(s);
	    	// An empty line or Ctrl-Z terminates the program
	    }
	}
}
