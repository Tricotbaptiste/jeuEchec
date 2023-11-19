package utilitaire;

import java.awt.Color;

import javax.swing.JLabel;

import javax.swing.JPanel;

import pions.Piece;

public class Case  extends JPanel{
	
		private Coordonnees coor;
		private Piece piece=null;
		private Color fond;
		private JLabel image = new JLabel();
		
		
		public Case(Coordonnees coor) {
			this.piece=null;
			this.add(this.image);
			this.image.setVisible(true);
			this.coor=coor;
		}
		
		public void setPiece(Piece p) {
			this.piece=p;
			image.setIcon(this.piece.getImage().getIcon());
			this.add(image);
		}
		public Piece getPiece() {
			return this.piece;
		}
		public Coordonnees getCoor() {
			return this.coor;
		}
		public void suprPiece() {
			this.piece=null;
		}
		public JLabel getImage() {
			return this.image;
		}
		public boolean estVide() {
			return this.piece==null;
		}
		public void setFond(Color c) {
			this.fond=c;
		}
		public Color getFond() {
			return this.fond;
		}
	}
