package br.com.padroes.decorator;

interface Ervilha {
    void combinar();
    void setErvilhaPai(Ervilha ervilhaPai);
}
abstract class ErvilhaDecorator implements Ervilha {
    private Ervilha ervilhaPai = null;
    public ErvilhaDecorator(Ervilha ervilhaPai) {
        this.setErvilhaPai(ervilhaPai);
    }
    public void setErvilhaPai(Ervilha ervilhaPai) {
        this.ervilhaPai = ervilhaPai;
    }
    public void combinar() {
        if (ervilhaPai != null) {
            ervilhaPai.combinar();
            System.out.println(" x ");
        } else {
            System.out.println();
        }
    }
}
class ErvilhaAmarela extends ErvilhaDecorator {
    public ErvilhaAmarela(Ervilha ervilhaPai) {
        super(ervilhaPai);
    }
    public ErvilhaAmarela() {
        super(null);
    }
    public void combinar() {
        super.combinar();
        mostrarCor();
    }
    public void mostrarCor() {
        System.out.println("Ervilha Amarela");
    }
}
class ErvilhaVermelha extends ErvilhaDecorator {
    public ErvilhaVermelha(Ervilha ervilhaPai) {
        super(ervilhaPai);
    }
    public ErvilhaVermelha() {
        super(null);
    }
    public void combinar() {
        super.combinar();
        mostrarCor();
    }
    public void mostrarCor() {
        System.out.println("Ervilha Vermelha");
    }
}
class ErvilhaVerde extends ErvilhaDecorator {
    public ErvilhaVerde(Ervilha ervilhaPai) {
        super(ervilhaPai);
    }
    public ErvilhaVerde() {
        super(null);
    }
    public void combinar() {
        super.combinar();
        mostrarCor();
    }
    public void mostrarCor() {
        System.out.println("Ervilha Verde");
    }
}
public class Decor {
    public static void main(String [] args) {
        new Decor().combine();
    }
    public void combine() {
        new ErvilhaVerde(new ErvilhaVermelha());
        new ErvilhaAmarela(new ErvilhaVerde());
        new ErvilhaAmarela();
    }
}

