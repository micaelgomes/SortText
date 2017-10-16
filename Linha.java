public class Linha{
	private String linha;
	private int countChar;

	Linha(){}

	Linha(String linha, int countChar){
		this.linha = linha;
		this.countChar = countChar;
	}

	public void setLinha(String linha){
		this.linha = linha;
	}

	public String getLinha(){
		return this.linha;
	}

	public void setCountChar(int countChar){
		this.countChar = countChar;
	}

	public int getCountChar(){
		return this.countChar;
	}
}