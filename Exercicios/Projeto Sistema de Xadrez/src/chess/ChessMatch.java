package chess;

import boardgame.Board;
import boardgame.Position;
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
	
	private void setupInicial() {
		tabuleiro.colocarPeca(new Rook(tabuleiro, Color.WHITE), new Position(2, 1));
		tabuleiro.colocarPeca(new King(tabuleiro, Color.BLACK), new Position(7, 4));
		tabuleiro.colocarPeca(new King(tabuleiro, Color.WHITE), new Position(0, 4));
	}
}
