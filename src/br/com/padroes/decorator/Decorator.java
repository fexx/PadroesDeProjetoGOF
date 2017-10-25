package br.com.padroes.decorator;

	
	abstract class Coquetel {
	    String nome;
	    double preco;
	 
	    public String getNome() {
	        return nome;
	    }
	 
	    public double getPreco() {
	        return preco;
	    }
	}
	
	class Caipirinha extends Coquetel {
	    public Caipirinha() {
	        nome = "Caipirinha";
	        preco = 3.5;
	    }
	}
	
	class Cachaca extends Coquetel {
	    public Cachaca() {
	        nome = "Cachaça";
	        preco = 1.5;
	    }
	}
	
	abstract class CoquetelDecorator extends Coquetel {
	    Coquetel coquetel;
	 
	    public CoquetelDecorator(Coquetel umCoquetel) {
	        coquetel = umCoquetel;
	    }
	 
	    @Override
	    public String getNome() {
	        return coquetel.getNome()  + " + " + nome;
	    }
	 
	    public double getPreco() {
	        return coquetel.getPreco() + preco;
	    }
	}
	
	class Refrigerante extends CoquetelDecorator {
		 
	    public Refrigerante(Coquetel umCoquetel) {
	        super(umCoquetel);
	        nome = "Refrigerante";
	        preco = 1.0;
	    }
	 
	}
	
	public class Decorator{
		
		public static void main(String[] args) {
        Coquetel meuCoquetel = new Cachaca();
        System.out.println(meuCoquetel.getNome() + " = " + meuCoquetel.getPreco());
			
       Coquetel refrigerante = new Refrigerante(meuCoquetel);
        System.out.println(refrigerante.getNome() + " = " + refrigerante.getPreco());
		}
	
}
