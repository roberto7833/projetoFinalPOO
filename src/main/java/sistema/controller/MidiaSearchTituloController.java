package sistema.controller;

import sistema.SistemaMultimidia;
import sistema.midias.Midia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class MidiaSearchTituloController implements ActionListener {
    private SistemaMultimidia sistema;
    private JFrame janelaPrincipal;

    public MidiaSearchTituloController(SistemaMultimidia sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String titulo = JOptionPane.showInputDialog(janelaPrincipal, "qual titulo deseja procurar? ");
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
    }
}
