package sistema.midias;

public class Episodio {
    private String titulo;
    private int duracao;

    public Episodio(String titulo, int duracao){
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String toString() {
        return "[Episódio] = '" + titulo+ "', Duração: "+duracao + " min\n";
    }
}
