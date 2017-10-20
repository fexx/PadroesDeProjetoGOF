package br.com.padroes.abstractFactory;


 interface FabricaDeCarro {
    CarroSedan criarCarroSedan();
    CarroPopular criarCarroPopular();
}

class FabricaFiat implements FabricaDeCarro {
	 
    @Override
    public CarroSedan criarCarroSedan() {
        return new Siena();
    }
 
    @Override
    public CarroPopular criarCarroPopular() {
        return new Palio();
    }
 
}

interface CarroSedan {
	void exibirInfoSedan();
}

interface CarroPopular {
    void exibirInfoPopular();
}

class Siena implements CarroSedan {
	
	@Override
	public void exibirInfoSedan() {
		System.out.println("Modelo: Siena\nFábrica: Fiat\nCategoria:Sedan");
	}
	
}

class Palio implements CarroPopular {
	 
    @Override
    public void exibirInfoPopular() {
        System.out.println("Modelo: Palio\nFábrica: Fiat\nCategoria:Popular");
    }
 
}


public class AbstractFactory {

	public static void main(String[] args) {
	    FabricaDeCarro fabrica = new FabricaFiat();
	    
	    CarroSedan sedan = fabrica.criarCarroSedan();
	    CarroPopular popular = fabrica.criarCarroPopular();
	    
	    sedan.exibirInfoSedan();
	    popular.exibirInfoPopular();
	    
	 
	    /*
		    fabrica = new FabricaFord();
		    
		    sedan = fabrica.criarCarroSedan();
		    popular = fabrica.criarCarroPopular();
		    
		    sedan.exibirInfoSedan();
		    System.out.println();
		    popular.exibirInfoPopular();
	     */
	}
}