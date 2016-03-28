package portal;

public class Pont {
	private int x, y;
	
	/* DEFAULT Konstruktor
	 * A PONT inicializálása -1, -1 koordinátákkal
	 */
	public Pont(){
		x = -1;
		y = -1;
	}
	
	/* Konstruktor
	 * A PONT inicializálása x, y koordinátákkal
	 */
	public Pont(int x, int y){
		System.out.println(">Pont::konstruktor");	
		this.x = x;
		this.y = y;
		System.out.println("<Pont::konstruktor");
	}
	
	
	//X beállítása
	public void setX(int x){
		System.out.println(">Pont::setX");
		this.x = x;
		System.out.println("<Pont::setX");
	}
	
	//Y beállítása
	public void setY(int y){
		System.out.println(">Pont::setY");
		this.y = y;
		System.out.println("<Pont::setY");
	}
	
	//X visszaadása
	public int getX(){
		System.out.println(">Pont::getX");
		
		System.out.println("<Pont::getX");
		return x;
	}
	
	//Y visszaadása
	public int getY(){
		System.out.println(">Pont::getY");
		
		System.out.println("<Pont::getY");
		return y;
	}
	
	//Mozgatás Y irányban
	public void moveY(int amount){
		this.y = this.y + amount;
	}
	
	//Mozgatás X irányban
	public void moveX(int amount){
		this.x = this.x + amount;
	}
	
	
	public boolean compareTo(Pont masik){
		if (masik.x == this.x && masik.y == this.y) return true;
		return false;
	}

	
}
