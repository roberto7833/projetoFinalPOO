package br.ufpb.roberto.filmes;

public class Filme extends Midia{
    private int duracao;

    public Filme(String titulo, String genero, int anoLancamento, int duracao, double nota){
        super(titulo, genero, anoLancamento, nota);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return this.duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    @Override
    public String toString() {
        return "Filme = [Título: " + super.getTitulo() + ", Ano de lançamento: " + super.getAnoLancamento() + ", Duração: " + duracao + " min]\n";
    }
}
