package musicStore;

public class Piano extends InstrumentosMusicais {

	private static final long serialVersionUID = 1L;

	public String soar() {
		return "Instrumento de teclas e cordas percutidas, harmônico e melódico"
				+ " - emite sons agudos, médios e graves.";
	}
	public Piano(int numeroSerie, int dataConstrucao, String nomeComprador) {
		super(numeroSerie, dataConstrucao, nomeComprador);
		this.tipo = "Piano";
		
	}
}