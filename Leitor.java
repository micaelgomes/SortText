/*
 *	Classe que é responsável pela leitura do arquivo.
 */

import java.util.ArrayList;
import java.io.*;

public class Leitor{
	private ArrayList<String> listaTmpPalavra = new ArrayList<String>();
	private ArrayList<String> listaTmpPalavraTotal = new ArrayList<String>();
	private String [] palavras;
	private Palavra [] palavrasOcorrencia;

	Leitor(){}

	public void setPalavras(String [] palavras){
		this.palavras = palavras;
	}

	public String [] getPalavras(){
		return this.palavras;
	}

	public void setPalavrasOcorrencia(Palavra [] palavrasOcorrencia){
		this.palavrasOcorrencia = palavrasOcorrencia;
	}

	public Palavra [] getPalavrasOcorrencia(){
		return this.palavrasOcorrencia;
	}

	public void openFileMethod1(String caminho) throws IOException{
		BufferedReader buffRead = new BufferedReader(new FileReader(caminho));
		String aux = buffRead.readLine();

		while (aux != null){
			String [] tmp = aux.split("[ ,.!;:?]");
			for ( String str : tmp ) {
				if(str.length() >= 4){
					this.listaTmpPalavra.add(str);
				}
			}
			aux = buffRead.readLine();
		}

		buffRead.close();
		System.out.println("Buffer Carregado!");
		listToArray();
		System.out.println("Vetor Carregado!");
	}

	public void listToArray(){
		this.palavras = new String[this.listaTmpPalavra.size()];
		int i = 0;
		for (String str : this.listaTmpPalavra) {
			this.palavras[i] = str;
			i++;
		}
	}

	public void openFileMethod2(String caminho) throws IOException{
		BufferedReader buffRead = new BufferedReader(new FileReader(caminho));
		String aux = buffRead.readLine();

		while (aux != null){
			String [] tmp = aux.split("[ ,.!;:?]");
			for ( String str : tmp ) {
				if(!(this.listaTmpPalavra.contains(str))){
					this.listaTmpPalavra.add(str);
				}
				this.listaTmpPalavraTotal.add(str);
			}
			aux = buffRead.readLine();
		}

		buffRead.close();
		System.out.println("Buffer Carregado!");
		transferCountingToArray();
		System.out.println("Vetor Carregado!");
	}

	public void transferCountingToArray() {
		int i = 0;
		this.palavrasOcorrencia = new Palavra[this.listaTmpPalavra.size()];

		for(String str : this.listaTmpPalavra) {
			Palavra palavra = new Palavra(str);
			this.palavrasOcorrencia[i] = palavra;
			i++;
		}

		for (Palavra palavra : this.palavrasOcorrencia) {
			for (String string : listaTmpPalavraTotal) {
				if(palavra.getPalavra().equals(string)) {
					palavra.incrementaOcorrencia();
				}
			}
		}
	}
}
