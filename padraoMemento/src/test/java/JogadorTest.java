import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JogadorTest {

    @Test
    void deveArmazenarEstados() {
        Jogador jogador = new Jogador();
        jogador.setEstado(JogadorEstadoAtivo.getInstance());
        jogador.setEstado(JogadorEstadoSuspenso.getInstance());
        assertEquals(2, jogador.getEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        Jogador jogador = new Jogador();
        jogador.setEstado(JogadorEstadoAtivo.getInstance());
        jogador.setEstado(JogadorEstadoSuspenso.getInstance());
        jogador.restauraEstado(0);
        assertEquals(JogadorEstadoAtivo.getInstance(), jogador.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        Jogador jogador = new Jogador();
        jogador.setEstado(JogadorEstadoAtivo.getInstance());
        jogador.setEstado(JogadorEstadoSuspenso.getInstance());
        jogador.setEstado(JogadorEstadoAtivo.getInstance());
        jogador.setEstado(JogadorEstadoBanido.getInstance());
        jogador.restauraEstado(2);
        assertEquals(JogadorEstadoAtivo.getInstance(), jogador.getEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            Jogador jogador = new Jogador();
            jogador.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

}
