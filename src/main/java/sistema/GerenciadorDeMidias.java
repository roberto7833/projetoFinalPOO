package sistema;

import sistema.exceptions.MidiaJaExisteException;
import sistema.exceptions.MidiaNaoExisteException;
import sistema.midias.Midia;
import sistema.midias.GravadorDeDados;

import java.io.IOException;
import java.util.*;

public class GerenciadorDeMidias implements SistemaMultimidia {
    private HashMap<String, Midia> midias;
    private GravadorDeDados gravador;

    public GerenciadorDeMidias(){
        this.midias = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }

    public void cadastrarMidia(Midia midia) throws MidiaJaExisteException {
        if(this.midias.containsKey(midia.getTitulo())){
            throw new MidiaJaExisteException("já existe uma midia cadastrada com esse nome");
        }else{
            this.midias.put(midia.getTitulo(), midia);
            //salvarDados();
        }
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
    public Collection<Midia> pesquisarPorDirecao(String diretor){
        Collection<Midia> diretorPesq = new ArrayList<>();
        for(Midia m: midias.values()){
            if(m.getDirecao().equalsIgnoreCase(diretor)){
                diretorPesq.add(m);
            }
        }
        return diretorPesq;
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
    @Override
    public void salvarDados()throws IOException {
        this.gravador.salvarMidia(this.midias);
    }
    @Override
    public void recuperarDados()throws IOException {
        this.midias = this.gravador.recuperarMidia();
    }
}
