package sistema.controller;

import sistema.SistemaMultimidia;
import sistema.midias.Midia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class MidiaSearchDiretorController implements ActionListener{
    private SistemaMultimidia sistema;
    private JFrame janelaPrincipal;

    public MidiaSearchDiretorController(SistemaMultimidia sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String diretor = JOptionPane.showInputDialog(janelaPrincipal, "digite o nome do diretor");
        //pesquisar por diretor
        Collection<Midia> diretorPesq = sistema.pesquisarPorDirecao(diretor);
        if(diretorPesq.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal, "Midias encontradas");
            for(Midia m: diretorPesq){
                JOptionPane.showMessageDialog(janelaPrincipal, m.toString());
            }
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal, "diretor não encontrado");
        }
    }
}
