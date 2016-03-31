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
		
		System.out.println(">Merleg::ertesit(Pont)");
		
		if(position.compareTo(regi)){
			
			//ha lelepnek rola, vagy dobozt vesznek le rola - TG
			weighted(false);
		}
		else			
			//ha ralepnek, vagy dobozt tesznek ra - TG
			weighted(true);
		
		System.out.println("<Merleg::ertesit(Pont)");
		return position;
	}
	
	//Azt vizsgalja, van-e sulya a merlegen
	//csak parameterrel tudtam megoldani, a fuggvenynek valahogy tudnia kell, hogy epp lenyomjak, vagy nem - TG
	//!TODO valaki adjon ennek a parameternek egy szebb nevet, nekem nem jut eszembe jobb - TG
	void weighted(boolean incoming){
		
		System.out.println(">Merleg::weighted(boolean)");
		
		if(incoming){
			isPressed = true;
			nyitando.open();		
		}
		else{
			isPressed = false;
			nyitando.close();
		}
		
		System.out.println("<Merleg::weighted(boolean)");
	}
}
