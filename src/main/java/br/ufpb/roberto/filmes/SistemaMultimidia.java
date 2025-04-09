package br.ufpb.roberto.filmes;

import java.util.Collection;

public interface SistemaMultimidia {
    void cadastrarFilme(Filme filme)throws MidiaJaExisteException;
    void cadastrarSerie(Serie serie)throws MidiaJaExisteException;
    Collection<Midia> pesquisarPorTitulo(String titulo);
    Collection<Midia> pesquisarPorAnoLancamento(int anoLancamento);
    Collection<Midia> pesquisarPorGenero(String genero);
    Collection<Midia> mostrarTodasAsMidiasCadastradas();
    void atualizarMidia(String titulo, String novoTitulo, String novoGenero, int novoAnoLancamento)throws MidiaNaoExisteException;
    void removerContato(String titulo)throws MidiaNaoExisteException;
    void salvarDados();
    void recuperarDados();
}
