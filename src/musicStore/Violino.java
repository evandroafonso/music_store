package musicStore;

public class Violino extends InstrumentosMusicais {

	private static final long serialVersionUID = 1L;

	public String soar() {
		return "Instrumento de cordas, melódico e emite som agudo.";
	}
	public Violino(int preco, int dataConstrucao, String nomeComprador) {
		super(preco, dataConstrucao, nomeComprador);
		this.tipo = "Violino";
	}
}