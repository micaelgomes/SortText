/**
 *
 * Projeto referente à cardeira de Estrutura de Dados II;
 * Objetivo consiste em ordenar textos com os algoritmos lecionados;
 *
 * @author ${Micael Gomes, Leonardo Alves}
 *
 * ${Sort; Algorithm}
 *
 */

import java.io.IOException;
import java.util.ArrayList;

public class Ordenar{
	public static void main(String[] arg) {
		//long initialTime = System.currentTimeMillis();
		switch(arg[1]) {
			case "metodo1" :
				method1(arg[0], arg[2]);
				break;
			case "metodo2" :
				method2(arg[0]);
				break;
			default :
				System.err.printf("Metodo Invalido!\n");
		}

		//long endTime = System.currentTimeMillis();
		//System.out.println("Tempo total em segundos: " + (endTime - initialTime)/1000);
	}

	public static void method1(String algoritmo, String caminho){
		Leitor leitor = new Leitor();

		try{
			leitor.openFileMethod1(caminho);
		}catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",
          	e.getMessage());
		}

		switch(algoritmo){
			case "InsertSort" :
				Algoritmo.insertSort(leitor.getTotalPalavras());
				break;
			case "SelectSort" :
				Algoritmo.selectSort(leitor.getTotalPalavras());
				break;
			case "QuickSort" :
				Algoritmo.qsort(leitor.getTotalPalavras());
				break;
			case "HeapSort" :
				Algoritmo.ordenarHeap(leitor.getTotalPalavras());
				break;
			case "MergeSort" :
				leitor.setTotalPalavras(Algoritmo.mergeSort(leitor.getTotalPalavras()));
				break;
			case "CountSort" :
				//Teste.countingSort(leitor.getTotalPalavras(), leitor);
				break;
			case "ShellSort" :
				Algoritmo.shellSort(leitor.getTotalPalavras());
				break;
			default:
				System.err.printf("Algoritmo de Ordenacao Invalido!\n");
		}

		imprimir(leitor.getTotalPalavras());
		System.out.println("numero de palavras : " + leitor.getCountPalavra());

	}

	public static void method2(String algoritmo){
		Leitor leitor = new Leitor();

		try{
			leitor.openFileMethod2("");
		}catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",
          	e.getMessage());
		}

		//imprimir(leitor.getTotalPalavrasOcorrencia());
	}

	public static void imprimir(Palavra [] text) {
		for (Palavra palavra : text) {
			System.out.printf("%s : %d\n" ,palavra.getPalavra(), palavra.getNumOcorrencia());
		}
	}

	public static void imprimir(String [] str_vet) {
		for (String str : str_vet) {
			System.out.println(str);
		}
	}

	public static void imprimir(ArrayList<String> array) {
		for (String str : array) {
			System.out.println(str);
		}
	}

	public static void imprimir() {
		System.out.println("Desabilitado.");
	}
}
