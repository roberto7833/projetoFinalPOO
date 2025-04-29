package sistema.controller;

import sistema.SistemaMultimidia;
import sistema.exceptions.MidiaJaExisteException;
import sistema.midias.Midia;
import sistema.midias.Filme;
import sistema.midias.Serie;
import sistema.midias.Episodio;
import sistema.midias.MidiaFormulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MidiaAddController implements ActionListener {
    private SistemaMultimidia sistema;
    private JFrame janelaPrincipal;

    public MidiaAddController(SistemaMultimidia sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int start = obterOpcaoNumerica("1. Cadastrar Filme/Serie\nEscolha a opção:");
        if (start != 1) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Opção inválida!");
            return;
        }

        int tipoMidia = obterOpcaoNumerica("1. Filme\n2. Série\nEscolha a opção:");
        Midia midia = MidiaFormulario.criaFormularioBase();

        if (midia != null) {
            String titulo = midia.getTitulo();
            String genero = midia.getGenero();
            int anoLancamento = midia.getAnoLancamento();
            String direcao = midia.getDirecao();
            String[] elenco = midia.getElenco();
            String sinopse = midia.getSinopse();

            try {
                if (tipoMidia == 1) {
                    // Cadastrar Filme
                    int duracao = obterOpcaoNumerica("Duração (em minutos):");
                    midia = new Filme(titulo, genero, anoLancamento, direcao, elenco, sinopse, duracao);
                } else if (tipoMidia == 2) {
                    // Cadastrar Série com apenas 3 episódios
                    List<Episodio> eps = new ArrayList<>();

                    for (int i = 0; i < 3; i++) {  // Limita a 3 episódios
                        String nomeEpisodio = JOptionPane.showInputDialog(janelaPrincipal, "Nome do episódio " + (i + 1) + ": ");
                        int duracaoEpisodio = obterOpcaoNumerica("Duração do episódio " + (i + 1) + " (em minutos):");
                        Episodio episodio = new Episodio(nomeEpisodio, duracaoEpisodio);
                        eps.add(episodio);
                    }

                    midia = new Serie(titulo, genero, anoLancamento, direcao, elenco, sinopse, eps);
                } else {
                    JOptionPane.showMessageDialog(janelaPrincipal, "Opção inválida!");
                    return;
                }

                // Tentar cadastrar a mídia
                sistema.cadastrarMidia(midia);
                JOptionPane.showMessageDialog(janelaPrincipal, "Mídia cadastrada com sucesso!");

            } catch (MidiaJaExisteException ex) {
                JOptionPane.showMessageDialog(janelaPrincipal, "Erro: Mídia já existe no sistema!");
                ex.printStackTrace();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(janelaPrincipal, "Erro ao cadastrar a mídia: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    // Função para obter a opção numérica e validar a entrada
    private int obterOpcaoNumerica(String mensagem) {
        int opcao = -1;
        try {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, mensagem));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Por favor, insira um número válido.");
        }
        return opcao;
    }
}
