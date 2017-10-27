/*
 *	Classe que é responsável pela leitura do arquivo.  
 */

import java.util.ArrayList;
import java.io.*;

public class Leitor{
	private ArrayList<String> palavras;
	private String [] totalPalavras;
	private int countPalavra;
	private ArrayList<String> palavraByRepeat;
	private Palavra [] totalPalavrasOcorrencia;

	Leitor(){
		this.palavras = new ArrayList<String>();
		this.palavraByRepeat = new ArrayList<String>();
	}
 
	public void setPalavras(ArrayList<String> palavras){
		this.palavras = palavras;
	}

	public ArrayList<String> getPalavras(){
		return this.palavras;
	}	

	public void setCountPalavra(int countPalavra){
		this.countPalavra = countPalavra;
	}

	public int getCountPalavra(){
		return this.countPalavra;
	}

	public String[] getTotalPalavras(){
		return this.totalPalavras;
	}
	
	public void setTotalPalavras(String [] totalPalavras){
		this.totalPalavras = totalPalavras;
	}

	public ArrayList<String> getPalavraByRepeat() {
		return this.palavraByRepeat;
	}

	public void setPalavraByRepeat(ArrayList<String> palavraByRepeat) {
		this.palavraByRepeat = palavraByRepeat;
	}	
	
	public Palavra [] getTotalPalavrasOcorrencia() {
		return totalPalavrasOcorrencia;
	}

	public void setTotalPalavrasOcorrencia(Palavra [] totalPalavrasOcorrencia) {
		this.totalPalavrasOcorrencia = totalPalavrasOcorrencia;
	}
	
	public void openFileMethod1(String caminho) throws IOException{
		InputStream fileByte = new FileInputStream(caminho);
		InputStreamReader fileChar = new InputStreamReader(fileByte);
		BufferedReader buffer = new BufferedReader(fileChar);

		String aux = buffer.readLine();	
		
		while (aux != null){ 
			String [] tmp = aux.split("[ ,.!;:?]");
			for (int i = 0 ; i<tmp.length ; i++ ) {
				if( tmp[i].length() >= 4 ) {
					this.palavras.add(tmp[i]);
				}
			}
			
			aux = buffer.readLine();			
		}

		buffer.close();
		this.countPalavra = this.palavras.size();
		System.out.println("Buffer Carregado!");
		transferListToArray();
	}
		
	public void openFileMethod2(String caminho) throws IOException{
		InputStream fileByte = new FileInputStream(caminho);
		InputStreamReader fileChar = new InputStreamReader(fileByte);
		BufferedReader buffer = new BufferedReader(fileChar);

		String aux = buffer.readLine();	

		while (aux != null){
			String [] tmp = aux.split("[ ,-.!;:?]");
			for (int i = 0 ; i<tmp.length ; i++ ) {
				if(!(this.palavras.contains(tmp[i]))) {
					this.palavras.add(tmp[i]);
				}
				
				this.palavraByRepeat.add(tmp[i]);
			}
			aux = buffer.readLine();	
		}

		buffer.close();
		this.countPalavra = this.palavras.size();
		transferCountingToArray();
	}

	public void transferListToArray(){
		int i = 0;		
		this.totalPalavras = new String[this.countPalavra];
		
		for(String str : this.palavras) {
			this.totalPalavras[i] = str;
			i++;
		}
		
		System.out.println("Vetor Carregado!");
		
		this.palavras.clear();
		this.palavras = null;	
	}
	
	public void transferCountingToArray() {
		int i = 0;
		this.totalPalavrasOcorrencia = new Palavra[this.countPalavra]; 
		
		for(String str : this.palavras) {
			Palavra palavra = new Palavra(str);
			this.totalPalavrasOcorrencia[i] = palavra;
			i++;
		}
		
		for (Palavra palavra : this.totalPalavrasOcorrencia) {
			for (String string : palavraByRepeat) {
				if(palavra.getPalavra().equals(string)) {
					palavra.incrementaOcorrencia();
				}
			}
		}
	}
}