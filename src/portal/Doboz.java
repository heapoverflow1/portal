package portal;

public class Doboz extends Ososztaly{
	boolean isLifted;
	
	//Konstruktor
	public Doboz(int x, int y) {
		System.out.println(">Doboz::konstruktor");
		isLifted = false;
		
		//kezdőhely beállítása
		this.position = new Pont(x,y);
		
		System.out.println("<Doboz::konstruktor");
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
