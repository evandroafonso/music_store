package musicStore;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class MusicStore {
	private ArrayList<InstrumentosMusicais> instrumentosMusicais;

	public MusicStore() {
		this.instrumentosMusicais = new ArrayList<InstrumentosMusicais>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Informe " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public Piano lePiano (){

		String [] valores = new String [3];
		String [] nomeVal = {"o preço do produto", "a Data de Construção", "o Nome do Comprador"};
		valores = leValores (nomeVal);

		int preco = this.retornaInteiro(valores[0]);
		int idade = this.retornaInteiro(valores[1]);
		
		Piano piano = new Piano (preco, idade, valores[2]);
		return piano;
	}

	public Violino leViolino (){

		String [] valores = new String [3];
		String [] nomeVal = {"o número de série", "o ano de fabricação", "o nome do comprador"};;
		valores = leValores (nomeVal);

		int preco = this.retornaInteiro(valores[0]);
		int idade = this.retornaInteiro(valores[1]);

		Violino violino = new Violino (preco,idade,valores[2]);
		return violino;
	}
	
	public Oboe leOboe (){

		String [] valores = new String [3];
		String [] nomeVal = {"o número de série", "o ano de fabricação", "o nome do comprador"};;
		valores = leValores (nomeVal);

		int preco = this.retornaInteiro(valores[0]);
		int idade = this.retornaInteiro(valores[1]);

		Oboe oboe = new Oboe (preco,idade,valores[2]);
		return oboe;
	}

	private boolean intValido(String s) {
		try {
			Integer.parseInt(s); // Método estático, que tenta tranformar uma string em inteiro
			return true;
		} catch (NumberFormatException e) { // Não conseguiu tranformar em inteiro e gera erro
			return false;
		}
	}
	public int retornaInteiro(String entrada) { // retorna um valor inteiro
		int numInt;

		//Enquanto não for possivel converter o valor de entrada para inteiro, permanece no loop
		while (!this.intValido(entrada)) {
			entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um número inteiro.");
		}
		return Integer.parseInt(entrada);
	}

	public void salvaInstrumentos (ArrayList<InstrumentosMusicais> instrumentosMusicais){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("dados.txt"));
			for (int i=0; i < instrumentosMusicais.size(); i++)
				outputStream.writeObject(instrumentosMusicais.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<InstrumentosMusicais> recuperaInstrumentos (){
		ArrayList<InstrumentosMusicais> instrumentosTemp = new ArrayList<InstrumentosMusicais>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("dados.txt"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof InstrumentosMusicais) {
					instrumentosTemp.add((InstrumentosMusicais) obj);
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("Fim de arquivo.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo Instrumentos Musicais não existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return instrumentosTemp;
		}
	}

	public void menuMusicStore (){

		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle MusicStore\n" +
					"Opções:\n" + 
					"1. Nova compra de instrumentos musicais\n" +
					"2. Exibir instrumentos musicais\n" +
					"3. Limpar dados de instrumentos musicais\n" +
					"4. Gravar dados de instrumentos musicais\n" +
					"5. Recuperar dados de instrumentos musicais\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			opc1 = this.retornaInteiro(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de instrumentos musicais\n" +
						"Opções:\n" + 
						"1. Violino\n" +
						"2. Piano\n" +
						"3. Oboé\n";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				opc2 = this.retornaInteiro(entrada);

				switch (opc2){
				case 1: instrumentosMusicais.add((InstrumentosMusicais)leViolino());
				break;
				case 2: instrumentosMusicais.add((InstrumentosMusicais)lePiano());
				break;
				case 3: instrumentosMusicais.add((InstrumentosMusicais)leOboe());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Instrumentos musical não definido!");
				}

				break;
			case 2: // Exibir dados
				if (instrumentosMusicais.size() == 0) {
					JOptionPane.showMessageDialog(null,"Não há dados a serem exibidos! "
												+"É necessário informar um instrumento musical para exibir dados");
					break;
				}
				String dados = "";
				for (int i=0; i < instrumentosMusicais.size(); i++)	{
					dados += instrumentosMusicais.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (instrumentosMusicais.size() == 0) {
					JOptionPane.showMessageDialog(null,"Não há dados a serem limpos! "
												+ "É necessário informar um instrumento musical para limpar dados");
					break;
				}
				instrumentosMusicais.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava Dados
				if (instrumentosMusicais.size() == 0) {
					JOptionPane.showMessageDialog(null,"Não há dados a serem gravados! "
												+ "É necessário informar um instrumento musical para gravar dados");
					break;
				}
				salvaInstrumentos(instrumentosMusicais);
				JOptionPane.showMessageDialog(null,"Dados salvos com sucesso!");
				break;
			case 5: // Recupera Dados
				instrumentosMusicais = recuperaInstrumentos();
				if (instrumentosMusicais.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados recuperados com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo MusicStore");
				break;
			}
		} while (opc1 != 9);
	}


	public static void main (String [] args){

		MusicStore music = new MusicStore ();
		music.menuMusicStore();

	}

}