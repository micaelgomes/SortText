/*
 *	Classe que cont�m os Algoritmos de Ordena��o do projeto.
 */

public class AlgoritmoNum{
    //insertSTART
    public static void insertSort(Palavra [] array) {
        Palavra temp;
        for (int i = 1; i < array.length ; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j].getNumOcorrencia() > array[j-1].getNumOcorrencia()){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    //insertEND

    //selectSTART
    public static void selectSort(Palavra [] array){
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j].getNumOcorrencia() > array[index].getNumOcorrencia())
                    index = j;

            Palavra smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }
    //selectEND

    //countSTART
    public static Palavra [] countSort(Palavra[] array) {
        Palavra [] aux = new Palavra[array.length];
        Palavra min = array[0];
        Palavra max = array[0];

        for (int i = 1; i < array.length; i++) {
             if (array[i].getNumOcorrencia() < min.getNumOcorrencia()) {
               min = array[i];
           }else if (array[i].getNumOcorrencia() > max.getNumOcorrencia()) {
               max = array[i];
             }
        }

        int[] counts = new int[max.getNumOcorrencia() - min.getNumOcorrencia() + 1];

       for (int i = 0;  i < array.length; i++) {
         counts[array[i].getNumOcorrencia() - min.getNumOcorrencia()]++;
       }

       counts[0]--;
       for (int i = 1; i < counts.length; i++) {
         counts[i] = counts[i] + counts[i-1];
       }
       for (int i = array.length - 1; i >= 0; i--) {
           aux[counts[array[i].getNumOcorrencia() - min.getNumOcorrencia()]--] = array[i];
       }

       return aux;
    }
    //countEND

    //shellSTART
    public static void shellSort(Palavra [] array) {
    	int i , j , h = 1;
    	Palavra value;

       do {
    		h = 3 * h + 1;

    	} while ( h < array.length );

    	do {
    		h = h / 3;

    		for( i = h; i < array.length; i++) {

    			value = array[i];
    			j = i - h;

    			while (j >= 0 && array[j].getNumOcorrencia() < value.getNumOcorrencia()) {
    				array[ j + h ] = array[ j ];
    				j = j - h;
    			}

    			array[ j + h ] = value;
    		}
    	} while ( h > 1 );

    }
    //shellEND

    //heapSTART
    public static void heapSort(Palavra [] arry){
       int n = arry.length;

       for (int i = n / 2 - 1; i >= 0; i--)
           heapify(arry, n, i);

       for (int i=n-1; i>=0; i--){
           Palavra temp = arry[0];
           arry[0] = arry[i];
           arry[i] = temp;
           heapify(arry, i, 0);
       }
   }
   public static void heapify(Palavra [] arr, int n, int i) {
       int largest = i;
       int l = 2*i + 1;
       int r = 2*i + 2;

       if (l < n && arr[l].getNumOcorrencia() > arr[largest].getNumOcorrencia())
           largest = l;

       if (r < n && arr[r].getNumOcorrencia() > arr[largest].getNumOcorrencia())
           largest = r;

       if (largest != i)
       {
           Palavra swap = arr[i];
           arr[i] = arr[largest];
           arr[largest] = swap;
           heapify(arr, n, largest);
       }
   }
    //heapEND

    //mergeSTART
    public static void merge(Palavra arr[], int l, int m, int r){
       int n1 = m - l + 1;
       int n2 = r - m;

       Palavra L[] = new Palavra [n1];
       Palavra R[] = new Palavra [n2];

       for (int i=0; i<n1; ++i)
           L[i] = arr[l + i];
       for (int j=0; j<n2; ++j)
           R[j] = arr[m + 1+ j];

       int i = 0, j = 0;

       int k = l;
       while (i < n1 && j < n2){
           if (L[i].getNumOcorrencia() <= R[j].getNumOcorrencia()){
               arr[k] = L[i];
               i++;
           }
           else{
               arr[k] = R[j];
               j++;
           }
           k++;
       }

       while (i < n1){
           arr[k] = L[i];
           i++;
           k++;
       }

       while (j < n2){
           arr[k] = R[j];
           j++;
           k++;
       }
   }

   public static void sort(Palavra []arr, int l, int r){
       if (l < r){
           int m = (l+r)/2;
           sort(arr, l, m);
           sort(arr , m+1, r);
           merge(arr, l, m, r);
       }
   }

   public static void mergeSort(Palavra [] array){
       sort(array, 0, array.length-1);
   }
    //mergeEND

    //quickSTART
    public static void sort(Palavra [] array) {
        Palavra [] palavras;
        int tam;

        if (array ==null || array.length==0){
            return;
        }
        palavras = array;
        tam = array.length;
        quicksort(0, tam - 1, palavras);
    }

    private static void quicksort(int low, int high, Palavra [] palavras) {
        int i = low, j = high;

        Palavra pivot = palavras[low + (high-low)/2];

        while (i <= j) {
            while (palavras[i].getNumOcorrencia() < pivot.getNumOcorrencia()) {
                i++;
            }

            while (palavras[j].getNumOcorrencia() > pivot.getNumOcorrencia()) {
                j--;
            }

            if (i <= j) {
                exchange(i, j, palavras);
                i++;
                j--;
            }
        }

        if (low < j)
            quicksort(low, j, palavras);
        if (i < high)
            quicksort(i, high, palavras);
    }

    private static void exchange(int i, int j, Palavra [] palavras) {
        Palavra temp = palavras[i];
        palavras[i] = palavras[j];
        palavras[j] = temp;
    }
    //quickEND
}
