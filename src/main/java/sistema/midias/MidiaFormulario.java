package sistema.midias;

import javax.swing.*;
import java.awt.*;

public class MidiaFormulario {


    // Método criado apenas para melhorar a interface
    // Retorna Midia, senao ele retorna nulo
    static public Midia criaFormularioBase() {

        JTextField tituloField = new JTextField(10);
        JTextField anoField = new JTextField(4);
        JTextField generoField = new JTextField(10);
        JTextField direcaoField = new JTextField(10);
        JTextField sinopseField = new JTextField(20);
        JTextField elencoField = new JTextField(20);

        // Grid following the config rows=0 and cols=1
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Título:"));
        panel.add(tituloField);
        panel.add(new JLabel("Ano de lançamento:"));
        panel.add(anoField);
        panel.add(new JLabel("Gênero:"));
        panel.add(generoField);
        panel.add(new JLabel("Direção:"));
        panel.add(direcaoField);
        panel.add(new JLabel("Sinopse:"));
        panel.add(sinopseField);
        panel.add(new JLabel("Elenco (separado por vírgulas):"));
        panel.add(elencoField);

        int result = JOptionPane.showConfirmDialog(null,
                panel, "Preencha os dados",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String titulo = tituloField.getText();
            int ano = Integer.parseInt(anoField.getText());
            String genero = generoField.getText();
            String direcao = direcaoField.getText();
            String sinopse = sinopseField.getText();
            String[] elenco = elencoField.getText().split(",");

            return new Midia(titulo, genero, ano, direcao, elenco, sinopse);
        }
        return null;
    }
}
