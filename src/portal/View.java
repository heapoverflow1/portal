package portal;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	protected JPanel panel=new JPanel();
	Container content = new JPanel(new GridBagLayout());
	
	//Menusav es elemei
	protected JMenuBar menuBar;
	protected JMenu exit, newGame;
	protected JMenuItem map1, map2, map3;
	
	//MenuListener
	private MenuListener menuListener;
	private ActionListener actionListener;
	private KeyListener keyListener;
	
	public View(Jatekter j){
		jatekter = j;
	}
	
	private void UpdateFrame(){
		List<Ososztaly> ref = new ArrayList<Ososztaly>();
		ref = jatekter.getObjects();
		
		BufferedImage img = null;
		ImageIcon icon = new ImageIcon(); 
		JLabel label = new JLabel();
		
		try {
		    img = ImageIO.read(new File("bin/mezo.jpg"));
		} catch (IOException e) {
		}
		
		GridBagConstraints c = new GridBagConstraints();
		
		icon.setImage(img);
		Image scaleImage = icon.getImage().getScaledInstance(63, 63,Image.SCALE_DEFAULT);
		icon.setImage(scaleImage);
		label.setIcon(icon);
		
		char[][] palya = new char[jatekter.getWidth()][jatekter.getHeight()];
		for (int i=0;i<jatekter.getWidth(); i++){
			for (int j=0;j<jatekter.getHeight();j++){
				palya[i][j]=' ';
			}
		}
		content.removeAll();
		
		for (Ososztaly o : ref){
			c.gridx=o.position.getX();
			c.gridy=o.position.getY();
			if (c.gridx>=jatekter.getWidth() || c.gridy>=jatekter.getHeight()) continue;
			palya[c.gridx][c.gridy] = 'X';
			o.draw(content, c);
		}
		jatekter.kapumgr.draw(content, c);
		
		//System.out.println("-----------");
		for (int i=0;i<jatekter.getWidth(); i++){
			//System.out.print("|");
			for (int j=0;j<jatekter.getHeight();j++){
				//System.out.print(palya[j][i]);
				if (palya[i][j]==' '){
					c.gridx=i;
					c.gridy=j;
					JLabel uj = new JLabel();
					uj.setIcon(icon);
					content.add(uj,c);
				}
			}
			//System.out.println("|");
		}
		//System.out.println("-----------");

		content.repaint();
		panel.add(content,BorderLayout.CENTER);
		//frame.add(panel,BorderLayout.CENTER);
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
					Jatek.NewGame("bin/blitz.txt");
				}
				//Masodik Palya betoltese
				else if(e.getSource().equals(map2)){
					//!TODO MAP2 betoltese
					Jatek.NewGame("bin/Steal the box.txt");
				}
				//Harmadik palya betoltese
				else if(e.getSource().equals(map3)){
					//!TODO MAP3 betoltese
					Jatek.NewGame("bin/luck of the replicators.txt");
				}
				
				UpdateFrame();					//Ujra ki kell rajzolni a palyat
				
				
			}
		};
		
		
		keyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			//Ha lenyomtak egy billentyut, reagalunk ra
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W){
					Jatek.E.move(Irany.FEL);
				}
				else if(e.getKeyCode() == KeyEvent.VK_S){
					Jatek.E.move(Irany.LE);
				}
				else if(e.getKeyCode() == KeyEvent.VK_D){
					Jatek.E.move(Irany.JOBBRA);
				}
				else if(e.getKeyCode() == KeyEvent.VK_A){
					Jatek.E.move(Irany.BALRA);
				}
				else if(e.getKeyCode() == KeyEvent.VK_Q){
					Jatek.E.changeTolteny();
				}
				else if(e.getKeyCode() == KeyEvent.VK_E){
					if(Jatek.E.doboz == null){
						Jatek.E.lift();
					}
					else{
						Jatek.E.drop();
					}
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_V){
					try {
						Jatek.E.shoot();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
				else if(e.getKeyCode() == KeyEvent.VK_UP){
					Jatek.Jaffa.move(Irany.FEL);
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN){
					Jatek.Jaffa.move(Irany.LE);
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					Jatek.Jaffa.move(Irany.JOBBRA);
				}
				else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					Jatek.Jaffa.move(Irany.BALRA);
				}
				else if(e.getKeyCode() == KeyEvent.VK_M){
					Jatek.Jaffa.changeTolteny();
				}
				else if(e.getKeyCode() == KeyEvent.VK_COMMA){
					if(Jatek.Jaffa.doboz == null){
						Jatek.Jaffa.lift();
					}
					else{
						Jatek.Jaffa.drop();
					}
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_CONTROL && e.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT){
					try {
						Jatek.Jaffa.shoot();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
				
				
			}
		};
		
	}
	
	//Menubar inicializalasa
		public void InitMenuBar(){
			
			//Listenerek inicializalasa
			InitListeners();
			
			//Menubar letrehozasa
			menuBar = new JMenuBar();
			
			
			
			//Uj Jatek menuelem
			newGame = new JMenu("Új Játék");
			newGame.addMenuListener(menuListener);
			menuBar.add(newGame);
			
			//Palya 1 megnyitas
			map1 = new JMenuItem("1. Pálya");
			map1.addActionListener(actionListener);
			newGame.add(map1);
			
			//Palya 2 megnyitas
			map2 = new JMenuItem("2. Pálya");
			map2.addActionListener(actionListener);
			newGame.add(map2);
			
			//Palya 3 megnyitas
			map3 = new JMenuItem("3. Pálya");
			map3.addActionListener(actionListener);
			newGame.add(map3);
			
			//Kilepes menuelem letrehozas
			exit = new JMenu("Kilépés");
			exit.addMenuListener(menuListener);
			menuBar.add(exit);
			
			//JMenuBar felvetele a Framebe
			frame.setJMenuBar(menuBar);			
			
			//Jpanel teszt
			panel = new JPanel();	
			panel.addKeyListener(keyListener);
			panel.setFocusable(true);
			frame.add(panel);
			
		}
	
	public void Init(){
		frame = new JFrame("Csillagkapu");
		frame.setMinimumSize(new Dimension(700, 700));
		//frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setPreferredSize(new Dimension(600, 600));
		frame.setResizable(false);
		//panel.add(content,BorderLayout.CENTER);
		frame.add(panel,BorderLayout.CENTER);
		InitMenuBar();
		
		UpdateFrame();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void Update(){
		UpdateFrame();
		panel.revalidate();
		frame.revalidate();
	}
}