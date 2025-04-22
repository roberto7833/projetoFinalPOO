package sistema.controller;

import sistema.SistemaMultimidia;
import sistema.midias.Midia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class MidiaSearchGeneroController implements ActionListener{
    private SistemaMultimidia sistema;
    private JFrame janelaPrincipal;

    public MidiaSearchGeneroController(SistemaMultimidia sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String genero = JOptionPane.showInputDialog(janelaPrincipal, "qual genero deseja procurar? ");
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
