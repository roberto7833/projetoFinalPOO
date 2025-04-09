package br.ufpb.roberto.filmes;

import java.util.List;
import java.util.Scanner;

public class ProgramaSistemaMidiaAudioVisual {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SistemaMultimidia sistema = new MidiaAudioVisual();

        Filme filme = new Filme("Matrix", "Ficção", 1999, 136);
        sistema.cadastrarFilme(filme);

        List<Episodio> eps = List.of(
                new Episodio("Episódio 1", "Drama", 2020, 45),
                new Episodio("Episódio 2", "Drama", 2020, 50)
        );
        Serie serie = new Serie("Dark", "Drama", 2020, eps, 136);
        sistema.cadastrarSerie(serie);

        System.out.println("Todas as mídias:");
        for (Midia m : sistema.mostrarTodasAsMidiasCadastradas()) {
            System.out.println(m);
        }
    }
}
