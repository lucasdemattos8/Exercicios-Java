package boardgame;

public class Piece {
	
	protected Position posicao;
	private Board tabuleiro;
	
	// Construtores
	
	public Piece(Board tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	// Getter
	
	protected Board getTabuleiro() {
		return tabuleiro;
	}
	
	

}
