package entities;

public class PessoaFisica extends Pessoa {
	
	private Double gastoComSaude;
	
	// Construtores
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoComSaude) {
		super(nome, rendaAnual);
		this.gastoComSaude = gastoComSaude;
	}

	// Getters e Setters 
	
	public Double getGastoComSaude() {
		return gastoComSaude;
	}

	public void setGastoComSaude(Double gastoComSaude) {
		this.gastoComSaude = gastoComSaude;
	}
	
	// Métodos
	
	@Override
	public Double impostoAPagar() {
		double imposto = 0.0;
		if (rendaAnual < 20000) {
			imposto += rendaAnual * 0.15;
		} else {
			imposto += rendaAnual * 0.25;
		}
		
		if (this.gastoComSaude != 0) {
			imposto -= gastoComSaude * 0.5;
		}
		
		return imposto;
	}

}
