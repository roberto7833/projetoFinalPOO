package sistema.controller;

import sistema.SistemaMultimidia;
import sistema.midias.Midia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class MidiaSearchAnoController implements ActionListener{
    private SistemaMultimidia sistema;
    private JFrame janelaPrincipal;

    public MidiaSearchAnoController(SistemaMultimidia sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int ano = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "qual o ano a pesquisar"));
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
    }
}
