package portal;

public class Pont {
	private int x, y;
	
	public Pont(){
		x = -1;
		y = -1;
	}
	
	public Pont(int x, int y){
		System.out.println(">Pont::konstruktor");	
		this.x=x;
		this.y=y;
		System.out.println("<Pont::konstruktor");
	}
	public void setX(int x){
		System.out.println(">Pont::setX");
		this.x=x;
		System.out.println("<Pont::setX");
	}
	public void setY(int y){
		System.out.println(">Pont::setY");
		this.x=y;
		System.out.println("<Pont::setY");
	}
	public int getX(){
		System.out.println(">Pont::getX");
		
		System.out.println("<Pont::getX");
		return x;
	}
	public int getY(){
		System.out.println(">Pont::getY");
		
		System.out.println("<Pont::getY");
		return y;
	}
	public void moveY(int amount){
		this.y = this.y + amount;
	}
	public void moveX(int amount){
		this.x = this.x + amount;
	}
	public boolean compareTo(Pont masik){
		if (masik.x == this.x && masik.y == this.y) return true;
		return false;
	}

	
}
