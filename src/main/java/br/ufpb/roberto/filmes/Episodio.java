package br.ufpb.roberto.filmes;

public class Episodio {
    private String titulo;
    private int duracao;

    public Episodio(String titulo, int duracao){
        this.titulo = titulo;
        this.duracao = duracao;
    }
    public int getDuracao() {
        return this.duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public String toString() {
        return "[Série] " + titulo+ ", Duração total: "+duracao + " min";
    }
}
