package sistema;

import sistema.exceptions.MidiaJaExisteException;
import sistema.exceptions.MidiaNaoExisteException;
import sistema.midias.Midia;

import java.util.*;

public class GerenciadorDeMidias implements SistemaMultimidia {
    private Map<String, Midia> midias;

    public GerenciadorDeMidias(){
        this.midias = new HashMap<>();
    }

    public void cadastrarMidia(Midia midia) throws MidiaJaExisteException {
        if(midias.containsKey(midia.getTitulo())){
            throw new MidiaJaExisteException("Midia já cadastrada: " + midia.getTitulo());
        }
        midias.put(midia.getTitulo(), midia);
    }

    public Collection<Midia> pesquisarPorTitulo(String titulo) {
        Collection<Midia> tituloPesq = new ArrayList<>();
        for(Midia m: midias.values()){
            if(m.getTitulo().equalsIgnoreCase(titulo)){
                tituloPesq.add(m);
            }
        }
        return tituloPesq;
    }

    public Collection<Midia> pesquisarPorAnoLancamento(int anoLancamento) {
        Collection<Midia> anoPesq = new ArrayList<>();
        for(Midia m: midias.values()){
            if(m.getAnoLancamento()==anoLancamento){
                anoPesq.add(m);
            }
        }
        return anoPesq;
    }
    //teste 1

    public Collection<Midia> pesquisarPorGenero(String genero) {
        Collection<Midia> generoPesq = new ArrayList<>();
        for(Midia m: midias.values()){
            if(m.getGenero().equalsIgnoreCase(genero)){
                generoPesq.add(m);
            }
        }
        return generoPesq;
    }

    public Collection<Midia> mostrarTodasAsMidiasCadastradas() {
        return midias.values();
    }

    public void atualizarMidia(String titulo, String novoTitulo, String novoGenero, int novoAnoLancamento) throws MidiaNaoExisteException {
        if(!this.midias.containsKey(titulo)) throw new MidiaNaoExisteException("midia não encontrada " + titulo);
        Midia midia = midias.get(titulo);
        midia.setTitulo(novoTitulo);
        midia.setGenero(novoGenero);
        midia.setAnoLancamento(novoAnoLancamento);
        midias.remove(titulo);
        midias.put(novoTitulo, midia);
    }

    public void removerMidia(String titulo) throws MidiaNaoExisteException {
        if(!midias.containsKey(titulo)){
            throw new MidiaNaoExisteException("midia não encontrada "+titulo);
        }else{
            midias.remove(titulo);
        }
    }

    public Midia getMidia(String titulo) throws MidiaNaoExisteException {
        if (!this.midias.containsKey(titulo)) {
            throw new MidiaNaoExisteException("Midia de titulo '" + titulo + "' não encontrada");
        }
        return this.midias.get(titulo);
    }

    public void salvarDados() {

    }
    public void recuperarDados() {

    }
}
