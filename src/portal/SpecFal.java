package portal;

import java.awt.Graphics;

public class SpecFal extends Fal {
    
    /* Konstruktor
     * Az SPECFAL inicializalasa x, y koordinatakkal
     * Meghivja az os (FAL) konstruktorat
     */
    Csillagkapu kapuKezelo;
    
    public SpecFal(int x, int y, Csillagkapu ez) {
        super(x,y);
        kapuKezelo = ez;
    }
    
    public void ertesit_shoot(Tolteny t){
        kapuKezelo.SetCsk(this, t.getColor());
        t.destroy();
    }

    public Pont getTeleportPos(){
        return this.position;
    }
    
    //A Kapukezel�h�z fordulunk, aki a mi poz�ci�nk alapj�n visszadja,
    //hogy v�g�l hova ker�l a szerepl�
    public Pont ertesit(Pont regi, Szereplo sz){
        return kapuKezelo.checkCsk(this, regi);
    }
    
    @Override
    public void draw(Graphics g){
		//TODO!!!
	}
}