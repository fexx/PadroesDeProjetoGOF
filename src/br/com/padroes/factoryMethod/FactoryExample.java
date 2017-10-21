package br.com.padroes.factoryMethod;

abstract class CarroAbs {
	protected float valor;

	public float getPreco() {
		return valor;
	}
}

class CarroGol extends CarroAbs {
	public CarroGol() {
		valor = 20000.0f;
	}
}

class CarroVectra extends CarroAbs {
	public CarroVectra() {
		valor = 30000.0f;
	}
}

class CarroFactory {
	public static CarroAbs getCarro(String tipoCarro) {
		if (tipoCarro == null)
			return null;
		else if (tipoCarro.equalsIgnoreCase("Vectra"))
			return new CarroVectra();
		else if (tipoCarro.equalsIgnoreCase("Gol"))
			return new CarroVectra();
		else
			return null;
	}
}

public class FactoryExample {
	public static void main(String[] args) {
		CarroAbs carro = CarroFactory.getCarro("Vectra");

		if (carro != null)
			System.out.print("Preço: " + carro.getPreco());
	}
}
