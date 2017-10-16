import java.util.ArrayList;
import java.io.*;

public class Leitor{
	private ArrayList<Linha> texto;
	private ArrayList<String> palavras;
	private int countLinha = 0;
	private int countPalavra = 0;

	private String[] total;

	Leitor(){
		this.texto = new ArrayList<Linha>();
	}

	public void setTexto(ArrayList<Linha> texto){
		this.texto = texto;
	}

	public ArrayList<Linha> getTexto(){
		return this.texto;
	}
 
	public void setPalavras(ArrayList<String> palavras){
		this.palavras = palavras;
	}

	public ArrayList<String> getPalavras(){
		return this.palavras;
	}	

	public void setCountLinha(int countLinha){
		this.countLinha = countLinha;
	}

	public int getCountLinha(){
		return this.countLinha;
	}

	public void setCountPalavra(int countPalavra){
		this.countPalavra = countPalavra;
	}

	public int getCountPalavra(){
		return this.countPalavra;
	}

	public String[] getTotal(){
		return this.total;
	}

	public void openFile(String caminho) throws IOException{
		InputStream fileByte = new FileInputStream(caminho);
		InputStreamReader fileChar = new InputStreamReader(fileByte);
		BufferedReader buffer = new BufferedReader(fileChar);

		String aux = buffer.readLine();	

		while (aux != null){
			this.countLinha = this.countLinha + 1;			
			Linha linha = new Linha(aux, aux.length());
			this.texto.add(linha);
			aux = buffer.readLine();			
		}

		buffer.close();
	}

	public void imprimi(){
		for(Linha linha : this.texto){
			System.out.printf("%s\n", linha.getLinha());
		}
	}

	public void updateCount(){
		for(Linha linha : this.texto){
			if(linha.getCountChar() > 0){
				String palavra[] = linha.getLinha().split(" ");
				this.countPalavra = this.countPalavra + palavra.length;
			}
		}
	}

	public void generateWordTable(){
		updateCount();
		this.total = new String[this.countPalavra];
		int k =0;

		for(Linha linha : this.texto){
			if(linha.getCountChar() > 0){
				String palavra[] = linha.getLinha().split(" ");
				for (int i = 0 ; i<palavra.length ; i++ ) {
					this.total[k] = palavra[i];
					k = k + 1;
				}
			}
		}
	}
}