package pions;

import java.io.File;

import javax.swing.ImageIcon;

import utilitaire.*;
import vue.Plateau;

public class Pion extends Piece{
	public Pion(Couleur couleur,int numero,Coordonnees coor,Plateau pl) {
        super(couleur,numero,coor,pl);
        File f;
        if (this.getCouleur()== Couleur.BLANC) {
        	f = new File("src//image//pionBlanc.png");
        	
        }
        else {
        	f = new File("src//image//pionNoir.png");
        }
        this.image.setIcon(resize(new ImageIcon(f.getAbsolutePath())));
    }
    public void setPossibilites(){
    	for (int i=this.getPossibilites().size()-1;i>=0;i--) {
    		this.getPossibilites().remove(i);
    	}
    	Coordonnees coor;
    	Piece p;
        if (this.getCouleur()==Couleur.BLANC) {
        	coor = new Coordonnees(this.getPos().getLigne()+1,this.getPos().getColonne());
        	if (coor.checkValide()){
        		if (this.plateau.getCase(coor).estVide()){
        			this.addPossibilites(coor);
        		}
        	}
        	if (this.getPos().getLigne()==2){
        		coor = new Coordonnees(this.getPos().getLigne()+2,this.getPos().getColonne());
        		if (this.plateau.getCase(coor).estVide()){
        			this.addPossibilites(coor);
        		}
        	}
        	coor = new Coordonnees(this.getPos().getLigne()+1,this.getPos().getColonne()+1);
        	if (coor.checkValide()){
        		if (!this.plateau.getCase(coor).estVide()){
        			p = this.plateau.getCase(coor).getPiece();
        			if (p.getCouleur()==Couleur.NOIR) {
        				this.addPossibilites(coor);
        			}
        		}
        	}
        	coor = new Coordonnees(this.getPos().getLigne()+1,this.getPos().getColonne()-1);
        	if (coor.checkValide()){
        		if (!this.plateau.getCase(coor).estVide()){
        			p = this.plateau.getCase(coor).getPiece();
        			if (p.getCouleur()==Couleur.NOIR) {
        				this.addPossibilites(coor);
        			}
        		}
        	}
        }
        else {
        	coor = new Coordonnees(this.getPos().getLigne()-1,this.getPos().getColonne());
        	if (coor.checkValide()) {
        		if (this.plateau.getCase(coor).estVide()){
        			this.addPossibilites(new Coordonnees(coor));
        		}
        	}
        	if (this.getPos().getLigne()==7){
        		coor = new Coordonnees(this.getPos().getLigne()-2,this.getPos().getColonne());
        		if (this.plateau.getCase(coor).estVide()){
        			this.addPossibilites(coor);
        		}
        	}
        	coor = new Coordonnees(this.getPos().getLigne()-1,this.getPos().getColonne()+1);
        	if (coor.checkValide()){
        		if (!this.plateau.getCase(coor).estVide()){
        			p = this.plateau.getCase(coor).getPiece();
        			if (p.getCouleur()==Couleur.BLANC) {
        				this.addPossibilites(coor);
        			}
        		}
        	}
        	coor = new Coordonnees(this.getPos().getLigne()-1,this.getPos().getColonne()-1);
        	if (coor.checkValide()){
        		if (!this.plateau.getCase(coor).estVide()){
        			p = this.plateau.getCase(coor).getPiece();
        			if (p.getCouleur()==Couleur.BLANC) {
        				this.addPossibilites(coor);
        			}
        		}
        	}
        }
    }
}
