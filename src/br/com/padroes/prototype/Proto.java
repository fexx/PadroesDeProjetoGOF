package br.com.padroes.prototype;

class Ovelha implements Cloneable {
	private String nome;

	public Ovelha(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return object;
	}
}

interface Prototype {
	public Ovelha duplicar(Ovelha ovelha);
}

class PrototypeImpl implements Prototype {
	
	@Override
	public Ovelha duplicar(Ovelha ovelha) {
		return (Ovelha) ovelha.clone();
	}
}

public class Proto {
	public static void main(String[] args) {
		new Proto().executar();
	}

	public void executar() {
		Ovelha original = new Ovelha("Dolly");
		Ovelha clone = new PrototypeImpl().duplicar(original);
	}
}
