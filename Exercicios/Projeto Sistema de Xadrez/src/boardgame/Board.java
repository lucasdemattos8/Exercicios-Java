package boardgame;

public class Board {
	
	private int linhas;
	private int colunas;
	private Piece[][] pecas;
	
	// Construtor
	
	public Board(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Piece[linhas][colunas];
	}
	
	// Getters e Setters

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
	// Métodos
	
	public Piece peca(int row, int column) {
		return pecas[row][column];
	}
	
	public Piece peca(Position position) {
		return pecas[position.getLinha()][position.getColuna()];
	}
	
	public void colocarPeca(Piece peca, Position posicao) {
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
}
