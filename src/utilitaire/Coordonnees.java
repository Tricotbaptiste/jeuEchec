package utilitaire;

public class Coordonnees {
	
	private int ligne;
    private int colonne;
    
    public Coordonnees(int ligne, int colonne){
        this.ligne=ligne;
        this.colonne=colonne;
        
    }
    public Coordonnees(Coordonnees coor){
        this.ligne=coor.getLigne();
        this.colonne=coor.getColonne();
    }
    public int getLigne() {
        return ligne;
    }
    public int getColonne() {
        return colonne;
    }
    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }
    public String toString() {
    	return "ligne :"+this.ligne+" colonne : "+ this.colonne;
    }
    public boolean checkValide(){
        if(this.getColonne()>0 && this.getColonne()<9 && this.getLigne()>0 && this.getLigne()<9){
            return true;
        }
        return false;
    }
    public boolean compare(Coordonnees c) {
    	if (this.ligne==c.getLigne() && this.colonne==c.getColonne()) {
    		return true;
    	}
    	return false;
    }
}
