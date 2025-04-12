package sistema.midias;

import java.util.List;

public class Serie extends Midia {
    private List<Episodio> episodios;
    private int quantEps;
    private int duracaoMediaEps;

    public Serie(String titulo, String genero, int anoLancamento, int quantEps, int duracaoMediaEps, double nota){
        super(titulo, genero, anoLancamento, nota);
        this.episodios = episodios;
        this.quantEps = quantEps;
        this.duracaoMediaEps = duracaoMediaEps;
    }

    public int getDuracaoTotal(){
        return quantEps * duracaoMediaEps;
    }

    public int getDuracaoMediaEps(){
        return this.duracaoMediaEps;
    }

    @Override
    public String toString() {
        return "\nSérie = [título: " + super.getTitulo() + ", Episódios: " + this.quantEps + ", Duração: " + this.getDuracaoMediaEps() + " min/ep, Nota(" + super.getNota() + ")]";
    }
}
