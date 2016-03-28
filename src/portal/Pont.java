package portal;

public class Pont {
	private int x, y;
	
	/* DEFAULT Konstruktor
	 * A PONT inicializ�l�sa -1, -1 koordin�t�kkal
	 */
	public Pont(){
		x = -1;
		y = -1;
	}
	
	/* Konstruktor
	 * A PONT inicializ�l�sa x, y koordin�t�kkal
	 */
	public Pont(int x, int y){
		System.out.println(">Pont::konstruktor");	
		this.x = x;
		this.y = y;
		System.out.println("<Pont::konstruktor");
	}
	
	
	//X be�ll�t�sa
	public void setX(int x){
		System.out.println(">Pont::setX");
		this.x = x;
		System.out.println("<Pont::setX");
	}
	
	//Y be�ll�t�sa
	public void setY(int y){
		System.out.println(">Pont::setY");
		this.y = y;
		System.out.println("<Pont::setY");
	}
	
	//X visszaad�sa
	public int getX(){
		System.out.println(">Pont::getX");
		
		System.out.println("<Pont::getX");
		return x;
	}
	
	//Y visszaad�sa
	public int getY(){
		System.out.println(">Pont::getY");
		
		System.out.println("<Pont::getY");
		return y;
	}
	
	//Mozgat�s Y ir�nyban
	public void moveY(int amount){
		this.y = this.y + amount;
	}
	
	//Mozgat�s X ir�nyban
	public void moveX(int amount){
		this.x = this.x + amount;
	}
	
	
	public boolean compareTo(Pont masik){
		if (masik.x == this.x && masik.y == this.y) return true;
		return false;
	}

	
}
