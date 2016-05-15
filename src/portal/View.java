package portal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class View {
	protected Jatekter jatekter;
	protected JFrame 	frame;
	protected JPanel panel;
	
	public View(Jatekter j){
		jatekter = j;
	}
	
	private void UpdateFrame(){
		//TODO!! Jelenítse meg, ne a konzolra írja ki
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = jatekter.getObjects();
		
		char[][] palya = new char[jatekter.getWidth()][jatekter.getHeight()];
		for (int i=0;i<jatekter.getWidth(); i++){
			for (int j=0;j<jatekter.getHeight();j++){
				palya[i][j]=' ';
			}
		}
		
		for (Ososztaly i : ref){
			char abra = ' ';
			if(i.getClass() == Ajto.class){
				abra='a';
			}else if (i.getClass()==Doboz.class){
				abra='d';
			}
			else if (i.getClass()==Jatekos.class){
				abra='J';
			}
			else if (i.getClass()==Szakadek.class){
				abra='x';
			}
			else if (i.getClass()==Merleg.class){
				abra='m';
			}
			else if (i.getClass()==Fal.class){
				abra='O';
			}
			palya[i.position.getX()][i.position.getY()] = abra;
		}
		
		System.out.println("-----------");
		for (int i=0;i<jatekter.getWidth(); i++){
			System.out.print("|");
			for (int j=0;j<jatekter.getHeight();j++){
				System.out.print(palya[j][i]);
			}
			System.out.println("|");
		}
		System.out.println("-----------");
	}
	
	public void Init(){
		frame = new JFrame("Csillagkapu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UpdateFrame();
		frame.pack();
		frame.setVisible(true);
	}
	
	public void Update(){
		UpdateFrame();
		frame.revalidate();
	}
}
