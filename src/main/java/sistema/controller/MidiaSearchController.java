package sistema.controller;

import sistema.SistemaMultimidia;
import sistema.midias.Midia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class MidiaSearchController implements ActionListener {
    private SistemaMultimidia sistema;
    private JFrame janelaPrincipal;

    public MidiaSearchController(SistemaMultimidia sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String titulo = JOptionPane.showInputDialog(janelaPrincipal, "qual titulo deseja procurar? ");
        int ano = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "qual o ano a pesquisar"));
        String genero = JOptionPane.showInputDialog(janelaPrincipal, "qual genero deseja procurar? ");
        //pesquisando por titulo
        Collection<Midia> tituloPesq = sistema.pesquisarPorTitulo(titulo);
        if(tituloPesq.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal, "Midias encontradas: ");
            for(Midia m: tituloPesq){
                JOptionPane.showMessageDialog(janelaPrincipal, m.toString());
            }
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal, "não foi encontrado nenhuma midia com esse titulo");
        }
        //pesquisando por ano
        Collection<Midia> anoPesq = sistema.pesquisarPorAnoLancamento(ano);
        if(anoPesq.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal, "Midias encontradas");
            for(Midia m: anoPesq){
                JOptionPane.showMessageDialog(janelaPrincipal, m.toString());
            }
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal, "não foi encontrado nenhuma midia para o ano pesquisado");
        }
        //pesquisando por genero
        Collection<Midia> generoPesq = sistema.pesquisarPorGenero(genero);
        if(generoPesq.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal, "Midias encontradas");
            for(Midia m: generoPesq){
                JOptionPane.showMessageDialog(janelaPrincipal, m.toString());
            }
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal, "não foi encontrado nenhuma midia para o genero pesquisado");
        }
    }
}
