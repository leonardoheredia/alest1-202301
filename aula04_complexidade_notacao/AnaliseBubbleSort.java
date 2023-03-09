package aula04_complexidade_notacao;

import arrays.ArrayUtils;

public class AnaliseBubbleSort {

    public static void main(String[] args) {

        System.out.println("N;bubble");
        for (int N = 5; N < 100; N++) {
            int[] meuArray = new int[N];
            ArrayUtils.preencherArrayComValoresInteirosAleatorios(meuArray, 100, true);
            BubbleSort bs = new BubbleSort();
            bs.ordenar(meuArray);
            int operacoes = bs.getOperacoes();
            System.out.println(N + ";" + operacoes);
        }
        /*
        ArrayUtils.imprimir(meuArray);
        BubbleSort bs = new BubbleSort();
        bs.ordenar(meuArray);
        int operacoes = bs.getOperacoes();
        ArrayUtils.imprimir(meuArray);
        System.out.println("Ordenado apos " + operacoes + " operacoes ");
        */
    }

}
