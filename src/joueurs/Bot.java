package joueurs;

import pions.Piece;
import utilitaire.Couleur;
import vue.Plateau;

public class Bot extends Joueur{
	
	// cet entier sera utilisé lorsque des niveaux de difficultés seront ajoutés pour le bot 
    private int niveauDif;

    public Bot(Plateau pl,int niv){
        super(Couleur.NOIR,pl);
        this.niveauDif=niv;
    }
    public void genererCoupRandom(){
		Piece p;
		// selection d'une piece au hasard : on recommence tant que la piece selectionner ne peut pas bouger
        int selecPiece = (int) (Math.random()*(this.listePiece.size()));
        p = this.listePiece.get(selecPiece);
        while (p.getPossibilites().size()==0) {
        	int selecPiece2 = (int) (Math.random()*(this.listePiece.size()));
            p = this.listePiece.get(selecPiece2);
        }
        // on selectionne maintenant au hasard une des possibilites de la piece pour la deplacer 
        int coup = (int) (Math.random()*(p.getPossibilites().size()));
        this.plateau.setDepart(plateau.getCase(p.getCoor()));
        this.plateau.deplacementPiece(p,plateau.getCase(p.getPossibilites().get(coup)));
        this.plateau.refresh();
        this.plateau.tourSuivant();
    }
}