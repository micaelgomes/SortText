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
   public static void heapify(int arr[], int n, int i) {
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
}
