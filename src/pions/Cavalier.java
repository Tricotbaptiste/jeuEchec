package pions;

import java.io.File;
import vue.Plateau;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import utilitaire.*;
public class Cavalier extends Piece{
	public Cavalier(Couleur couleur,int numero,Coordonnees coor,Plateau pl) {
        super(couleur,numero,coor,pl);
        setPossibilites();
        File f;
        if (this.getCouleur()== Couleur.BLANC) {
        	f = new File("src\\image\\cavalierBlanc.png");
        }
        else {
        	f = new File("src\\image\\cavalierNoir.png");
        }
        this.image.setIcon(resize(new ImageIcon(f.getAbsolutePath())));
        
    }

    public void setPossibilites() {
    	for (int i=this.getPossibilites().size()-1;i>=0;i--) {
    		this.getPossibilites().remove(i);
    	}

        Coordonnees coor = new Coordonnees(this.getPos().getLigne()+1,this.getPos().getColonne()-2);
        if (coor.checkValide() && (this.plateau.getCase(coor).estVide() || this.plateau.getCase(coor).getPiece().getCouleur()!=this.getCouleur())){
            this.addPossibilites(coor);
        }
        coor = new Coordonnees(this.getPos().getLigne()+2,this.getPos().getColonne()-1);
        if (coor.checkValide() && (this.plateau.getCase(coor).estVide() || this.plateau.getCase(coor).getPiece().getCouleur()!=this.getCouleur())){
            this.addPossibilites(coor);
        }
        coor = new Coordonnees(this.getPos().getLigne()+2,this.getPos().getColonne()+1);
        if (coor.checkValide() && (this.plateau.getCase(coor).estVide() || this.plateau.getCase(coor).getPiece().getCouleur()!=this.getCouleur())){
            this.addPossibilites(coor);
        }
        
        coor = new Coordonnees(this.getPos().getLigne()+1,this.getPos().getColonne()+2);
        if (coor.checkValide() && (this.plateau.getCase(coor).estVide() || this.plateau.getCase(coor).getPiece().getCouleur()!=this.getCouleur())){
            this.addPossibilites(coor);
        }
        coor = new Coordonnees(this.getPos().getLigne()-1,this.getPos().getColonne()+2);
        if (coor.checkValide() && (this.plateau.getCase(coor).estVide() || this.plateau.getCase(coor).getPiece().getCouleur()!=this.getCouleur())){
            this.addPossibilites(coor);
        }
        
        coor = new Coordonnees(this.getPos().getLigne()-2,this.getPos().getColonne()+1);
        if (coor.checkValide() && (this.plateau.getCase(coor).estVide() || this.plateau.getCase(coor).getPiece().getCouleur()!=this.getCouleur())){
            this.addPossibilites(coor);
        }
        
        coor = new Coordonnees(this.getPos().getLigne()-2,this.getPos().getColonne()-1);
        if (coor.checkValide() && (this.plateau.getCase(coor).estVide() || this.plateau.getCase(coor).getPiece().getCouleur()!=this.getCouleur())){
            this.addPossibilites(coor);
        }
        
        coor = new Coordonnees(this.getPos().getLigne()-1,this.getPos().getColonne()-2);
        if (coor.checkValide() && (this.plateau.getCase(coor).estVide() || this.plateau.getCase(coor).getPiece().getCouleur()!=this.getCouleur())){
            this.addPossibilites(coor);
        }
    }
}
