package br.com.padroes.prototype;

public class Loader {

	public static void main(String[] args) {
		Parede p = new Parede();
		p.setAltura(10L);

		Parede p2 = (Parede) p.clonar();
		System.out.println(p2.getAltura());

		p.setAltura(30L);
		System.out.println(p2.getAltura());
	}

}
