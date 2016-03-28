package portal;

public class Pont {
	private int x, y;
	
	public Pont(int x, int y){
		this.x=x;
		this.y=y;
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

	
}
