package br.ufpb.roberto.filmes;

import java.util.Objects;

public abstract class Midia {
    private String titulo;
    private String genero;
    private int anoLancamento;
    private double nota;

    public Midia(String titulo, String genero, int anoLancamento, double nota) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.nota = nota;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getGenero() {
        return this.genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAnoLancamento() {
        return this.anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public double getNota(){
        return this.nota;
    }

    public abstract String toString();

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
