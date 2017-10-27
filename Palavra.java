
public class Palavra {
	private String palavra;
	private int numOcorrencia = 0;
	
	public Palavra(){}

	public Palavra(String palavra) {
		this.palavra = palavra;
	}
	
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	public int getNumOcorrencia() {
		return numOcorrencia;
	}
	public void setNumOcorrencia(int numOcorrencia) {
		this.numOcorrencia = numOcorrencia;
	}
	
	
	public void incrementaOcorrencia() {
		this.numOcorrencia = this.numOcorrencia + 1; 
	}
}
