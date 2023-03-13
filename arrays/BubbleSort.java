package arrays;

import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {

        int[] meuArray1 = {32, 44, 12, 88, 18, 67};
        ordenarBubbleSort(meuArray1);
    }
    public static void ordenarBubbleSort(int[] arrayParaOrdenar) {

        int tamanho = arrayParaOrdenar.length;
        for (int i = 0; i < tamanho; i++) {
            ArrayUtils.imprimir(arrayParaOrdenar);
            for (int j = 1; j < tamanho - i; j++) {
                if(arrayParaOrdenar[j-1]>arrayParaOrdenar[j]) {
                    int temp = arrayParaOrdenar[j-1];
                    arrayParaOrdenar[j-1] = arrayParaOrdenar[j];
                    arrayParaOrdenar[j] = temp;
                    System.out.printf("Trocou %d pelo %d %n", temp, arrayParaOrdenar[j-1]);
                }
            }
        }

    }

}
