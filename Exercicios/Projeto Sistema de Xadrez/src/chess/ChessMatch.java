package chess;

import boardgame.Board;
import chess.pieces.*;

public class ChessMatch {
	
	private Board tabuleiro;
	
	
	// Construtor
	public ChessMatch() {
		tabuleiro = new Board(8, 8);
		setupInicial();
	}
	
	// Getter
	
	public ChessPiece[][] getPecas(){
		ChessPiece[][] mat = new ChessPiece[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				mat[i][j] = (ChessPiece) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	// Método

	private void colocarNovaPeca(char coluna, int linha, ChessPiece peca) {
		tabuleiro.colocarPeca(peca, new ChessPosition(coluna, linha).toPosition());
	}
	
	private void setupInicial() {
		colocarNovaPeca('b', 6, new Rook(tabuleiro, Color.WHITE));
		colocarNovaPeca('e', 8, new King(tabuleiro, Color.WHITE));
		colocarNovaPeca('e', 1, new King(tabuleiro, Color.BLACK));
	}
}
