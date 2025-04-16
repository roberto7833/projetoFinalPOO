package sistema.midias;

import java.util.List;

public class Serie extends Midia {

    private List<Episodio> episodios;

    public Serie(String titulo, String genero, int anoLancamento, String direcao, String[] elenco, String sinopse, List<Episodio> episodios) {
        super(titulo, genero, anoLancamento, direcao, elenco, sinopse);
        this.episodios = episodios;
    }

    public int getDuracaoTotal(){
        int cont = 0;
        for (Episodio ep: episodios) {
            cont += ep.getDuracao();
        } return cont;
    }

    public int getDuracaoMediaEps(){
        int cont = 0;
        for (Episodio ep: episodios) {
            cont += ep.getDuracao();
        } return cont/episodios.size();
    }

    @Override
    public String toString(){
        return "[Série = título: " + super.getTitulo() + ", Episódios: " + episodios.size() + ", Duração: " + this.getDuracaoMediaEps() + " min/ep]\n";
    }
}
