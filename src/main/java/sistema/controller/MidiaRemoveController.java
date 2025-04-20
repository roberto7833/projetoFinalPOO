package sistema.controller;

import sistema.SistemaMultimidia;
import sistema.exceptions.MidiaNaoExisteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MidiaRemoveController implements ActionListener {
    private SistemaMultimidia sistema;
    private JFrame janelaPrincipal;

    public MidiaRemoveController(SistemaMultimidia sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //remove pelo nome
        String titulo = JOptionPane.showInputDialog(janelaPrincipal, "qual o nome do filme ou serie que deseja remover? ");
        try {
            sistema.removerMidia(titulo);
            JOptionPane.showMessageDialog(janelaPrincipal, "midia removida com sucesso");
        }catch (MidiaNaoExisteException ex){
            JOptionPane.showMessageDialog(janelaPrincipal, "midia não encontrada. "+ " não foi possivel realizar a operação");
        }
    }
}
