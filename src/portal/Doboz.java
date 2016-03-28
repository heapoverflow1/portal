package portal;

public class Doboz extends Ososztaly{
	boolean isLifted;
	
	//Konstruktor
	public Doboz(int x, int y) {
		isLifted = false;
		
		//kezdőhely beállítása
		this.position.add(new Pont(x,y));
		
	}
/*
  	public void setLifted(boolean b){ 
		System.out.println(">Doboz::setLifted");
		isLifted = b;
		System.out.println("<Doboz::setLifted");
	}
*/
	
	//Doboz megszûnik
	void destroy() throws Throwable{
		System.out.println(">Doboz::destroy");
		this.finalize();
		System.out.println("<Doboz::destroy");
	}
}
