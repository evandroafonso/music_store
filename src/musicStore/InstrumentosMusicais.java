package musicStore;

import java.io.Serializable;

public abstract class InstrumentosMusicais implements Serializable {

	private static final long serialVersionUID = 1L;
	private   int numeroSerie; // número de identifica da loja
	private   int dataConstrucao; // obtem a data de construção do instrumento
	private   String nomeComprador; // entrada do nome do novo comprador
	protected String tipo; // obtem informações sobre o material de construção do instrumento
	
	public InstrumentosMusicais(int numeroSerie, int dataConstrucao, String nomeComprador) {
		this.numeroSerie = numeroSerie; 
		this.dataConstrucao = dataConstrucao;
		this.nomeComprador = nomeComprador;
	}
	public String toString() {
		String retorno = "";
		retorno += "Número de série "     + this.numeroSerie     + "\n";
		retorno += "Ano de construção: "    + this.dataConstrucao    + "\n";
		retorno += "Comprador: "     + this.nomeComprador     + "\n";
		retorno += "Tipo do instrumento: "  + this.tipo  + "\n";
		retorno += "Características: "  + soar()        + "\n";
		return retorno;
	}
	public abstract String soar();
}