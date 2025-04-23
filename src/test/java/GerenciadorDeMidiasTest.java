
import org.junit.jupiter.api.BeforeEach;

import sistema.GerenciadorDeMidias;
import sistema.exceptions.MidiaJaExisteException;
import sistema.exceptions.MidiaNaoExisteException;
import sistema.midias.Episodio;
import sistema.midias.Filme;
import sistema.midias.Midia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import sistema.midias.Serie;


public class GerenciadorDeMidiasTest {

    private GerenciadorDeMidias sistema;

    @BeforeEach
    public void setUp() {
        sistema = new GerenciadorDeMidias();
    }

    @Test
    public void testarFilme() throws MidiaJaExisteException, MidiaNaoExisteException, IOException {
        Midia filme1 = new Filme("Matrix", "Ação", 1999, "Wachowski", new String[]{"Keanu Reeves"}, "Um hacker descobre a verdade.", 136);
        Filme filme2 = new Filme("O Senhor dos Anéis: A Sociedade do Anel", "Fantasia", 2001, "Peter Jackson", new String[]{"Elijah Wood", "Viggo Mortensen", "Ian McKellen"}, "Um hobbit chamado Frodo Bolseiro herda o Anel Único e parte em uma jornada para destruí-lo.", 178);

        // Testa cadastro
        sistema.cadastrarMidia(filme1);
        sistema.cadastrarMidia(filme2);
        assertEquals(2, sistema.mostrarTodasAsMidiasCadastradas().size());

        // Testa duplicidade
        assertThrows(MidiaJaExisteException.class, () -> sistema.cadastrarMidia(filme1));

        // Testa pesquisa por título
        Collection<Midia> resultadoTitulo = sistema.pesquisarPorTitulo("Matrix");
        assertFalse(resultadoTitulo.isEmpty());

        Collection<Midia> resultadoTitulo2 = sistema.pesquisarPorTitulo("O Senhor dos Anéis: A Sociedade do Anel");
        assertTrue(resultadoTitulo2.size() == 1);

        // Testa pesquisa por ano
        Collection<Midia> resultadoAno = sistema.pesquisarPorAnoLancamento(1999);
        assertFalse(resultadoAno.isEmpty());

        // Testa pesquisa por gênero
        Collection<Midia> resultadoGenero = sistema.pesquisarPorGenero("Ação");
        assertFalse(resultadoGenero.isEmpty());

        // Testa pesquisa por direção
        Collection<Midia> resultadoDirecao = sistema.pesquisarPorDirecao("Wachowski");
        assertFalse(resultadoDirecao.isEmpty());

        // Testa atualização
        sistema.atualizarMidia("Matrix", "Matrix Reloaded", "Ficção", 2003);
        assertNotNull(sistema.pesquisarPorTitulo("Matrix Reloaded"));

        // Testa remoção
        sistema.removerMidia("Matrix Reloaded");
        assertEquals(1, sistema.mostrarTodasAsMidiasCadastradas().size());
    }

    @Test
    public void testaSerie() throws MidiaNaoExisteException, MidiaJaExisteException {

        List<Episodio> episodios = new ArrayList<>();
        episodios.add(new Episodio("Pilot", 22));
        episodios.add(new Episodio("Diversity Day", 22));
        episodios.add(new Episodio("Health Care", 22));
        episodios.add(new Episodio("The Alliance", 22));
        episodios.add(new Episodio("Basketball", 22));
        episodios.add(new Episodio("Hot Girl", 22));
        String [] elencoTheOffice = new String[] {"Steve Carell", "John Krasinski", "Jenna Fischer", "Rainn Wilson"};
        Serie theOffice = new Serie("The Office", "Comédia", 2005, "Greg Daniels", elencoTheOffice, "A série segue a vida dos funcionários da Dunder Mifflin, uma empresa de papel em Scranton, Pensilvânia.", episodios);
        sistema.cadastrarMidia(theOffice);

        // Verifica pesquisa por título
        Collection<Midia> porTitulo = sistema.pesquisarPorTitulo("The Office");
        assertEquals(1, porTitulo.size());

        // Verifica duração total
        assertEquals(132, theOffice.getDuracaoTotal());

        // Verifica média de duração
        assertEquals(22.0, theOffice.getDuracaoMediaEps());

        // Verifica direção e gênero
        Collection<Midia> porDirecao = sistema.pesquisarPorDirecao("Greg Daniels");
        assertEquals(1, porDirecao.size());

        Collection<Midia> porGenero = sistema.pesquisarPorGenero("Comédia");
        assertEquals(1, porGenero.size());

        // Remove e verifica vazio
        sistema.removerMidia("The Office");
        assertEquals(0, sistema.mostrarTodasAsMidiasCadastradas().size());
    }
}

