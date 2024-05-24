package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch partidaDeXadrez;
	
	public Pawn(Board tabuleiro, Color cor, ChessMatch partidaDeXadrez) {
		super(tabuleiro, cor);
		this.partidaDeXadrez = partidaDeXadrez;
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getLinhas()];
		
		Position p = new Position(0, 0);
		
		if (getCor() == Color.WHITE) {
			p.setValues(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().posicaoOcupada(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha() - 2, posicao.getColuna());
			Position p2 = new Position(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) &&  !getTabuleiro().posicaoOcupada(p) 
					&& getTabuleiro().posicaoExiste(p2) &&  !getTabuleiro().posicaoOcupada(p2) 
					&& getContadorDeMovimentos() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(p) && existeUmaPecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(p) && existeUmaPecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			// # Movimento especial en Passant White
			if (posicao.getLinha() == 3) {
				Position esquerda = new Position(posicao.getLinha(), posicao.getColuna() - 1);
				if (getTabuleiro().posicaoExiste(esquerda) && existeUmaPecaOponente(esquerda) && getTabuleiro().peca(esquerda) == partidaDeXadrez.getVulneravelParaEnPassant()) {
					mat[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
				}
				Position direita = new Position(posicao.getLinha(), posicao.getColuna() + 1);
				if (getTabuleiro().posicaoExiste(direita) && existeUmaPecaOponente(direita) && getTabuleiro().peca(direita) == partidaDeXadrez.getVulneravelParaEnPassant()) {
					mat[direita.getLinha() - 1][direita.getColuna()] = true;
				}
			}
		}
		else {
			p.setValues(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().posicaoOcupada(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha() + 2, posicao.getColuna());
			Position p2 = new Position(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) &&  !getTabuleiro().posicaoOcupada(p) 
					&& getTabuleiro().posicaoExiste(p2) &&  !getTabuleiro().posicaoOcupada(p2) 
					&& getContadorDeMovimentos() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(p) && existeUmaPecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(p) && existeUmaPecaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			// # Movimento especial en Passant Black
			if (posicao.getLinha() == 4) {
				Position esquerda = new Position(posicao.getLinha(), posicao.getColuna() - 1);
				if (getTabuleiro().posicaoExiste(esquerda) && existeUmaPecaOponente(esquerda) && getTabuleiro().peca(esquerda) == partidaDeXadrez.getVulneravelParaEnPassant()) {
					mat[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
				}
				Position direita = new Position(posicao.getLinha(), posicao.getColuna() + 1);
				if (getTabuleiro().posicaoExiste(direita) && existeUmaPecaOponente(direita) && getTabuleiro().peca(direita) == partidaDeXadrez.getVulneravelParaEnPassant()) {
					mat[direita.getLinha() + 1][direita.getColuna()] = true;
				}
			}
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
