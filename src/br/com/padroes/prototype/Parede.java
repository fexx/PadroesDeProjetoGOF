package br.com.padroes.prototype;

public class Parede extends Peca {

	private Long altura;

	public Parede() {}

	private Parede(Parede parede) {
		this.altura = parede.getAltura();
	}

	@Override
	public Peca clonar() {
		return new Parede(this);
	}
	
	public Long getAltura() {
		return altura;
	}
	
	public void setAltura(Long altura) {
		this.altura = altura;
	}

}
