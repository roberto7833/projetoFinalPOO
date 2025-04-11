package br.ufpb.roberto.filmes;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProgramaSistemaMidiaAudioVisual {
    public static void main(String[] args) throws Exception {

        GerenciadorDeMidias sistema = new GerenciadorDeMidias();

        int start = 0;
        boolean sair = false;

        while (!sair){
            start = Integer.parseInt(JOptionPane.showInputDialog("1. Cadastrar Filme/Serie\n2. Pesquisar por titulo\n3. Pesquisar por ano de lancamento\n4. Pesquisar por genero\n5. Mostrar Todas as midias\n6. Atualizar mídia\n7. Remover mídia"));
            switch (start){
                case 1:
                    int escolhaMidia = Integer.parseInt(JOptionPane.showInputDialog("1. Filme\n2. Série:"));

                    String titulo = JOptionPane.showInputDialog("Nome: ");
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento: "));
                    String genero = JOptionPane.showInputDialog("Gênero: ");
                    double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota de 1 a 5: "));

                    if (escolhaMidia == 1) {
                        int duracao = Integer.parseInt(JOptionPane.showInputDialog("Duração: "));
                        Midia filme = new Filme(titulo, genero, ano, duracao, nota);
                        try {
                            sistema.cadastrarMidia(filme);
                            JOptionPane.showMessageDialog(null, filme.toString());
                        } catch (MidiaJaExisteException e) {
                            e.printStackTrace();
                        }
                    } else if (escolhaMidia == 2) {
                        List<Episodio> eps = List.of(
                                new Episodio("Episódio 1", 45),
                                new Episodio("Episódio 2", 50)
                        );
                        Midia serie = new Serie(titulo, genero, ano, eps, nota);
                        sistema.cadastrarMidia(serie);
                        JOptionPane.showMessageDialog(null, serie.toString());

                        try {
                            sistema.cadastrarMidia(serie);
                        } catch (MidiaJaExisteException e) {
                            e.printStackTrace();
                        }
                    } break;
                case 2:
                    sair = true;
            }
        }
    }
}
