package portal;

import java.util.List;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class movetest {
	
	private static final Irany JOBBRA = Irany.JOBBRA;
	Jatekter J = new Jatekter();
	Jatekos E = new Jatekos(1, 2, Szin.KEK);
	
	public void initTest(){
		J.add(E);
		J.add(new Fal(1, 2));
	}
	
	public void listSzereplo(List<Ososztaly> ref){
		J.getObjects(ref);
		for (Ososztaly i : ref){
			if(i.getClass() != Jatekos.class){
				ref.remove(i);
			}
		}
	}
	public void listFal(List<Ososztaly> ref){
		J.getObjects(ref);
		for (Ososztaly i : ref){
			if(i.getClass() != Fal.class){
				ref.remove(i);
			}
		}
			
	}
	
	
	
	
	@Test
	public void move() {	  
	   initTest();

	   List<Ososztaly> falak = null;
	   List<Ososztaly> szereplok = null;	
	   
	   System.out.println("Szereplok:\n");
	   listSzereplo(szereplok);
	   System.out.println(szereplok.toString());
	   
	   
	   System.out.println("Falak:\n");
	   listFal(falak);
	   System.out.println(falak.toString());
	   
	   E.move(JOBBRA);
	   listSzereplo(szereplok);
	   assertEquals(szereplok.get(0).position,new Pont(1,2));
	   System.out.println("E" + szereplok.get(0).position.getX()
			   + "," + szereplok.get(0).position.getY());
	   
	   E.move(JOBBRA);
	   listSzereplo(szereplok);
	   assertEquals(szereplok.get(0).position,new Pont(1,2));
	   System.out.println("E" + szereplok.get(0).position.getX()
			   + "," + szereplok.get(0).position.getY());

	}

	
}