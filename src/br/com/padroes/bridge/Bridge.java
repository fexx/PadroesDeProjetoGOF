package br.com.padroes.bridge;

abstract class BridgePublicacao {
    private Publicacao publicacao;

    public BridgePublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }
}
abstract class Publicacao {
    private BridgePublicacao bridgePublicacao;
    
    public BridgePublicacao getBridgePublicacao() {
        return bridgePublicacao;
    }
    public void setBridgePublicacao(BridgePublicacao bridgePublicacao) {
        this.bridgePublicacao = bridgePublicacao;
    }
}
class LivroImpl extends Publicacao {

    private String titulo;
    private String autor;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
}
class Livro extends BridgePublicacao {
    public Livro(String titulo, String autor) {
        super(new LivroImpl());
        ((LivroImpl)getPublicacao()).setTitulo(titulo);
        ((LivroImpl)getPublicacao()).setAutor(autor);
    }
    public String toString() {
        return ((LivroImpl)getPublicacao()).getTitulo() + " de " +
          ((LivroImpl)getPublicacao()).getAutor();
    }
    
}
public class Bridge {
    public static void main(String [] args) {
        new Bridge().publicar();
    }
    public void publicar() {
        Livro livro = new Livro("Design Patterns", "GoF");
        System.out.println(livro);
    }
}

