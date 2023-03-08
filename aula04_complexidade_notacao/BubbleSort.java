package aula04_complexidade_notacao;

import arrays.ArrayUtils;

public class BubbleSort {


    private int operacoes;

    public int getOperacoes() {
        return operacoes;
    }

    public void ordenar(int[] arrayInteiros) {
        operacoes = 0;
        int tamanho = arrayInteiros.length;
        for (int i = 0; i < tamanho; i++) {
            //ArrayUtils.imprimir(arrayParaOrdenar);
            for (int j = i + 1; j < tamanho; j++) {
                if(arrayInteiros[j]<arrayInteiros[i]) {
                    int temp = arrayInteiros[i];
                    arrayInteiros[i] = arrayInteiros[j];
                    arrayInteiros[j] = temp;
                    operacoes++;
                    //System.out.printf("Trocou %d pelo %d %n", temp, arrayParaOrdenar[j-1]);
                }
                operacoes++;
            }
        }
    }

}