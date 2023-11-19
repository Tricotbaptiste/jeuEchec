package pions;

import utilitaire.*;
import vue.Plateau;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Piece {
	private Couleur couleur;
    private int numero;
    private Coordonnees position;
    private ArrayList<Coordonnees> possibilites; 
    protected Plateau plateau;
    protected JLabel image= new JLabel();
    
    public Piece(Couleur couleur,int numero,Coordonnees coor,Plateau plateau){
        this.couleur=couleur;
        this.possibilites= new ArrayList();
        this.numero=numero;
        this.position=coor;
        this.plateau=plateau;
        setPossibilites();
    }
    public int getNumero() {
    	return this.numero;
    }
    public JLabel getImage() {
    	return this.image;
    }
    public Coordonnees getPos(){
        return this.position;
    }

    public ArrayList<Coordonnees> getPossibilites() {
        return possibilites;
    }
    public abstract void setPossibilites();
    public void setPos(Coordonnees coor){
        this.position=coor;
    }
    public void addPossibilites(Coordonnees c){
        this.possibilites.add(c);
    }
    public void supprPossibilites(Coordonnees c) {
    	this.possibilites.remove(c);
    }
    public Couleur getCouleur() {
        return couleur;
    }
    public Coordonnees getCoor() {
    	return this.position;
    }
    
    public ImageIcon resize(ImageIcon img)
	  {
		Image image = img.getImage();  
		Image newimg = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH); //redimensionne l'image a la taile d'une case  
		img = new ImageIcon(newimg); 
		return img;
	  }
    
    // recuperer les possibilites d'une piece sur les diagonales 
    public void setPossibilitesColonne() {
    	int i=this.getPos().getLigne()+1;
        int j=this.getPos().getColonne();
        Coordonnees coor = new Coordonnees(i,j);
        Piece p;
        while(i<9 && this.plateau.getCase(coor).estVide()){
            this.addPossibilites(coor);
            i++;
            coor= new Coordonnees(i,j);
        }
        if (coor.checkValide()) {
        	p =  this.plateau.getCase(coor).getPiece();
        	if (p.getCouleur()!=this.getCouleur()) {
        		this.addPossibilites(coor);
        	}
        }
        
        i=this.getPos().getLigne()-1;
        coor = new Coordonnees(i,j);
        while(i>0 && this.plateau.getCase(coor).estVide()){
            this.addPossibilites(coor);
            i--;
            coor= new Coordonnees(i,j);
        }
        if (coor.checkValide()) {
        	p =  this.plateau.getCase(coor).getPiece();
        	if (p.getCouleur()!=this.getCouleur()) {
        		this.addPossibilites(coor);
        	}
        }
    }
    
    // recuperer les possibilites d'une piece sur une ligne 
    
    public void setPossibilitesLigne() {
    	int i=this.getPos().getLigne();
        int j=this.getPos().getColonne()+1;
        Coordonnees coor = new Coordonnees(i,j);
        Piece p;
        while(j<9 && this.plateau.getCase(coor).estVide()){
            this.addPossibilites(coor);
            j++;
            coor= new Coordonnees(i,j);
        }
        if (coor.checkValide()) {
        	p =  this.plateau.getCase(coor).getPiece();
        	if (p.getCouleur()!=this.getCouleur()) {
        		this.addPossibilites(coor);
        	}
        }
        
        j=this.getPos().getColonne()-1;
        coor = new Coordonnees(i,j);
        while(j>0 && this.plateau.getCase(coor).estVide()){
            this.addPossibilites(coor);
            j--;
            coor= new Coordonnees(i,j);
        }
        if (coor.checkValide()) {
        	p =  this.plateau.getCase(coor).getPiece();
        	if (p.getCouleur()!=this.getCouleur()) {
        		this.addPossibilites(coor);
        	}
        }
    }
    
    //recuperer les possibilites d'une piece sur une colonne 
    
    public void setPossibilitesDiagonales() {
    	int i=this.getPos().getLigne()-1;
        int j=this.getPos().getColonne()-1;
        Coordonnees coor = new Coordonnees(i,j);
        Piece p;
        while(i>0 && j>0 && this.plateau.getCase(coor).estVide()){
            this.addPossibilites(coor);
            i--;
            j--;
            coor = new Coordonnees(i,j); 
        }
        if (coor.checkValide()) {
        	 p = this.plateau.getCase(coor).getPiece();
        	if (p.getCouleur()!= this.getCouleur()) {
        		this.addPossibilites(coor);
        	}
        }
        
        
        i=this.getPos().getLigne()+1;
        j=this.getPos().getColonne()-1;
        coor = new Coordonnees(i,j);
        while(i<9 && j>0 && this.plateau.getCase(coor).estVide()){
            this.addPossibilites(coor);
            i++;
            j--;
            coor = new Coordonnees(i,j);
            
        }
        
        if (coor.checkValide()) {
        	p = this.plateau.getCase(coor).getPiece();
        	if (p.getCouleur()!= this.getCouleur()) {
        		this.addPossibilites(coor);
        	}
        }
        
        i=this.getPos().getLigne()+1;
        j=this.getPos().getColonne()+1;
        coor = new Coordonnees(i,j);
        while(i<9 && j<9 && this.plateau.getCase(coor).estVide()){
            this.addPossibilites(coor);
            i++;
            j++;
            coor = new Coordonnees(i,j);
            
        }
        if (coor.checkValide()) {
        	p = this.plateau.getCase(coor).getPiece();
        	if (p.getCouleur()!= this.getCouleur()) {
        		this.addPossibilites(coor);
        	}
        }
        
        i=this.getPos().getLigne()-1;
        j=this.getPos().getColonne()+1;
        coor = new Coordonnees(i,j);
        while(i>0 && j<9 && this.plateau.getCase(coor).estVide()){
            this.addPossibilites(coor);
            i--;
            j++;
            coor = new Coordonnees(i,j);
            
        }
        if (coor.checkValide()) {
        	p = this.plateau.getCase(coor).getPiece();
        	if (p.getCouleur()!= this.getCouleur()) {
        		this.addPossibilites(coor);
        	}
        }
    }
}
