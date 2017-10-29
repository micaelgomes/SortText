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
		switch(arg[1]) {
			case "metodo1" :
				/*recebe como argumento o algoritmo de ordenação e o diretório do arquivo que será ordenado.
				Faz a chamada da função que trará o arquivo para um buffer e executará a ordenação em cima
				do arquivo na memória. */
				method1(arg[0], arg[2]);
				break;
			case "metodo2" :
				/* recebe como argumento o algoritmo de ordenação e o diretório do arquivo que será ordenado.
				Faz a chamada da função que trará o arquivo para um buffer e executará a ordenação em cima
				do arquivo na memória.*/
				method2(arg[0], arg[2]);
				break;
			default :
				System.err.printf("Metodo Invalido!\n");
		}
	}

	public static void method1(String algoritmo, String caminho){
		Leitor leitor = new Leitor();

		try{
			leitor.openFileMethod1(caminho);
		}catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",
          	e.getMessage());
		}

		System.out.println("Ordenando...");
		switch(algoritmo){
			case "InsertSort" :
				Algoritmo.insertSort(leitor.getPalavras());
				break;
			case "SelectSort" :
				Algoritmo.selectSort(leitor.getPalavras());
				break;
			case "QuickSort" :
				Algoritmo.qsort(leitor.getPalavras());
				break;
			case "HeapSort" :
				Algoritmo.ordenarHeap(leitor.getPalavras());
				break;
			case "MergeSort" :
				leitor.setPalavras(Algoritmo.mergeSort(leitor.getPalavras()));
				break;
			case "CountSort" :
				System.err.printf("Não implementado!\n");
				break;
			case "ShellSort" :
				Algoritmo.shellSort(leitor.getPalavras());
				break;
			default:
				System.err.printf("Algoritmo de Ordenacao Invalido!\n");
		}
	}

	public static void method2(String algoritmo, String caminho){
		Leitor leitor = new Leitor();

		try{
			leitor.openFileMethod2(caminho);
		}catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n",
          	e.getMessage());
		}

		System.out.println("Ordenando...");
		switch(algoritmo){
			case "InsertSort" :
				AlgoritmoNum.insertSort(leitor.getPalavrasOcorrencia());
				break;
			case "SelectSort" :
				AlgoritmoNum.selectSort(leitor.getPalavrasOcorrencia());
				break;
			case "QuickSort" :
				AlgoritmoNum.sort(leitor.getPalavrasOcorrencia());
				break;
			case "HeapSort" :
				AlgoritmoNum.heapSort(leitor.getPalavrasOcorrencia());
				break;
			case "MergeSort" :
				AlgoritmoNum.mergeSort(leitor.getPalavrasOcorrencia());
				break;
			case "CountSort" :
				leitor.setPalavrasOcorrencia(AlgoritmoNum.countSort(leitor.getPalavrasOcorrencia()));
				break;
			case "ShellSort" :
				AlgoritmoNum.shellSort(leitor.getPalavrasOcorrencia());
				break;
			default:
				System.err.printf("Algoritmo de Ordenacao Invalido!\n");
		}

		for (Palavra palavra : leitor.getPalavrasOcorrencia()) {
			System.out.printf("%s repete : %d\n", palavra.getPalavra(), palavra.getNumOcorrencia());
		}
	}
}
