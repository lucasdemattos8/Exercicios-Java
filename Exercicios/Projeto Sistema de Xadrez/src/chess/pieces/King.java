package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board tabuleiro, Color cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean podeMovimentar(Position posicao) {
		ChessPiece p = (ChessPiece)getTabuleiro().peca(posicao);
		return p == null || p.getCor() != getCor();
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
		
		return mat;
	}
	
}
