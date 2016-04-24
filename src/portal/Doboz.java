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
		
		
		isLifted = true;
		
	}
	
	//Doboz letevese
	public void Drop(){
		
		
		isLifted = false;
		
	}
	
	//Doboz helyenek allitasa
	public void setPosition(Pont uj){
		
		
		if (isLifted)
			position = uj;
		
	}
	

	
	//Doboz megszunik
	void destroy() throws Throwable{
		
		
		this.finalize();
		
	}

	@Override
	public Pont ertesit(Pont innenlep, Szereplo sz) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public void ertesit_shoot(Tolteny t) {
		// TODO Auto-generated method stub
		
	}
}
