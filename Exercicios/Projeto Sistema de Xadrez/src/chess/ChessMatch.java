package chess;

import boardgame.Board;
import boardgame.Piece;
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
	
	public ChessPiece performarMovimentoDeXadrez(ChessPosition posicaoOrigem, ChessPosition posicaoDestino) {
		Position origem = posicaoOrigem.toPosition();
		Position destino = posicaoDestino.toPosition();
		validarPosicaoDeOrigem(origem);
		Piece pecaCapturada = movimentarPeca(origem, destino);
		return (ChessPiece) pecaCapturada;
	}
	
	public Piece movimentarPeca(Position origem, Position destino) {
		Piece p = tabuleiro.removePiece(origem);
		Piece pecaCapturada = tabuleiro.removePiece(destino);
		tabuleiro.colocarPeca(p, destino);
		return (ChessPiece) pecaCapturada;
	}
	
	private void validarPosicaoDeOrigem(Position posicao) {
		if(!tabuleiro.posicaoOcupada(posicao)) {
			throw new ChessException("Nao ha peça na posição de Origem");
		}
		if(!tabuleiro.peca(posicao).verificarSeExisteMovimentosPossiveis()) {
			throw new ChessException("Nao ha movimentos possiveis para esta peça");
		}
	}

	private void colocarNovaPeca(char coluna, int linha, ChessPiece peca) {
		tabuleiro.colocarPeca(peca, new ChessPosition(coluna, linha).toPosition());
	}
	
	private void setupInicial() {
		colocarNovaPeca('c', 1, new Rook(tabuleiro, Color.WHITE));
		colocarNovaPeca('c', 2, new Rook(tabuleiro, Color.WHITE));
		colocarNovaPeca('d', 2, new Rook(tabuleiro, Color.WHITE));
		colocarNovaPeca('e', 2, new Rook(tabuleiro, Color.WHITE));
		colocarNovaPeca('e', 1, new Rook(tabuleiro, Color.WHITE));
		colocarNovaPeca('d', 1, new King(tabuleiro, Color.WHITE));

		colocarNovaPeca('c', 7, new Rook(tabuleiro, Color.BLACK));
		colocarNovaPeca('c', 8, new Rook(tabuleiro, Color.BLACK));
		colocarNovaPeca('d', 7, new Rook(tabuleiro, Color.BLACK));
		colocarNovaPeca('e', 7, new Rook(tabuleiro, Color.BLACK));
		colocarNovaPeca('e', 8, new Rook(tabuleiro, Color.BLACK));
		colocarNovaPeca('d', 8, new King(tabuleiro, Color.BLACK));
	}
}
