package portal;

<<<<<<< HEAD
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class View extends JFrame {
	Jatekter jatekter;
	
	GridLayout experimentLayout = new GridLayout(0,2);
	public void init(){
		this.setLayout(experimentLayout);
		JLabel jl = new JLabel();
		JLabel j2 = new JLabel();

		
		
	}
	public View(Jatekter jatek){
		jatekter=jatek;
	}
	public void Init(){}
	
	public void ZPMadded(ZPM z) {		
		
	}
	
	public void ZPMcollected(ZPM z){
		
	}
	
	public void DobozMoved(Doboz d) {
		
	}
	
	public void DobozDestroyed(Doboz d){
		
	}
	
	public void AjtoOpened(Ajto a){
		
	}
	
	public void AjtoClosed(Ajto a){
		
	}
	
	public void CSKCreated(Csillagkapu cs){
		
		
	}
	
	public void CSKClosed(Csillagkapu cs){
		
		
	}
	
	public void MerlegSulyOK(Merleg m){
		
	}
	
	public void MerlegSulyNOTOK(Merleg m){
		
	}
	
	public void SzakadekDied(Szakadek sz){
		
	}
	
	public void SzereploMoved(Szereplo sz){
		
	}
	
	public void JatekosDied(Jatekos j){
		
	
	}
	
	public void ReplikatorDied(Replikator r){
		
		
	}
	
	public void ReplikatorFallAndDie(Replikator r, Szakadek sz){
		
	}
	
	
	
=======
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
>>>>>>> refs/remotes/origin/JakabAg
}
