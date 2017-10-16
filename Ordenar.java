import java.io.IOException;
import java.util.ArrayList;

public class Ordenar{
	public static void main(String[] arg) {
		ArrayList<String> textOrdenado = new ArrayList<String>();

		if(arg[0] != null){
			switch(arg[0]){
				case "InsertSort" :
					fileToMemory();
					break;
				case "SelectSort" :
					break;
				case "QuickSort" :
					break;
				case "HeapSort" :
					break;
				case "MergeSort" :
					break;
				case "CountSort" :
					break;
				default:
					System.err.printf("Algoritmo de Ordenacão inválido!\n");
			}
		}else{
			System.out.printf("Argumentos Ausentes;\n");
			System.out.printf("Impossivel prosseguir.\n");
		}
	}

	public static void fileToMemory(){
		Leitor leitor = new Leitor();

		try{
			leitor.openFile("/home/micaelgoms/projetoED/textos/test.txt");
		}catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",
          	e.getMessage());
		}	

		leitor.generateWordTable();
		System.out.println(leitor.getCountPalavra());
		//leitor.imprimi();	
				
		Algoritmo.insertSort(leitor.getTotal());
	
		for (String str : leitor.getTotal()) {
			System.out.println(str);
		}
	}
}