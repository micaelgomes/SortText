import java.util.Arrays;

public class Algoritmo{
	public static void insertSort(String a []) {   
        int i,j;  String x;

        for (j = 1; j < a.length; j++) {       
            x = a[j]; i = j - 1;

            while (i >= 0) {
                if (x.compareTo(a[i]) > 0) {
                    break;
                }
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = x;
        }
	}
}