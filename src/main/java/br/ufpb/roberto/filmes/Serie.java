package br.ufpb.roberto.filmes;

import java.util.List;

public class Serie extends Midia{
    private int duracao;
    private List<Episodio> episodios;

    public Serie(String titulo, String genero, int anoLancamento, List<Episodio> episodios, int duracao){
        super(titulo, genero, anoLancamento);
        this.episodios = episodios;
        this.duracao = duracao;
    }
    public int getDuracao(){
        int somaDuracao = 0;
        for(Episodio e: this.episodios){
            somaDuracao += e.getDuracao();
        }
        return somaDuracao;
    }
    @Override
    public String toString() {
        return "[Série] " + super.toString() + ", Episódios: " + episodios.size() + ", Duração total: "+duracao + " min";
    }
}
