package sistema.midias;

import java.io.Serializable;
import java.util.Objects;

public class Midia implements Serializable {
    private String titulo;
    private String genero;
    private int anoLancamento;
    private String direcao;
    private String [] elenco;
    private String sinopse;

    
    public Midia(String titulo, String genero, int anoLancamento, String direcao, String[] elenco, String sinopse) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.direcao = direcao;
        this.elenco = elenco;
        this.sinopse = sinopse;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String[] getElenco() {
        return elenco;
    }

    public void setElenco(String[] elenco) {
        this.elenco = elenco;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    //public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Midia midia = (Midia) o;
        return anoLancamento == midia.anoLancamento && Objects.equals(titulo, midia.titulo) && Objects.equals(genero, midia.genero);
    }
    @Override
    public int hashCode() {
        return Objects.hash(titulo, genero, anoLancamento);
    }
}
