package br.ufpb.roberto.filmes;

public class Filme extends Midia{
    private int duracao;

    public Filme(String titulo, String genero, int anoLancamento, int duracao){
        super(titulo, genero, anoLancamento);
        this.duracao = duracao;
    }
    public int getDuracao() {
        return this.duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
