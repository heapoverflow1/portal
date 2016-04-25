package portal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Jatek {
	static Jatekter palya;
	
	private static final Irany JOBBRA = Irany.JOBBRA;
	Jatekter J = new Jatekter();
	Jatekos E = new Jatekos(1, 2, Szin.KEK);
	
	public void initTest(){
		J.add(E);
		J.add(new Fal(1, 2));
	}
	
	public void listSzereplo(List<Ososztaly> ref){
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
	public void listFal(List<Ososztaly> ref){
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
	    			palya.add(new Jatekos(1, 1, Szin.KEK));
	    			palya.add(new Fal(1, 2));
	    		}
	    	}
	    	System.out.println(s);
	    	// An empty line or Ctrl-Z terminates the program
	    }
	}
}
