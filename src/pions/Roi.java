package pions;

import java.io.File;

import javax.swing.ImageIcon;

import utilitaire.*;
import vue.Plateau;

public class Roi extends Piece{
	public Roi(Couleur couleur,int numero,Coordonnees coor,Plateau pl) {
        super(couleur,numero,coor,pl);
        setPossibilites();
        File f;
        if (this.getCouleur()== Couleur.BLANC) {
        	f = new File("src//image//roiBlanc.png");
        }
        else {
        	f = new File("src//image//roiNoir.png");
        }
        this.image.setIcon(resize(new ImageIcon(f.getAbsolutePath())));

    }
    public void setPossibilites(){
    	for (int i=this.getPossibilites().size()-1;i>=0;i--) {
    		this.getPossibilites().remove(i);
    	}
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Coordonnees coor=new Coordonnees(this.getPos().getLigne()+i-1,this.getPos().getColonne()+j-1);
                if (coor.checkValide()){
                    if (this.plateau.getCase(coor).estVide()) {
                    	this.addPossibilites(coor);
                    }
                    else {
                    	if(this.plateau.getCase(coor).getPiece().getCouleur()!= this.getCouleur()) {
                    		this.addPossibilites(coor);
                    	}
                    }
                }
            }
        }        
    }
}
