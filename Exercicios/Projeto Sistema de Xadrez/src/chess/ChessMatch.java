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
	private boolean checkMate;
	private ChessPiece vulneravelParaEnPassant;
	
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
	
	public boolean getCheckMate() {
		return checkMate;
	}
	
	public ChessPiece getVulneravelParaEnPassant(){
		return vulneravelParaEnPassant;
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
		
		ChessPiece pecaMovida = (ChessPiece)tabuleiro.peca(destino);
		
		check = (testarCheck(oponente(playerAtual))) ?  true : false;
		
		if (testarCheckMate(oponente(playerAtual))) {
			checkMate = true;
		}
		else {
			proximoTurno();
		}
		
		// # Movimento especial en Passant
		if (pecaMovida instanceof Pawn && (destino.getLinha() == origem.getLinha() - 2 || destino.getLinha() == origem.getLinha() + 2)) {
			vulneravelParaEnPassant = pecaMovida;
		}
		else {
			vulneravelParaEnPassant = null;
		}
		
		return (ChessPiece) pecaCapturada;
	}
	
	private Piece movimentarPeca(Position origem, Position destino) {
		ChessPiece p = (ChessPiece) tabuleiro.removePiece(origem);
		p.aumentarContador();
		Piece pecaCapturada = tabuleiro.removePiece(destino);
		tabuleiro.colocarPeca(p, destino);
		
		if (pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		
		// # Movimento especial lado do rei (Rook)
		if (p instanceof King && destino.getColuna() == origem.getColuna() + 2) {
			Position origemT = new Position(origem.getLinha(), origem.getColuna() + 3);
			Position destinoT = new Position(origem.getLinha(), origem.getColuna() + 1);
			ChessPiece torre = (ChessPiece)tabuleiro.removePiece(origemT);
			tabuleiro.colocarPeca(torre, destinoT);
			torre.aumentarContador();
		}
		
		// # Movimento especial lado da rainha (Rook)
		if (p instanceof King && destino.getColuna() == origem.getColuna() - 2) {
			Position origemT = new Position(origem.getLinha(), origem.getColuna() - 4);
			Position destinoT = new Position(origem.getLinha(), origem.getColuna() - 1);
			ChessPiece torre = (ChessPiece)tabuleiro.removePiece(origemT);
			tabuleiro.colocarPeca(torre, destinoT);
			torre.aumentarContador();
		}
		
		// # Movimento especial En Passant (Peão)
		
		if (p instanceof Pawn) {
			if (origem.getColuna() != destino.getColuna() && pecaCapturada == null) {
				Position posicaoPeao;
				if (p.getCor() == Color.WHITE) {
					posicaoPeao = new Position(destino.getLinha() + 1, destino.getColuna());
				}
				else {
					posicaoPeao = new Position(destino.getLinha() - 1, destino.getColuna());
				}
				pecaCapturada = tabuleiro.removePiece(posicaoPeao);
				pecasCapturadas.add(pecaCapturada);
				pecasNoTabuleiro.remove(pecaCapturada);
			}
		}
		
		return (ChessPiece) pecaCapturada;
	}
	
	private void desfazerMovimento(Position origem, Position destino, Piece pecaCapturada) {
		ChessPiece p = (ChessPiece)tabuleiro.removePiece(destino);
		p.reduzirContador();
		tabuleiro.colocarPeca(p, origem);
		
		if (pecaCapturada != null) {
			tabuleiro.colocarPeca(pecaCapturada, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
		}
	
		// # Movimento especial lado do rei (Rook)
		if (p instanceof King && destino.getColuna() == origem.getColuna() + 2) {
			Position origemT = new Position(origem.getLinha(), origem.getColuna() + 3);
			Position destinoT = new Position(origem.getLinha(), origem.getColuna() + 1);
			ChessPiece torre = (ChessPiece)tabuleiro.removePiece(destinoT);
			tabuleiro.colocarPeca(torre, origemT);
			torre.reduzirContador();
		}
		
		// # Movimento especial lado da rainha (Rook)
		if (p instanceof King && destino.getColuna() == origem.getColuna() - 2) {
			Position origemT = new Position(origem.getLinha(), origem.getColuna() - 4);
			Position destinoT = new Position(origem.getLinha(), origem.getColuna() - 1);
			ChessPiece torre = (ChessPiece)tabuleiro.removePiece(destinoT);
			tabuleiro.colocarPeca(torre, origemT);
			torre.reduzirContador();
		}
		
		// # Movimento especial En Passant (Peão)
		if (p instanceof Pawn) {
			if (origem.getColuna() != destino.getColuna() && pecaCapturada == vulneravelParaEnPassant) {
				Position posicaoPeao;
				ChessPiece peao = (ChessPiece)tabuleiro.removePiece(destino);
				if (p.getCor() == Color.WHITE) {
					posicaoPeao = new Position(destino.getLinha() + 1, destino.getColuna());
				}
				else {
					posicaoPeao = new Position(destino.getLinha() - 1, destino.getColuna());
				}
				tabuleiro.colocarPeca(peao, posicaoPeao);
			}
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
	
	private boolean testarCheckMate(Color cor) {
		if (!testarCheck(cor)) {
			return false;
		}
		List<Piece> list = pecasNoTabuleiro.stream().filter(x ->((ChessPiece) x).getCor() == cor).collect(Collectors.toList());
		for (Piece p : list) {
			boolean[][] mat = p.movimentosPossiveis();
			for (int i = 0; i < tabuleiro.getLinhas(); i++) {
				for (int j = 0; j < tabuleiro.getLinhas(); j++) {
					if(mat[i][j]) {
						Position origem = ((ChessPiece)p).getChessPosition().toPosition();
						Position destino = new Position(i, j);
						Piece pecaCapturada = movimentarPeca(origem, destino);
						boolean testarCheck = testarCheck(cor);
						desfazerMovimento(origem, destino, pecaCapturada);
						if (!testarCheck) {
							return false;
						}
					}				
				}
			}
		}
		return true;
	}

	private void colocarNovaPeca(char coluna, int linha, ChessPiece peca) {
		tabuleiro.colocarPeca(peca, new ChessPosition(coluna, linha).toPosition());
		pecasNoTabuleiro.add(peca);
	}
	
	private void setupInicial() {
		colocarNovaPeca('a', 1, new Rook(tabuleiro, Color.WHITE));
		colocarNovaPeca('b', 1, new Knight(tabuleiro, Color.WHITE));
		colocarNovaPeca('g', 1, new Knight(tabuleiro, Color.WHITE));
		colocarNovaPeca('c', 1, new Bishop(tabuleiro, Color.WHITE));
		colocarNovaPeca('d', 1, new Queen(tabuleiro, Color.WHITE));
		colocarNovaPeca('f', 1, new Bishop(tabuleiro, Color.WHITE));
		colocarNovaPeca('e', 1, new King(tabuleiro, Color.WHITE, this));
		colocarNovaPeca('h', 1, new Rook(tabuleiro, Color.WHITE));
		colocarNovaPeca('a', 2, new Pawn(tabuleiro, Color.WHITE, this));
		colocarNovaPeca('b', 2, new Pawn(tabuleiro, Color.WHITE, this));
		colocarNovaPeca('c', 2, new Pawn(tabuleiro, Color.WHITE, this));
		colocarNovaPeca('d', 2, new Pawn(tabuleiro, Color.WHITE, this));
		colocarNovaPeca('e', 2, new Pawn(tabuleiro, Color.WHITE, this));
		colocarNovaPeca('f', 2, new Pawn(tabuleiro, Color.WHITE, this));
		colocarNovaPeca('g', 2, new Pawn(tabuleiro, Color.WHITE, this));
		colocarNovaPeca('h', 2, new Pawn(tabuleiro, Color.WHITE, this));
		
		colocarNovaPeca('a', 8, new Rook(tabuleiro, Color.BLACK));
		colocarNovaPeca('b', 8, new Knight(tabuleiro, Color.BLACK));
		colocarNovaPeca('g', 8, new Knight(tabuleiro, Color.BLACK));
		colocarNovaPeca('c', 8, new Bishop(tabuleiro, Color.BLACK));
		colocarNovaPeca('d', 8, new Queen(tabuleiro, Color.BLACK));
		colocarNovaPeca('f', 8, new Bishop(tabuleiro, Color.BLACK));
		colocarNovaPeca('e', 8, new King(tabuleiro, Color.BLACK, this));
		colocarNovaPeca('h', 8, new Rook(tabuleiro, Color.BLACK));
		colocarNovaPeca('a', 7, new Pawn(tabuleiro, Color.BLACK, this));
		colocarNovaPeca('b', 7, new Pawn(tabuleiro, Color.BLACK, this));
		colocarNovaPeca('c', 7, new Pawn(tabuleiro, Color.BLACK, this));
		colocarNovaPeca('d', 7, new Pawn(tabuleiro, Color.BLACK, this));
		colocarNovaPeca('e', 7, new Pawn(tabuleiro, Color.BLACK, this));
		colocarNovaPeca('f', 7, new Pawn(tabuleiro, Color.BLACK, this));
		colocarNovaPeca('g', 7, new Pawn(tabuleiro, Color.BLACK, this));
		colocarNovaPeca('h', 7, new Pawn(tabuleiro, Color.BLACK, this));

	}
}
