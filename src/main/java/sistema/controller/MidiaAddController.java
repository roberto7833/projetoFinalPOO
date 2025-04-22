package sistema.controller;

import sistema.GerenciadorDeMidias;
import sistema.SistemaMultimidia;
import sistema.exceptions.MidiaJaExisteException;
import sistema.exceptions.MidiaNaoExisteException;
import sistema.midias.Midia;
import sistema.midias.MidiaFormulario;
import sistema.midias.Filme;
import sistema.midias.Serie;
import sistema.midias.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MidiaAddController implements ActionListener {
    private SistemaMultimidia sistema;
    private JFrame janelaPrincipal;

    public MidiaAddController(SistemaMultimidia sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        }
    }
