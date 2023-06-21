public class JogadorEstadoBanido implements JogadorEstado {

    private JogadorEstadoBanido() {}
    private static JogadorEstadoBanido instance = new JogadorEstadoBanido();

    public static JogadorEstadoBanido getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Banido";
    }
}

