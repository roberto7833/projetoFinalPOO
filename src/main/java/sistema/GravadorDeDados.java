package sistema;

import sistema.midias.Midia;

import java.io.*;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class GravadorDeDados {

    public static final String ARQUIVO_MIDIAS = "Midias.dat";

    public HashMap<String, Midia> recuperarMidia()throws IOException{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_MIDIAS))){
            return (HashMap<String, Midia>) in.readObject();
        } catch (ClassNotFoundException e){
            throw new IOException(e);
        }
    }
    public void salvarMidia(HashMap<String, Midia> midias)throws IOException{
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_MIDIAS))){
            out.writeObject(midias);
        }
    }
}
