package portal;

public class Merleg extends Ososztaly{
	boolean isPressed;
	Ajto nyitando;
	
	/* Konstruktor
	 * A MERLEG inicializalasa x, y koordinatakkal
	 */
	public Merleg(int x, int y, Ajto nyitando) {
		
		isPressed = false;
		position = new Pont(x, y);
		this.nyitando = nyitando;
	}
	
	public Pont ertesit(Pont regi){
		
		System.out.println(">Merleg::ertesit");
		if(position.compareTo(regi)){
			//ha lelepnek rola, vagy dobozt tesznek ra - TG
			weighted(false);
		}
		else
			//ha ralepnek, vagy dobozt vesznek le rola - TG
			weighted(true);
		System.out.println("<Merleg::ertesit");
		return position;
	}
	
	//!TODO
	//Azt vizsgalja, van-e sulya a merlegen
	//csak parameterrel tudtam megoldani, a fuggvenynek valahogy tudnia kell, hogy epp lenyomjak, vagy nem - TG
	void weighted(boolean incoming){
		System.out.println(">Merleg::weighted");
		if(incoming){			
			
		isPressed = true;
		nyitando.open();
		System.out.println("<Merleg::weighted");
		}
		else{
			isPressed = false;
			nyitando.close();
			System.out.println("<Merleg::weighted");
		}
	}
}
