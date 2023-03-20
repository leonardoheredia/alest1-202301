package aula07_pesquisa_ordenacao;

import arrays.ArrayUtils;

public class Aula07_Pesquisa_Ordenacao {

    public static void main(String[] args) {
        int[] arrayInteiros = {82, 32, 77, 45, 25};
        //int[] arrayInteiros = {5, 1, 4, 2, 8};
        //int[] arrayInteiros = {5, 1, 4, 2, 8};
        ArrayUtils.imprimir(arrayInteiros);

        BubbleSort bs = new BubbleSort();
        bs.ordenar(arrayInteiros);

        ArrayUtils.imprimir(arrayInteiros);
        /*
        int[] arrayInteiros = {40, 10, 50, 60, 70, 29, 44, 80};
        ArrayUtils.imprimir(arrayInteiros);

        MergeSort ms = new MergeSort();
        ms.ordernar(arrayInteiros);

        ArrayUtils.imprimir(arrayInteiros);
        */


    }
}
