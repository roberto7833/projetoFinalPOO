package sistema.GUI;

import sistema.GerenciadorDeMidias;
import sistema.exceptions.MidiaJaExisteException;
import sistema.exceptions.MidiaNaoExisteException;
import sistema.midias.Episodio;
import sistema.midias.Filme;
import sistema.midias.Midia;
import sistema.midias.Serie;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class MainJOptionPane {
    public static void main(String[] args) {

        GerenciadorDeMidias sistema = new GerenciadorDeMidias();

        boolean sair = false;

        while (!sair){
            int start = Integer.parseInt(JOptionPane.showInputDialog("1. Cadastrar Filme/Serie\n2. Pesquisa\n3. Mostrar Todas as mídias\n4. Atualizar mídia\n5. Remover mídia\n6. Sair"));
            switch (start){
                case 1: //Cadastrar Mídia
                    start = Integer.parseInt(JOptionPane.showInputDialog("1. Filme\n2. Série:"));
                    String titulo = JOptionPane.showInputDialog("Nome: ");
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento: "));
                    String genero = JOptionPane.showInputDialog("Gênero: ");
                    String direcao = JOptionPane.showInputDialog("Direção: ");
                    String sinopse = JOptionPane.showInputDialog("Sinopse: ");
                    String[] elenco = JOptionPane.showInputDialog("Elenco (nomes separados por virgula): ").split(",");

                    if (start == 1) {
                        int duracao = Integer.parseInt(JOptionPane.showInputDialog("Duração: ")); // A duração aqui evita que ele pergunte a duração da serie
                        Filme filme = new Filme(titulo, genero, ano, direcao, elenco, sinopse, duracao);
                        try {
                            sistema.cadastrarMidia(filme);
                            JOptionPane.showMessageDialog(null, filme);
                        } catch (MidiaJaExisteException e) {
                            e.printStackTrace();
                        }
                    } else {
                        int quantEpsSerie = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de episódios da série: "));

                        List<Episodio> eps = new ArrayList<>();
                        for (int i = 0; i < quantEpsSerie; i++) {
                            String nomeEpisodio = JOptionPane.showInputDialog("Nome do episódio " + (i + 1) + ": ");
                            int duracaoEpisodio = Integer.parseInt(JOptionPane.showInputDialog("Duração do episódio " + (i + 1) + ": "));
                            Episodio episodio = new Episodio(nomeEpisodio, duracaoEpisodio);
                            eps.add(episodio);
                        }

                        Serie serie = new Serie (titulo, genero, ano, direcao, elenco, sinopse, eps);
                        JOptionPane.showMessageDialog(null, serie.toString());

                        try {
                            sistema.cadastrarMidia(serie);
                        } catch (MidiaJaExisteException e) {
                            e.printStackTrace();
                        }
                    } break;

                case 2: //Pesquisa
                    start = Integer.parseInt(JOptionPane.showInputDialog("Pesquisar por:\n1. Título\n2. Gênero\n3. Ano de lançamento"));
                    switch (start){
                        case 1:
                            String tituloPesquisar = JOptionPane.showInputDialog("Digite o título: ");
                            JOptionPane.showMessageDialog(null, sistema.pesquisarPorTitulo(tituloPesquisar));
                            break;
                        case 2:
                            String generoPesquisar = JOptionPane.showInputDialog("Digite o gênero: ");
                            JOptionPane.showMessageDialog(null, sistema.pesquisarPorGenero(generoPesquisar));
                            break;
                        case 3:
                            int anoPesquisar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento: "));
                            JOptionPane.showMessageDialog(null, sistema.pesquisarPorAnoLancamento(anoPesquisar));
                            break;
                    } break;

                case 3: //Mostrar Todas as midias
                    JOptionPane.showMessageDialog(null,sistema.mostrarTodasAsMidiasCadastradas());
                    break;

                case 4: //Atualizar mídia
                    String tituloAtualizar = JOptionPane.showInputDialog("Digite o título da mídia a ser atualizada: ");
                    try {
                        JOptionPane.showMessageDialog(null, "Midia encontrada:\n" + sistema.getMidia(tituloAtualizar));// Confirmação
                        // Novos dados:
                        String novoTitulo = JOptionPane.showInputDialog("Titulo: ");
                        String novoGenero = JOptionPane.showInputDialog("Gênero: ");
                        int novoAnoLancamento = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento: "));;
                        sistema.getMidia(tituloAtualizar).setTitulo(novoTitulo);
                        sistema.getMidia(tituloAtualizar).setGenero(novoGenero);
                        sistema.getMidia(tituloAtualizar).setAnoLancamento(novoAnoLancamento);

                        JOptionPane.showMessageDialog(null, "Midia atualizada com sucesso: " + sistema.getMidia(tituloAtualizar));
                    } catch (MidiaNaoExisteException m){
                        m.printStackTrace();
                    } break;

                case 5: //Remover midia
                    String tituloRemover = JOptionPane.showInputDialog("Digite o título a ser removido: ");
                    try {
                        JOptionPane.showMessageDialog(null, "Midia a ser removida:\n" + sistema.getMidia(tituloRemover));// Confirmação
                        sistema.removerMidia(tituloRemover);
                    } catch (MidiaNaoExisteException m) {
                        m.printStackTrace();
                    } break;
                case 6:
                    sair = true;
            }
        }
    }
}
