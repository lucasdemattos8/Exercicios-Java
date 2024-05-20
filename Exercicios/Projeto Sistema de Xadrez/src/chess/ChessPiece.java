package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece{
	
	private Color cor;

	public ChessPiece(Board tabuleiro, Color cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Color getCor() {
		return cor;
	}
	
	protected boolean existeUmaPecaOponente(Position position){
		ChessPiece p = (ChessPiece)getTabuleiro().peca(position);
		return p != null && p.getCor() != cor;
	}
}
