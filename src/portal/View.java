package portal;

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
	
	
	
}
