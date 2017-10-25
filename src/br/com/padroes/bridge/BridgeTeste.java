package br.com.padroes.bridge;


class CarroProduct {
    double preco;
    String dscMotor;
    int anoDeFabricacao;
    String modelo;
    String montadora;
}

abstract class CarroBuilder {
	 
    protected CarroProduct carro;
 
    public CarroBuilder() {
        carro = new CarroProduct();
    }
 
    public abstract void buildPreco();
 
    public abstract void buildDscMotor();
 
    public abstract void buildAnoDeFabricacao();
 
    public abstract void buildModelo();
 
    public abstract void buildMontadora();
 
    public CarroProduct getCarro() {
        return carro;
    }
}

class FiatBuilder extends CarroBuilder {
	 
    @Override
    public void buildPreco() {
        // Operação complexa. 
        carro.preco = 25000.00;
    }
 
    @Override
    public void buildDscMotor() {
        // Operação complexa.
        carro.dscMotor = "Fire Flex 1.0";
    }
 
    @Override
    public void buildAnoDeFabricacao() {
        // Operação complexa.
        carro.anoDeFabricacao = 2011;
    }
 
    @Override
    public void buildModelo() {
        // Operação complexa.
        carro.modelo = "Palio";
    }
 
    @Override
    public void buildMontadora() {
        // Operação complexa.
        carro.montadora = "Fiat";
    }
}

class ConcessionariaDirector {
    protected CarroBuilder montadora;
 
    public ConcessionariaDirector(CarroBuilder montadora) {
        this.montadora = montadora;
    }
 
    public void construirCarro() {
        montadora.buildPreco();
        montadora.buildAnoDeFabricacao();
        montadora.buildDscMotor();
        montadora.buildModelo();
        montadora.buildMontadora();
    }
 
    public CarroProduct getCarro() {
        return montadora.getCarro();
    }
}

public class BridgeTeste {
	public static void main(String[] args) {
	    ConcessionariaDirector concessionaria = new ConcessionariaDirector(new FiatBuilder());
	 
	    concessionaria.construirCarro();
	    CarroProduct carro = concessionaria.getCarro();
	    System.out.println("Carro: " + carro.modelo + "/" + carro.montadora
	            + "\nAno: " + carro.anoDeFabricacao + "\nMotor: "
	            + carro.dscMotor + "\nValor: " + carro.preco);
	 
	    System.out.println();
	 
//	    concessionaria = new ConcessionariaDirector(new VolksBuilder());
//	    concessionaria.construirCarro();
//	    carro = concessionaria.getCarro();
//	    System.out.println("Carro: " + carro.modelo + "/" + carro.montadora
//	            + "\nAno: " + carro.anoDeFabricacao + "\nMotor: "
//	            + carro.dscMotor + "\nValor: " + carro.preco);
	}
}
