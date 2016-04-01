package portal;

public class Doboz extends Ososztaly{
	boolean isLifted = false;
	static int weight=1;
	
	/* Konstruktor
	 * A DOBOZ inicializalasa x, y koordinatakkal
	 */
	public Doboz(int x, int y) {
		
		position = new Pont(x,y);
		
	}
		
	//Doboz felemelese
	public void Lift(){
		
		System.out.println(">Doboz::Lift()");
		isLifted = true;
		System.out.println("<Doboz::Lift()");
	}
	
	//Doboz letevese
	public void Drop(){
		
		System.out.println(">Doboz::Drop()");
		isLifted = false;
		System.out.println("<Doboz::Drop()");
	}
	
	//Doboz helyenek allitasa
	public void setPosition(Pont uj){
		
		System.out.println(">Doboz::setPosition(Pont)");
		if (isLifted)
			position = uj;
		System.out.println("<Doboz::setPosition(Pont)");
	}
	
	//!TODO - KOMMENT
	public Pont ertesit(Pont regi){
		
		System.out.println(">Doboz::ertesit(Pont)");
		System.out.println("<Doboz::ertesit(Pont)");
		return position;
	}
	
	//Doboz megszunik
	void destroy() throws Throwable{
		
		System.out.println(">Doboz::destroy()");
		this.finalize();
		System.out.println("<Doboz::destroy()");
	}
}
