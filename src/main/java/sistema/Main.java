package sistema;

import sistema.exceptions.MidiaJaExisteException;
import sistema.exceptions.MidiaNaoExisteException;
import sistema.midias.Episodio;
import sistema.midias.Filme;
import sistema.midias.Midia;
import sistema.midias.Serie;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GerenciadorDeMidias sistema = new GerenciadorDeMidias();

        //Filmes pré-cadastrados para testes:
        try {
            sistema.cadastrarMidia(new Filme("A Origem", "Ficção Científica", 2010, 148, 4.5));
            sistema.cadastrarMidia(new Filme("O Poderoso Chefão", "Drama/Crime", 1972, 175, 5.0));
            sistema.cadastrarMidia(new Filme("Interestelar", "Ficção Científica", 2014, 169, 4.8));
            sistema.cadastrarMidia(new Filme("Parasita", "Suspense/Drama", 2019, 132, 4.6));
            sistema.cadastrarMidia(new Filme("Clube da Luta", "Drama", 1999, 139, 4.7));
        } catch (MidiaJaExisteException e) {
            e.printStackTrace();
        }

        boolean sair = false;

        while (!sair){
            int start = Integer.parseInt(JOptionPane.showInputDialog("1. Cadastrar Filme/Serie\n2. Pesquisa\n3. Mostrar Todas as mídias\n4. Atualizar mídia\n5. Remover mídia\n6. Sair"));
            switch (start){
                case 1: //Cadastrar Filme/Serie
                    start = Integer.parseInt(JOptionPane.showInputDialog("1. Filme\n2. Série:"));
                    while (start != 1 && start != 2) {
                        start = Integer.parseInt(JOptionPane.showInputDialog("Opção inválida. Escolha uma das opções abaixo:\n1. Filme\n2. Série:"));
                    }
                    String titulo = JOptionPane.showInputDialog("Nome: ");
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de lançamento: "));
                    String genero = JOptionPane.showInputDialog("Gênero: ");
                    double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota de 1 a 5: "));

                    if (start == 1) {
                        int duracao = Integer.parseInt(JOptionPane.showInputDialog("Duração: ")); // A duração aqui evita que ele pergunte a duração da serie
                        Midia filme = new Filme(titulo, genero, ano, duracao, nota);

                        try {
                            sistema.cadastrarMidia(filme);
                            JOptionPane.showMessageDialog(null, filme.toString());
                        } catch (MidiaJaExisteException e) {
                            e.printStackTrace();
                        }
                    } else {
                        int quantEpsSerie = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de episódios da série: "));
                        int mediaDuracaoEpsSerie = Integer.parseInt(JOptionPane.showInputDialog("Duração média dos episódios da série: "));

                        List<Episodio> eps = List.of(
                                new Episodio("Episódio 1", 45),
                                new Episodio("Episódio 2", 50)
                        );

                        Midia serie = new Serie(titulo,genero, ano, quantEpsSerie, mediaDuracaoEpsSerie, nota);
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
                        double novaNota = Double.parseDouble(JOptionPane.showInputDialog("Nota (1 a 5): "));;
                        sistema.getMidia(tituloAtualizar).setTitulo(novoTitulo);
                        sistema.getMidia(tituloAtualizar).setGenero(novoGenero);
                        sistema.getMidia(tituloAtualizar).setAnoLancamento(novoAnoLancamento);
                        sistema.getMidia(tituloAtualizar).setNota(novaNota);

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
