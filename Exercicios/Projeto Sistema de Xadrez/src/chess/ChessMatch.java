package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.*;

public class ChessMatch {
	
	private int turno;
	private Color playerAtual;
	private Board tabuleiro;
	private boolean check;
	
	private List<Piece> pecasNoTabuleiro = new ArrayList<>();
	private List<Piece> pecasCapturadas = new ArrayList<>();
	
	// Construtor
	public ChessMatch() {
		tabuleiro = new Board(8, 8);
		turno = 1;
		playerAtual = Color.WHITE;
		setupInicial();
	}
	
	// Getter
	
	public int getTurno() {
		return turno;
	}
	
	public Color getPlayerAtual() {
		return playerAtual;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public String getStringOfPlayerAtual() {
		if (playerAtual == Color.valueOf("WHITE")) {
			return "BRANCAS";
		} else {
			return "PRETAS";
		}
	}
	
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
	
	public boolean[][] movimentosPossiveis(ChessPosition posicaoOrigem){
		Position posicao = posicaoOrigem.toPosition();
		validarPosicaoDeOrigem(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();
	}
	
	public ChessPiece performarMovimentoDeXadrez(ChessPosition posicaoOrigem, ChessPosition posicaoDestino) {
		Position origem = posicaoOrigem.toPosition();
		Position destino = posicaoDestino.toPosition();
		validarPosicaoDeOrigem(origem);
		validarPosicaoDeDestino(origem, destino);
		Piece pecaCapturada = movimentarPeca(origem, destino);
		
		if(testarCheck(playerAtual)) {
			desfazerMovimento(origem, destino, pecaCapturada);
			throw new ChessException("Voce não pode se colocar em check");
		}
		
		check = (testarCheck(oponente(playerAtual))) ?  true : false;
		
		proximoTurno();
		return (ChessPiece) pecaCapturada;
	}
	
	private Piece movimentarPeca(Position origem, Position destino) {
		Piece p = tabuleiro.removePiece(origem);
		Piece pecaCapturada = tabuleiro.removePiece(destino);
		tabuleiro.colocarPeca(p, destino);
		
		if (pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		
		return (ChessPiece) pecaCapturada;
	}
	
	private void desfazerMovimento(Position origem, Position destino, Piece pecaCapturada) {
		Piece p = tabuleiro.removePiece(destino);
		tabuleiro.colocarPeca(p, origem);
		
		if (pecaCapturada != null) {
			tabuleiro.colocarPeca(pecaCapturada, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
		}
	}
	
	private void validarPosicaoDeOrigem(Position posicao) {
		if(!tabuleiro.posicaoOcupada(posicao)) {
			throw new ChessException("Nao ha peça na posição de Origem");
		}
		if(playerAtual != ((ChessPiece)tabuleiro.peca(posicao)).getCor()) {
			throw new ChessException("A peca escolhida não é sua");
		}
		if(!tabuleiro.peca(posicao).verificarSeExisteMovimentosPossiveis()) {
			throw new ChessException("Nao ha movimentos possiveis para esta peça");
		}
	}
	
	private void validarPosicaoDeDestino(Position origem, Position destino) {
		if(!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			throw new ChessException("A peca escolhida não pode se mover para a posição de destino");
		}
	}
	
	private void proximoTurno() {
		turno++;
		playerAtual = (playerAtual == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}
	
	private Color oponente(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
 	}
	
	private ChessPiece king(Color cor) {
		List<Piece> list = pecasNoTabuleiro.stream().filter(x ->((ChessPiece) x).getCor() == cor).collect(Collectors.toList());
		for (Piece p : list) {
			if (p instanceof King) {
				return (ChessPiece)p;
			}
		}
		throw new IllegalStateException("Não existe rei " + cor + " no tabuleiro.");
	}
	
	private boolean testarCheck(Color cor) {
		Position kingPosition = king(cor).getChessPosition().toPosition();
		List<Piece> pecasOponentes = pecasNoTabuleiro.stream().filter(x ->((ChessPiece) x).getCor() == oponente(cor)).collect(Collectors.toList());
		for (Piece p : pecasOponentes) {
			boolean[][] mat = p.movimentosPossiveis();
			if (mat[kingPosition.getLinha()][kingPosition.getColuna()]) {
				return true;
			}
		}
		return false;
	}

	private void colocarNovaPeca(char coluna, int linha, ChessPiece peca) {
		tabuleiro.colocarPeca(peca, new ChessPosition(coluna, linha).toPosition());
		pecasNoTabuleiro.add(peca);
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
