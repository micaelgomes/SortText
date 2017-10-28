/*
 *	Classe que cont�m os Algoritmos de Ordena��o do projeto.
 */

public class AlgoritmoNum{
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
}
