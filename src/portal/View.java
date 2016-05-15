package portal;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


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
		Ajto a = new Ajto(3,2);
		Szakadek sz = new Szakadek(1,3);
		Merleg m= new Merleg(1,4,a,1);
		Doboz dob = new Doboz(4,5);
		Fal f = new Fal (5,5);
		
		List<Ososztaly> ref1 = new ArrayList<Ososztaly>();
		ref1.add(a);
		ref1.add(sz);
		ref1.add(m);
		ref1.add(dob);
		ref1.add(f);
		
		GridLayout experiment = new GridLayout(10,10);
		Container content = new JPanel(new GridLayout(10,10));
		frame = new JFrame("Csillagkapu");
		frame.setPreferredSize(new Dimension(600, 600));
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UpdateFrame();
		
		for (int i=0;i<100;i++){
			
			for (Ososztaly o : ref1){
				if ((o.position.getX()*10 + o.position.getY()-1)== i){
					if (o.getClass()==Ajto.class)
						Ajto a1= (Ajto)o;
					
				}
					
					
			}
		}
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void Update(){
		UpdateFrame();
		frame.revalidate();
	}
}