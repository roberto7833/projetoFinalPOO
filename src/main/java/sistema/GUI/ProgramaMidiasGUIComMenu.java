package sistema.GUI;

import sistema.SistemaMultimidia;
import sistema.GerenciadorDeMidias;
import sistema.midias.GravadorDeDados;
import sistema.controller.*;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ProgramaMidiasGUIComMenu extends JFrame{
    JLabel linha1, linha2;
    ImageIcon filmeJpg = new ImageIcon("./imgs/filmes.png");
    Image imagemRedimensionada = filmeJpg.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);//adicionando
    ImageIcon imagemFinal = new ImageIcon(imagemRedimensionada);//adicionando
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
        //linha2 = new JLabel(filmeJpg, JLabel.CENTER);
        linha2 = new JLabel(imagemFinal, JLabel.CENTER);//adicionando
        linha2.setPreferredSize(new Dimension(400, 300)); //adicionando Define espaço adequado para a imagem

        setLayout(new GridLayout(3,1));

        add(linha1);
        add(linha2);


        add(new JLabel());
        JMenu menuCadastrar = new JMenu("cadastrar");
        JMenuItem menuCadastrarMidia = new JMenuItem("cadastrar Midia");
        menuCadastrar.add(menuCadastrarMidia);
        JMenu menuPesquisar = new JMenu("pesquisar");
        JMenuItem menuPesquisarPorTitulo = new JMenuItem("pesquisar por titulo");
        menuPesquisar.add(menuPesquisarPorTitulo);
        JMenuItem menuPesquisarPorGenero = new JMenuItem("pesquisar por genero");
        menuPesquisar.add(menuPesquisarPorGenero);
        JMenuItem menuPesquisarPorAno = new JMenuItem("pesquisar por ano");
        menuPesquisar.add(menuPesquisarPorAno);
        JMenuItem menuPesquisarDiretor = new JMenuItem("pesquisar pelo diretor");
        menuPesquisar.add(menuPesquisarDiretor);
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverMidia = new JMenuItem("Remover Midia");
        menuRemover.add(menuRemoverMidia);
        menuPesquisarPorTitulo.addActionListener(new MidiaSearchTituloController(midias, this));
        menuPesquisarPorGenero.addActionListener(new MidiaSearchGeneroController(midias, this));
        menuPesquisarPorAno.addActionListener(new MidiaSearchAnoController(midias, this));
        menuPesquisarDiretor.addActionListener(new MidiaSearchDiretorController(midias, this));
        menuRemoverMidia.addActionListener(new MidiaRemoveController(midias, this));
        menuCadastrarMidia.addActionListener(new MidiaAddController(midias, this));

        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        setJMenuBar(barraDeMenu);
    }



    //...
    public static void main(String [] args) throws IOException {


        JFrame janela = new ProgramaMidiasGUIComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }
}
