package br.ufpb.roberto.filmes;

import java.util.Collection;
import java.io.IOException;

public interface SistemaMultimidia {
    void cadastrarMidiaAudioVisual(String titulo,String genero, int anoLancamento);
    Collection<Midia> pesquisarPorTitulo(String titulo);
    Collection<Midia> pesquisarPorAnoLancamento(int anoLancamento);
    Collection<Midia> pesquisarPorGenero(String genero);
    void atualizarMidia(String titulo, String novoTitulo, String novoGenero, int novoAnoLancamento);
    void avaliarMidia(String titulo, double nota);
    void removerContato(String titulo);
    void salvarDados();
    void recuperarDados();
    void reproduzir();
}
