package aula03_complexidade_exercicios;

import arrays.ArrayUtils;

public class ExemplosComArrays {

    public static void main(String[] args) {
        int[] meuArray = new int[10];
        ArrayUtils.preencherArrayComValoresInteirosAleatorios(meuArray, 10, false);
        for (int n = 0; n < 600; n++) {
            ArrayUtils.valorExisteNoArray(meuArray, 80);
        }



    }
}
