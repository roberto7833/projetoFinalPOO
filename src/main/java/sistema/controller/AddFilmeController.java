package sistema.controller;

import sistema.SistemaMultimidia;
import sistema.exceptions.MidiaJaExisteException;
import sistema.midias.Filme;
import sistema.formularios.FilmeFormulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MidiaAddController implements ActionListener {
    private SistemaMultimidia sistema;
    private JFrame janelaPrincipal;

    public MidiaAddController(SistemaMultimidia sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Filme filme = FilmeFormulario.criaFormularioBase();

        if (filme != null) {
            String titulo = filme.getTitulo();
            String genero = filme.getGenero();
            int duracao = filme.getDuracao();
            int anoLancamento = filme.getAnoLancamento();
            String direcao = filme.getDirecao();
            String[] elenco = filme.getElenco();
            String sinopse = filme.getSinopse();

            try {
                filme = new Filme(titulo, genero, anoLancamento, direcao, elenco, sinopse, duracao);
                sistema.cadastrarMidia(filme);
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
