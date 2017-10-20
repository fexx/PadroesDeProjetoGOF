package br.com.padroes.abstractFactory;

import java.util.Scanner;

abstract class Pet {
    private String nome;

    public Pet(String nome) {
        this.nome = nome;
    }
    public String toString() {
        return nome;
    }
}
abstract class Cachorro extends Pet {
    public Cachorro(String nome) {
        super(nome);
    }
}
abstract class Gato extends Pet {
    public Gato(String nome) {
        super(nome);
    }
}
class Shitzu extends Cachorro {
    public Shitzu() {
        super("Shitzu");
    }
}
class Pastor extends Cachorro {
    public Pastor() {
        super("Pastor");
    }
}
class Persa extends Gato {
    public Persa() {
        super("Persa");
    }
}
class RagDoll extends Gato {
    public RagDoll() {
        super("RagDoll");
    }
}
interface Modelo {
    Cachorro getCachorro();
    Gato getGato();
}
class FabricaCompanhia implements Modelo {
    public Cachorro getCachorro() {
        return new Shitzu();
    }
    public Gato getGato() {
        return new Persa();
    }
}
class FabricaGuarda implements Modelo {
    public Cachorro getCachorro() {
        return new Pastor();
    }
    public Gato getGato() {
        return new RagDoll();
    }
}
public class AbsFac {
  private Scanner sc = new Scanner(System.in);
  public static void main(String [] args) {
      new AbsFac().executar();
  }
  public void executar() {
      System.out.println("Informe 1-Companhia ou 2-Guarda");
      byte opc = sc.nextByte();
      Modelo modelo = null;
      switch (opc) {
          case 1: modelo = new FabricaCompanhia(); break;
          case 2: modelo = new FabricaGuarda(); break;
      }
      System.out.println("Cachorro: " + modelo.getCachorro());
      System.out.println("Gato: " + modelo.getGato());
  }
}
