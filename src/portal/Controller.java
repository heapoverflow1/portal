package portal;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter{
	public Jatekter jatekter;
	private View view;
	private char pressedKey;
	
	public void keyPressed(KeyEvent e){
		System.out.println(e.getKeyCode());
	}
	
}
