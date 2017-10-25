package br.com.padroes.adapter;

interface Vetor {
    int getPosX();
    int getPosY();
    int getLargura();
    int getAltura();
}
class Figura implements Vetor {
    private int posX, posY, largura, altura;

    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getLargura() {
        return largura;
    }
    public int getAltura() {
        return altura;
    }
}
class CaixaArraste {
    private Coordenada topoEsq, rodapeDir;

    public Coordenada getTopoEsq() {
        return topoEsq;
    }
    public Coordenada getRodapeDir() {
        return rodapeDir;
    }
}
class Coordenada {
    private int x, y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
class CaixaArrasteAdapter implements Vetor {
    private CaixaArraste caixaArraste = new CaixaArraste();

    public int getPosX() {
        Coordenada c = caixaArraste.getTopoEsq();
        return c.getX();
    }
    public int getPosY() {
        Coordenada c = caixaArraste.getTopoEsq();
        return c.getY();
    }
    public int getLargura() {
        Coordenada c1 = caixaArraste.getTopoEsq();
        Coordenada c2 = caixaArraste.getRodapeDir();
        return c2.getX() - c1.getX();
    }
    public int getAltura() {
        Coordenada c1 = caixaArraste.getTopoEsq();
        Coordenada c2 = caixaArraste.getRodapeDir();
        return c2.getY() - c1.getY();
    }
}
public class Adapter {
    public static void main(String [] args) {
        new Adapter().usar();
    }
    public void usar() {
        Vetor fig = new Figura();
        Vetor cxa = new CaixaArrasteAdapter();
    }
}
