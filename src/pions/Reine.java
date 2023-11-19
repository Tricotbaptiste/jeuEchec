package pions;

import java.io.File;

import javax.swing.ImageIcon;

import utilitaire.*;
import vue.Plateau;

public class Reine extends Piece{
	public Reine(Couleur couleur,int numero,Coordonnees coor,Plateau pl) {
        super(couleur,numero,coor,pl);
        File f;
        if (this.getCouleur()== Couleur.BLANC) {
        	f = new File("src//image//reineBlanc.png");
        }
        else {
        	f = new File("src//image//reineNoir.png");
        }
        this.image.setIcon(resize(new ImageIcon(f.getAbsolutePath())));
    }

    public void setPossibilites() {      
    	for (int i=this.getPossibilites().size()-1;i>=0;i--) {
    		this.getPossibilites().remove(i);
    	}
        this.setPossibilitesColonne();
        this.setPossibilitesLigne();
        this.setPossibilitesDiagonales();        
    }
}
