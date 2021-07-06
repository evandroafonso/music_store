package musicStore;

public class Oboe extends InstrumentosMusicais {

	private static final long serialVersionUID = 1L;

	public String soar() {
		return "Instrumento de sopro melódico - emite som agudo e aveludado";
	}
	public Oboe(int preco, int dataConstrucao, String nomeComprador) {
		super(preco, dataConstrucao, nomeComprador);
		this.tipo = "Oboé";
	}
}