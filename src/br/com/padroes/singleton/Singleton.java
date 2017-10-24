package br.com.padroes.singleton;

class ContaCorrente {
    private String numeroConta;
    private static ContaCorrente contaCorrente;
    
    private ContaCorrente() {
    }
    public static ContaCorrente newInstance() {
        if (contaCorrente == null) {
            contaCorrente = new ContaCorrente();
        }
        return contaCorrente;
    }
    
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    public String toString() {
        return numeroConta;
    }
}

public class Singleton {
    public static void main(String [] args) {
        new Singleton().criarContas();
    }
    public void criarContas() {
        ContaCorrente ct1 = ContaCorrente.newInstance();
        ct1.setNumeroConta("123-45");
        System.out.println(ct1 + " - " + ct1.hashCode());
        ContaCorrente ct2 = ContaCorrente.newInstance();
        ct2.setNumeroConta("323-35");
        System.out.println(ct2 + " - " + ct2.hashCode());
    }
}

