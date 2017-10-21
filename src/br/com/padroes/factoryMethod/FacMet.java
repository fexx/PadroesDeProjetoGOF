package br.com.padroes.factoryMethod;

abstract class Veiculo {
    private String modelo;
    
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

class Opala extends Veiculo {
    public Opala() {
        setModelo("Opala");
    }
}

class Vectra extends Veiculo {
    public Vectra() {
        setModelo("Vectra");
    }
}
abstract class GMCriador {
    public abstract Opala factoryOpala();
    public abstract Vectra factoryVectra();
}
class GMCriadorConcreto extends GMCriador {
    public Opala factoryOpala() {
        return new Opala();
    }
    public Vectra factoryVectra() {
        return new Vectra();
    }
}


public class FacMet {
    
    public static void main(String [] args) {
        new FacMet().construir();
    }
    public void construir() {
        GMCriador gm = new GMCriadorConcreto();
        Veiculo vectra = gm.factoryVectra();
        Veiculo opala = gm.factoryOpala();
    }
    
}

