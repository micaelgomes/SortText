/*
 *	Classe que cont�m os Algoritmos de Ordena��o do projeto.
 */

 public class Algoritmo{

 //insertSTART
 public static void insertSort(String [] array) {
        String temp;
         for (int i = 1; i < array.length ; i++) {
             for(int j = i ; j > 0 ; j--){
                 if(array[j].substring(0, 2).compareTo(array[j-1].substring(0, 2)) < 0){
                     temp = array[j];
                     array[j] = array[j-1];
                     array[j-1] = temp;
                 }
             }
         }
 }
 //insertEND
 //selectSTART
 public static void selectSort(String a []) {
 	for (int i = 0; i < a.length - 1; ++i) {
 		int minIndex = i;
 		for (int j = i + 1; j < a.length; ++j){
 			if (a[j].substring(0, 2).compareTo(a[minIndex].substring(0, 2)) < 0){
 				minIndex = j;
 			}
 		}

 		String temp = a[i];
 		a[i] = a[minIndex];
 		a[minIndex] = temp;
 	}
 }
 //selectEND

 //heapSTART
 public static void ordenarHeap(String[] v) {
 	constroiMaximaOrdem(v);
 	int n = v.length;

 	for (int i = v.length - 1; i > 0; i--) {
 		swap(v, i, 0);
 		ordenaDescendo(v, 0, --n);
 	}
 }

 private static void constroiMaximaOrdem(String[] v) {
 	for (int i = v.length / 2 - 1; i >= 0; i--)
 		ordenaDescendo(v, i, v.length);
 }

 private static void ordenaDescendo(String[] vetor, int pos, int tamanhoDoVetor) {
 	int max = 2 * pos + 1, right = max + 1;
 	if (max < tamanhoDoVetor) {
 		if ((right < tamanhoDoVetor) && (vetor[max].substring(0, 2).compareTo(vetor[right].substring(0, 2))) < 0)
 			max = right;
 		if (vetor[max].substring(0, 2).compareTo(vetor[pos].substring(0, 2)) > 0) {
 			swap(vetor, max, pos);
 			ordenaDescendo(vetor, max, tamanhoDoVetor);
 		}
 	}
 }

 public static void swap(String[] v, int j, int aposJ) {
 	String aux = v[j];
 	v[j] = v[aposJ];
 	v[aposJ] = aux;
 }
 //heapEND

 //mergeSTART
 public static String [] mergeSort(String[] list) {
 	String [] sorted = new String[list.length];
 	if (list.length == 1) {
 		sorted = list;
 	} else {
 		int mid = list.length/2;
 		String[] left = null;
 		String[] right = null;
 		if ((list.length % 2) == 0) {
 			left = new String[list.length/2];
 			right = new String[list.length/2];
 		} else {
 			left = new String[list.length/2];
 			right = new String[(list.length/2)+1];
 		}
 		int x=0;
 		int y=0;
 		for ( ; x < mid; x++) {
 			left[x] = list[x];
 		}
 		for ( ; x < list.length; x++) {
 			right[y++] = list[x];
 		}
 		left = mergeSort(left);
 		right = mergeSort(right);
 		sorted = mergeArray(left,right);
 	}

 	return sorted;
 }

 private static String[] mergeArray(String[] left, String[] right) {
 	String[] merged = new String[left.length+right.length];
 	int lIndex = 0;
 	int rIndex = 0;
 	int mIndex = 0;
 	int comp = 0;
 	while (lIndex < left.length || rIndex < right.length) {
 		if (lIndex == left.length) {
 			merged[mIndex++] = right[rIndex++];
 		} else if (rIndex == right.length) {
 			merged[mIndex++] = left[lIndex++];
 		} else {
 			comp = left[lIndex].substring(0, 2).compareTo(right[rIndex].substring(0, 2));
 			if (comp > 0) {
 				merged[mIndex++] = right[rIndex++];
 			} else if (comp < 0) {
 				merged[mIndex++] = left[lIndex++];
 			} else {
 				merged[mIndex++] = left[lIndex++];
 			}
 		}
 	}
 	return merged;
 }
 //mergeEND

 //quickSTART
 public static void qsort(String[] list) {
 	quicksort(list, 0, list.length-1);
 }

 private static void quicksort(String[] list, int p, int r) {
 	if (p < r) {
 	int q = partition(list,p,r);
 	if (q == r) {
 	q--;
 	}
 	quicksort(list,p,q);
 	quicksort(list,q+1,r);
 	}
 }

 private static int partition (String[] list, int p, int r) {
 	String pivot = list[p];
 	int lo = p;
 	int hi = r;

 	while (true) {
 	while (list[hi].substring(0, 2).compareTo(pivot.substring(0, 2)) >= 0 &&
 		lo < hi) {
 	hi--;
 	}
 	while (list[lo].substring(0, 2).compareTo(pivot.substring(0,2)) < 0 &&
 		lo < hi) {
 	lo++;
 	}
 	if (lo < hi) {
 	String T = list[lo];
 	list[lo] = list[hi];
 	list[hi] = T;
 	}
 	else return hi;
 	}
 }
 //quickEND

 //shellSTART
 public static void shellSort(String[] v) {
 	int i , j , h = 1;
 	String value;

 	do {
 		h = 3 * h + 1;

 	} while ( h < v.length );

 	do {
 		h = h / 3;

 		for( i = h; i < v.length; i++) {

 			value = v[i];
 			j = i - h;

 			while (j >= 0 && v[j].substring(0, 2).compareTo(value.substring(0, 2)) > 0) {
 				v [ j + h ] = v [ j ];
 				j = j - h;
 			}

 			v [ j + h ] = value;
 		}
 	} while ( h > 1 );

 }
 //shellEND
 }
