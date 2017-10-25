package br.com.padroes.composite;

import java.util.ArrayList;

abstract class ArquivoComponent {
	 
    String nomeDoArquivo;
 
    public void printNomeDoArquivo() {
        System.out.println(this.nomeDoArquivo);
    }
 
    public String getNomeDoArquivo() {
        return this.nomeDoArquivo;
    }
 
    public void adicionar(ArquivoComponent novoArquivo) throws Exception {
        throw new Exception("Não pode inserir arquivos em: "
                + this.nomeDoArquivo + " - Não é uma pasta");
    }
 
    public void remover(String nomeDoArquivo) throws Exception {
        throw new Exception("Não pode remover arquivos em: "
                + this.nomeDoArquivo + " -Não é uma pasta");
    }
 
    public ArquivoComponent getArquivo(String nomeDoArquivo) throws Exception {
        throw new Exception("Não pode pesquisar arquivos em: "
                + this.nomeDoArquivo + " - Não é uma pasta");
    }
}

class ArquivoVideo extends ArquivoComponent {
	 
    public ArquivoVideo(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }
}

class ArquivoComposite extends ArquivoComponent {
	 
    ArrayList<ArquivoComponent> arquivos = new ArrayList<ArquivoComponent>();
 
    public ArquivoComposite(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }
 
    @Override
    public void printNomeDoArquivo() {
        System.out.println(this.nomeDoArquivo);
        for (ArquivoComponent arquivoTmp : arquivos) {
            arquivoTmp.printNomeDoArquivo();
        }
    }
 
    @Override
    public void adicionar(ArquivoComponent novoArquivo) {
        this.arquivos.add(novoArquivo);
    }
 
    @Override
    public void remover(String nomeDoArquivo) throws Exception {
        for (ArquivoComponent arquivoTmp : arquivos) {
            if (arquivoTmp.getNomeDoArquivo() == nomeDoArquivo) {
                this.arquivos.remove(arquivoTmp);
                return;
            }
        }
        throw new Exception("Não existe este arquivo");
    }
 
    @Override
    public ArquivoComponent getArquivo(String nomeDoArquivo) throws Exception {
        for (ArquivoComponent arquivoTmp : arquivos) {
            if (arquivoTmp.getNomeDoArquivo() == nomeDoArquivo) {
                return arquivoTmp;
            }
        }
        throw new Exception("Não existe este arquivo");
    }
 
}

public class CompositeTest {
	public static void main(String[] args) {
	    ArquivoComponent minhaPasta = new ArquivoComposite("Minha Pasta/");
	    ArquivoComponent meuVideo = new ArquivoVideo("meu video.avi");
	    ArquivoComponent meuOutroVideo = new ArquivoVideo("serieS01E01.mkv");
	 
	    try {
	        meuVideo.adicionar(meuOutroVideo);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	 
	    try {
	        minhaPasta.adicionar(meuVideo);
	        minhaPasta.adicionar(meuOutroVideo);
	        minhaPasta.printNomeDoArquivo();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	 
	    try {
	        System.out.println("\nPesquisando arquivos:");
	        minhaPasta.getArquivo(meuVideo.getNomeDoArquivo())
	                .printNomeDoArquivo();
	        System.out.println("\nRemover arquivos");
	        minhaPasta.remover(meuVideo.getNomeDoArquivo());
	        minhaPasta.printNomeDoArquivo();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
