package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	private ChessMatch partidaDeXadrez;

	public King(Board tabuleiro, Color cor, ChessMatch partidaDeXadrez) {
		super(tabuleiro, cor);
		this.partidaDeXadrez = partidaDeXadrez;
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean podeMovimentar(Position posicao) {
		ChessPiece p = (ChessPiece)getTabuleiro().peca(posicao);
		return p == null || p.getCor() != getCor();
	}
	
	private boolean testarRookApto(Position posicao) {
		ChessPiece p = (ChessPiece)getTabuleiro().peca(posicao);
		return p != null && p instanceof Rook && p.getCor() == getCor() && p.getContadorDeMovimentos() == 0;
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Position p = new Position(0, 0);
		
		// Para cima ⬆
		p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		if (getTabuleiro().posicaoExiste(p) && podeMovimentar(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Para baixo ⬇
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		if (getTabuleiro().posicaoExiste(p) && podeMovimentar(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Para esquerda ⬅
		p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMovimentar(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Para direita ➡ 
		p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMovimentar(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Para ESQUERDA-CIMA (NW) ↖
		p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMovimentar(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Para DIREITA-CIMA (NE) ↗
		p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMovimentar(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Para ESQUERDA-BAIXO (SW) ↙
		p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMovimentar(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Para ESQUERDA-BAIXO (SE) 
		p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMovimentar(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// # Movimento especial Rook
		if (getContadorDeMovimentos() == 0 && !partidaDeXadrez.getCheck()) {
			// # Rook para o lado do rei (Menor)
			Position posT1 = new Position(posicao.getLinha(), posicao.getColuna() + 3);
			if (testarRookApto(posT1)) {
				Position p1 = new Position(posicao.getLinha(), posicao.getColuna() + 1);
				Position p2 = new Position(posicao.getLinha(), posicao.getColuna() + 2);
				if (getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null) {
					mat[posicao.getLinha()][posicao.getColuna() + 2] = true;
				}
			}
			// # Rook para o lado do rei (Menor)
			Position posT2 = new Position(posicao.getLinha(), posicao.getColuna() - 4);
			if (testarRookApto(posT2)) {
				Position p1 = new Position(posicao.getLinha(), posicao.getColuna() - 1);
				Position p2 = new Position(posicao.getLinha(), posicao.getColuna() - 2);
				Position p3 = new Position(posicao.getLinha(), posicao.getColuna() - 3);
				if (getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null && getTabuleiro().peca(p3) == null) {
					mat[posicao.getLinha()][posicao.getColuna() - 2] = true;
				}
			}
			
			
		}
		
		return mat;
	}
	
}
