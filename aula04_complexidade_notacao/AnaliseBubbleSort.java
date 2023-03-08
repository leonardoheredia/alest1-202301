package aula04_complexidade_notacao;

import arrays.ArrayUtils;

public class AnaliseBubbleSort {

    public static void main(String[] args) {
        int[] meuArray = {70, 60, 40, 30, 10};

        ArrayUtils.imprimir(meuArray);
        BubbleSort bs = new BubbleSort();
        bs.ordenar(meuArray);
        int operacoes = bs.getOperacoes();
        ArrayUtils.imprimir(meuArray);
        System.out.println("Ordenado apos " + operacoes + " operacoes ");

    }

}
