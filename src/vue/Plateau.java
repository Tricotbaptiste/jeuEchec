package vue;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import joueurs.Bot;
import joueurs.Joueur;
import utilitaire.*;
import pions.*;
public class Plateau extends JFrame{
	
	private ArrayList<Case> listeCase = new ArrayList();
	private Joueur j1,j2;
	private Couleur tour=Couleur.BLANC;
	private boolean echecNoir,echecBlanc;
	
	Piece pieceSelec=null;
	Case depart=null;
	
	public Plateau() {
		this.setLayout(null);
		this.setSize(750,750);
		this.setBackground(new Color(0,0,0));
		this.setLocationRelativeTo(null);
		int x=75,y=75,compteur=0;
		
		//creation des cases du plateau 
		for(int i=8;i>0;i--) {
			for(int j=1;j<9;j++) {
				Coordonnees coor=new Coordonnees(i,j);
				Case c = new Case(coor);
				c.addMouseListener(new MouseListener(){
					@Override
					public void mouseClicked(MouseEvent e) {
						cliqueSouris(c);
					}
					@Override
					public void mousePressed(MouseEvent e) {
					}
					@Override
					public void mouseReleased(MouseEvent e) {
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						survolePiece(c);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						
					}
					}
				);
				this.listeCase.add(c);
				this.add(c);
				c.setVisible(true);
				c.setBounds(x,y,75,75);
				if (compteur%2==0) {
					c.setFond(new Color(0,255,0));
				}
				else {
					c.setFond(new Color(255,0,0));
				}
				compteur++;
				x+=75;
			}
			compteur++;
			y+=75;
			x=75;
		}

		//creation des joueurs 
		j1 = new Joueur(Couleur.BLANC,this);
		// on demande au joueur s'il veut jouer contre un bot 
		int reponse =JOptionPane.showConfirmDialog(this,"test", "souhaitez vous jouez contre un bot ? ",JOptionPane.YES_NO_OPTION);
		
		if (reponse==JOptionPane.YES_OPTION) {
			j2 = new Bot(this,1);
		}
		else {
			j2 = new Joueur(Couleur.NOIR,this);
		}
		//ajout des pieces aux cases  
		for(int i=8;i>0;i--) {
			for(int j=1;j<9;j++) {
				Coordonnees coor = new Coordonnees(i,j);
				Case c = this.getCase(coor);
				switch(i) {
					case 8:
						c.setPiece(j2.getPiece(coor));
						break;
					case 7:
						c.setPiece(j2.getPiece(coor));
						break;
					case 2:
						c.setPiece(j1.getPiece(coor));
						break;
					case 1:
						c.setPiece(j1.getPiece(coor));
						break;
					default :
						
				}
				
			}

		}
		refresh();
		this.setVisible(true);
	}
	
	
	
	public void setDepart(Case c){
		this.depart=c;
	}
	
	public Case getCase(Coordonnees coor) {
		for (Case c : listeCase) {
			if (c.getCoor().compare(coor)) {
				return c;
			}
		}
		return null;
	}
	
	public void cliqueSouris(Case c) {
		int mouvPossible=0;
		if (pieceSelec==null && !c.estVide() && c.getPiece().getCouleur()==this.tour){
			pieceSelec=c.getPiece();
			depart=c;
			depart.setBackground(new Color(255,255,255));
			
		}
		else if(pieceSelec!=null) {	
			for (Coordonnees coor : pieceSelec.getPossibilites()) {
				if(coor.compare(c.getCoor())) {
					mouvPossible=1; 
				}
			}
			if (mouvPossible==1) {
				deplacementPiece(pieceSelec,c);
				refresh();
				tourSuivant();
			}
			depart.setBackground(depart.getFond());
			pieceSelec=null;
			depart=null;
			
		}
	}
	
	public void deplacementPiece(Piece p,Case c) {
		if (!c.estVide()) {
			if(c.getPiece().getCouleur()==Couleur.BLANC) {
				j1.suprPiece(c.getPiece());
			}else {
				j2.suprPiece(c.getPiece());
			}
		}
		c.setPiece(p);
		p.setPos(c.getCoor());
		depart.suprPiece();
		
	}
	
	public void refresh() {
		Coordonnees coor;
		//parcours de toute les cases pour actualiser les images des cases 
		for (Case c : this.listeCase) { 
			c.setBackground(c.getFond());
			if(c.getPiece()!=null) {
				c.getImage().setIcon(c.getPiece().getImage().getIcon());
			}
			else {
				c.getImage().setIcon(null);
			}
		}
		if (j2.getPiece(16)==null ) {// test si le roi nori est toujours en vie 
			JOptionPane.showMessageDialog(this, "Victoire des Blancs !! ");
			System.exit(0);
		}
		coor = j2.getPiece(16).getCoor();// recuperation des coordonnees du roi noir 
		for (Piece p : this.j1.getListe()) {
			p.setPossibilites(); // actualisation des possibilites des pieces 
			for (Coordonnees c : p.getPossibilites()) { // parcours de toutes les possibilités des pièces blanches pour voir si le roi noir est menacé
				if(c.compare(coor)) {
					JOptionPane.showMessageDialog(this, "Les noirs sont en échecs");
					break;
				}
			}
			
		}
		// même chose pour le roi blanc 
		if (j1.getPiece(16)==null ) {// test si le roi nori est toujours en vie 
			JOptionPane.showMessageDialog(this, "Victoire des Noirs  !! ");
			System.exit(0);
		}
		coor = j1.getPiece(16).getCoor(); 
		for (Piece p : this.j2.getListe()) {
			p.setPossibilites();
			for (Coordonnees c : p.getPossibilites()) {
				if(c.compare(coor)) {
					JOptionPane.showMessageDialog(this, "Les blancs sont en échecs");
					break;
				}
			}
			
		}
	}
	public void survolePiece(Case c) {
		// on teste si la case survolée contient une piece : si c'est le cas et qu'il n'y a pas de pièce déjà sélectionnée, on change le curseur de la souris
		if (!c.estVide() && pieceSelec==null && c.getPiece().getCouleur()==this.tour) {  
			c.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		else {
			c.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}
	public void tourSuivant() {
		if(tour==Couleur.BLANC) {
			tour=Couleur.NOIR;
			if (j2.getClass().getSimpleName().compareTo("Bot")==0) {
				((Bot) j2).genererCoupRandom();
			}
		}
		else {
			tour=Couleur.BLANC;
		}
	}
}
