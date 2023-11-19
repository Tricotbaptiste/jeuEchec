package joueurs;

import pions.*;
import utilitaire.Coordonnees;
import utilitaire.Couleur;
import vue.Plateau;

import java.util.ArrayList;

public class Joueur {
	protected ArrayList<Piece> listePiece;
    private Couleur couleur;
    protected Plateau plateau;
    
    public Joueur(Couleur couleur,Plateau pl){
        this.couleur = couleur;
        this.plateau=pl;
        listePiece= new ArrayList();
        // creation de toute les pieces du plateau et ajotu de ces pieces dasn les listes des joueurs 
        if (couleur==Couleur.BLANC){
            for (int i=1;i<9;i++){
                listePiece.add(new Pion(couleur,i,new Coordonnees(2,i),this.plateau)); 
            }
            listePiece.add(new Fou(couleur,9,new Coordonnees(1,3),this.plateau));
            listePiece.add(new Fou(couleur,10,new Coordonnees(1,6),this.plateau));
            listePiece.add(new Cavalier(couleur,11,new Coordonnees(1,7),this.plateau));
            listePiece.add(new Cavalier(couleur,12,new Coordonnees(1,2),this.plateau));
            listePiece.add(new Tour(couleur,13,new Coordonnees(1,1),this.plateau));
            listePiece.add(new Tour(couleur,14,new Coordonnees(1,8),this.plateau));
            listePiece.add(new Reine(couleur,15,new Coordonnees(1,4),this.plateau));
            listePiece.add(new Roi(couleur,16,new Coordonnees(1,5),this.plateau));
        }
        else{
            for (int i=1;i<9;i++){
                listePiece.add(new Pion(couleur,i,new Coordonnees(7,i),this.plateau)); 
            }
            listePiece.add(new Fou(couleur,9,new Coordonnees(8,3),this.plateau));
            listePiece.add(new Fou(couleur,10,new Coordonnees(8,6),this.plateau));
            listePiece.add(new Cavalier(couleur,11,new Coordonnees(8,7),this.plateau));
            listePiece.add(new Cavalier(couleur,12,new Coordonnees(8,2),this.plateau));
            listePiece.add(new Tour(couleur,13,new Coordonnees(8,8),this.plateau));
            listePiece.add(new Tour(couleur,14,new Coordonnees(8,1),this.plateau));
            listePiece.add(new Reine(couleur,15,new Coordonnees(8,4),this.plateau));
            listePiece.add(new Roi(couleur,16,new Coordonnees(8,5),this.plateau));
        }
    }
    
    public void suprPiece(Piece p){
       listePiece.remove(p);
    }
    
    //recuperation d'une piece en fonction de son numero 
    public Piece getPiece(int i){
        for (Piece p : this.listePiece) {
    		if (p.getNumero()==i) {
    			return p;
    		}
    	}
    	return null;
    }
    
  //recuperation d'une piece en fonction de sa position  
    public Piece getPiece(Coordonnees coor) {
    	for (Piece p : this.listePiece) {
    		if (p.getCoor().compare(coor)) {
    			return p;
    		}
    	}
    	return null;
    }
    
    public ArrayList<Piece> getListe(){
        return this.listePiece;
    }
	
}
