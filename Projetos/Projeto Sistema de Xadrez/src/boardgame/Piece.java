package boardgame;

public abstract class Piece {
	
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
	
	// Métodos
	
	public abstract boolean[][] movimentosPossiveis();

	public boolean movimentoPossivel(Position posicao) {
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean verificarSeExisteMovimentosPossiveis() {
		boolean[][] mat = movimentosPossiveis();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
