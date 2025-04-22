package sistema.midias;

import java.io.Serializable;

public class Filme extends Midia implements Serializable {

    private int duracao;

    public Filme(String titulo, String genero, int anoLancamento, String direcao, String[] elenco, String sinopse, int duracao) {
        super(titulo, genero, anoLancamento, direcao, elenco, sinopse);
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
        return "[Filme = Título: " + super.getTitulo() + "\nAno de lançamento: " + super.getAnoLancamento()
                + "\nDuração: " + duracao + " minutos\nDireção: " + super.getDirecao() + "\nGênero: " + super.getGenero() + "\nSinopse: " + super.getSinopse() + "\nElenco: " + String.join(", ", super.getElenco()) + "]\n";
    }
}
