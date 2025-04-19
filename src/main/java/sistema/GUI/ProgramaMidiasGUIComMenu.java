package sistema.GUI;

import sistema.SistemaMultimidia;
import sistema.GerenciadorDeMidias;
import sistema.exceptions.MidiaJaExisteException;
import sistema.exceptions.MidiaNaoExisteException;
import sistema.midias.Episodio;
import sistema.midias.Filme;
import sistema.midias.GravadorDeDados;
import sistema.midias.Midia;
import sistema.midias.Serie;


import javax.swing.*;
import java.awt.*;

public class ProgramaMidiasGUIComMenu extends JFrame{
    JLabel linha1, linha2;
    ImageIcon filmeJpg = new ImageIcon("./imgs/filmes.png");
    SistemaMultimidia midias = new GerenciadorDeMidias();
    JMenuBar barraDeMenu = new JMenuBar();

    public ProgramaMidiasGUIComMenu(){
        setTitle("Sistema Filmes/Series");
        setSize(800, 600); //tamanho da janela
        setLocation(150, 150);
        setResizable(true);
        setBackground(Color.black);
        linha1 = new JLabel("Sistema Filmes/Series", JLabel.CENTER);
        linha1.setForeground(Color.BLACK);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(filmeJpg, JLabel.CENTER);
        setLayout(new GridLayout(3,1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuCadastrar = new JMenu("cadastrar");
        JMenuItem menuCadastrarFilme = new JMenuItem("cadastrar filme");
        JMenuItem menuCadastrarSerie = new JMenuItem("cadastrar serie");
        menuCadastrar.add(menuCadastrarFilme);
        menuCadastrar.add(menuCadastrarSerie);
        JMenu menuPesquisar = new JMenu("pesquisar");
        JMenuItem menuPesquisarPorTitulo = new JMenuItem("Digite o titulo");
        menuPesquisar.add(menuPesquisarPorTitulo);

        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        setJMenuBar(barraDeMenu);
    }

    //...
    public static void main(String [] args){
        JFrame janela = new ProgramaMidiasGUIComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
