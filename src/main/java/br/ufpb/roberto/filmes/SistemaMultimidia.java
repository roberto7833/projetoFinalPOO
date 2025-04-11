package br.ufpb.roberto.filmes;

import java.util.Collection;

public interface SistemaMultimidia {
    void cadastrarMidia(Midia midia)throws MidiaJaExisteException;
    Collection<Midia> pesquisarPorTitulo(String titulo);
    Collection<Midia> pesquisarPorAnoLancamento(int anoLancamento);
    Collection<Midia> pesquisarPorGenero(String genero);
    Collection<Midia> mostrarTodasAsMidiasCadastradas();
    void atualizarMidia(String titulo, String novoTitulo, String novoGenero, int novoAnoLancamento)throws MidiaNaoExisteException;
    void removerMidia(String titulo)throws MidiaNaoExisteException;
    void salvarDados();
    void recuperarDados();
}