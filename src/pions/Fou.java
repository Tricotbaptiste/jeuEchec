package pions;

import java.io.File;

import javax.swing.ImageIcon;

import utilitaire.*;
import vue.Plateau;

public class Fou extends Piece{
	public Fou(Couleur couleur,int numero,Coordonnees coor,Plateau pl) {
        super(couleur,numero,coor,pl);
        setPossibilites();
        File f;
        if (this.getCouleur()== Couleur.BLANC) {
        	f = new File("src//image//fouBlanc.png");
        }
        else {
        	f = new File("src//image//fouNoir.png");
        }
        this.image.setIcon(resize(new ImageIcon(f.getAbsolutePath())));
    }

    public void setPossibilites() {
    	for (int i=this.getPossibilites().size()-1;i>=0;i--) {
    		this.getPossibilites().remove(i);
    	} 
    	this.setPossibilitesDiagonales();
    	
        
    }
}
