package br.ufpb.roberto.filmes;

import java.util.List;

public class Serie extends Midia{
    private List<Episodio> episodios;

    public Serie(String titulo, String genero, int anoLancamento, List<Episodio> episodios, double nota){
        super(titulo, genero, anoLancamento, nota);
        this.episodios = episodios;
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
        return "Série = [título: " + super.getTitulo() + ", Episódios: " + episodios.size() + ", Duração total: " + this.getDuracao() + " min]\n";
    }
}
