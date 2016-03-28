package portal;

public class Doboz extends Ososztaly{
	boolean isLifted;
	
	/* Konstruktor
	 * A DOBOZ inicializalasa x, y koordinatakkal
	 */
	public Doboz(int x, int y) {
		
		isLifted = false;
		position = new Pont(x,y);
		
	}
/*
  	public void setLifted(boolean b){ 
		System.out.println(">Doboz::setLifted");
		isLifted = b;
		System.out.println("<Doboz::setLifted");
	}
*/
	public Pont ertesit(Pont regi){
		System.out.println(">Doboz::ertesit");
		System.out.println("<Doboz::ertesit");
		return position;
	}
	
	//Doboz megszunik
	void destroy() throws Throwable{
		System.out.println(">Doboz::destroy");
		this.finalize();
		System.out.println("<Doboz::destroy");
	}
}
