package portal;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


public class View {
	protected Jatekter jatekter;
	protected JFrame 	frame;
	protected JPanel panel=new JPanel(new BorderLayout(5,5));;
	
	//Menusav es elemei
	protected JMenuBar menuBar;
	protected JMenu exit, newGame;
	protected JMenuItem map1, map2, map3;
	
	//MenuListener
	private MenuListener menuListener;
	private ActionListener actionListener;
	
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
	
	private void InitListeners(){
		
		//MenuListener letrehozasa
		menuListener = new MenuListener() {
			
			//ha ki van valasztva, akkor mit csinaljon a program
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO kiegesziteni
				if(e.getSource().equals(exit)){
					System.exit(0);
				}
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {}
			
			@Override
			public void menuCanceled(MenuEvent e) {}
		};
		
		actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Elso palya betoltese
				if(e.getSource().equals(map1)){
					//!TODO MAP1 betoltese
				}
				//Masodik Palya betoltese
				else if(e.getSource().equals(map2)){
					//!TODO MAP2 betoltese
				}
				//Harmadik palya betoltese
				else if(e.getSource().equals(map3)){
					//!TODO MAP3 betoltese
				}
				
			}
		};
	}
	
	//Menubar inicializalasa
	public void InitMenuBar(){
		
		InitListeners();
		
		//Menubar letrehozasa
		menuBar = new JMenuBar();
		
		//Uj Jatek menuelem
		newGame = new JMenu("Új Játék");
		newGame.addMenuListener(menuListener);
		menuBar.add(newGame);
		
		//Palya 1 megnyitas
		map1 = new JMenu("1. Pálya");
		map1.addActionListener(actionListener);
		newGame.add(map1);
		
		//Palya 2 megnyitas
		map2 = new JMenu("2. Pálya");
		map2.addActionListener(actionListener);
		newGame.add(map2);
		
		//Palya 3 megnyitas
		map3 = new JMenu("3. Pálya");
		map3.addActionListener(actionListener);
		newGame.add(map3);
		
		//Kilepes Menuelem
		exit = new JMenu("Kilépés");
		exit.addMenuListener(menuListener);
		menuBar.add(exit);
		
		frame.setJMenuBar(menuBar);
		
	}
	
	public void Init(){
		
		BufferedImage img = null;
		ImageIcon icon = new ImageIcon(); 
		JLabel label = new JLabel();
		
		try {
		    img = ImageIO.read(new File("bin/mezo.jpg"));
		} catch (IOException e) {
		}
		
		icon.setImage(img);
		label.setIcon(icon);
		
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
		Container content = new JPanel(new GridBagLayout());
		frame = new JFrame("Csillagkapu");
		frame.setPreferredSize(new Dimension(600, 600));
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 600));
		frame.setResizable(false);
		
		InitMenuBar();
		
		UpdateFrame();
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		content.add(a.kezdo_label,c);
		System.out.println(a.img.getHeight());
		System.out.println(a.img.getWidth());
		c.gridx=1;
		c.gridy=0;
		content.add(f.kezdo_label,c);
		c.gridx=2;
		c.gridy=0;
		content.add(dob.kezdo_label,c);
		c.gridx=0;
		c.gridy=1;
		
		content.add(sz.kezdo_label,c);
		c.gridx=1;
		c.gridy=1;
		content.add(m.kezdo_label,c);

		panel.add(content,BorderLayout.CENTER);
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void Update(){
		UpdateFrame();
		frame.revalidate();
	}
}