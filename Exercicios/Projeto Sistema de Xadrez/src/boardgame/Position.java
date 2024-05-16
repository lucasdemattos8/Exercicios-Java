package boardgame;

public class Position {
	
	private int linha;
	private int coluna;
	
	// Construtores
	
	public Position(int linha, int column) {
		this.linha = linha;
		this.coluna = column;
	}
	
	// Getters e Setters

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int column) {
		this.coluna = column;
	}
	
	// Métodos
	
	@Override
	public String toString() {
		return linha + ", " + coluna;
	}

}
