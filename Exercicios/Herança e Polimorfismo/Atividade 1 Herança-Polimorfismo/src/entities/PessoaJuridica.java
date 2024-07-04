package entities;

public class PessoaJuridica extends Pessoa{
	
	int numeroDeFuncionarios;
	
	// Construtores
	
	public PessoaJuridica() {
	}

	public PessoaJuridica(String nome, Double rendaAnual, int numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	// Getters e Setters

	public int getNumeroDeFuncionarios() {
		return numeroDeFuncionarios;
	}

	public void setNumeroDeFuncionarios(int numeroDeFuncionarios) {
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}
	
	// Métodos
	
	@Override
	public Double impostoAPagar() {
		double imposto = 0.0;
		
		if (numeroDeFuncionarios > 10) {
			imposto += rendaAnual * 0.14;
		} else {
			imposto += rendaAnual * 0.16;
		}
		return imposto;
	}

}
