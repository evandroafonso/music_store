package musicStore;

import java.io.Serializable;

public abstract class InstrumentosMusicais implements Serializable {

	private static final long serialVersionUID = 1L;
	private   int numeroSerie; // n�mero de identifica da loja
	private   int dataConstrucao; // obtem a data de constru��o do instrumento
	private   String nomeComprador; // entrada do nome do novo comprador
	protected String tipo; // obtem informa��es sobre o material de constru��o do instrumento
	
	public InstrumentosMusicais(int numeroSerie, int dataConstrucao, String nomeComprador) {
		this.numeroSerie = numeroSerie; 
		this.dataConstrucao = dataConstrucao;
		this.nomeComprador = nomeComprador;
	}
	public String toString() {
		String retorno = "";
		retorno += "N�mero de s�rie "     + this.numeroSerie     + "\n";
		retorno += "Ano de constru��o: "    + this.dataConstrucao    + "\n";
		retorno += "Comprador: "     + this.nomeComprador     + "\n";
		retorno += "Tipo do instrumento: "  + this.tipo  + "\n";
		retorno += "Caracter�sticas: "  + soar()        + "\n";
		return retorno;
	}
	public abstract String soar();
}