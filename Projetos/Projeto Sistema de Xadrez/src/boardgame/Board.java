package boardgame;

public class Board {
	
	private int linhas;
	private int colunas;
	private Piece[][] pecas;
	
	// Construtor
	
	public Board(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new BoardException(
					"Erro criando tabuleiro: É necessário que haja pelo menos 1 linha e 1 coluna");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Piece[linhas][colunas];
	}
	
	// Getters e Setters

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	// Métodos
	
	public Piece peca(int linha, int coluna) {
		if(!posicaoExiste(linha, coluna)) {
			throw new BoardException("Posição não encontrada no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Piece peca(Position posicao) {
		if(!posicaoExiste(posicao)) {
			throw new BoardException("Posição não encontrada no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocarPeca(Piece peca, Position posicao) {
		if(posicaoOcupada(posicao)) {
			throw new BoardException("Posição já ocupada com uma peça [" + posicao + "].");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Piece removePiece(Position posicao) {
		if (!posicaoExiste(posicao)) {
			throw new BoardException("Posição não encontrada no tabuleiro");
		}
		if (peca(posicao) == null) {
			return null;
		}
		Piece aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return aux;
	}
	
	private boolean posicaoExiste(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean posicaoExiste(Position posicao) {
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean posicaoOcupada(Position posicao) {
		if(!posicaoExiste(posicao)) {
			throw new BoardException("Posição não encontrada no tabuleiro");
		}
		return peca(posicao) != null;
	}
}
