package utilitaire;

public class MouvementPieceException extends Exception {
	public MouvementPieceException() {
		super("Cette piece ne peut pas bouger");
	}
}
