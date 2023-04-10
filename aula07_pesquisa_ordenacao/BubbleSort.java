package aula07_pesquisa_ordenacao;

import arrays.ArrayUtils;

public class BubbleSort {

    public long getOperacoes() {
        return operacoes;
    }

    public long getTempoInicio() {
        return tempoInicio;
    }

    public long getTempoFim() {
        return tempoFim;
    }

    private long operacoes; //propriedade para guardar o numero de operacoes realizadas
    private long tempoInicio; //usado para guardar o inicio da execucao
    private long tempoFim;

    public void ordenar(int[] arrayInteiros) {
        tempoInicio = System.nanoTime();
        operacoes = 0;
        int tamanho = arrayInteiros.length;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho-1-i; j++) {
                operacoes++;
                //System.out.printf("Compara %d com %d%n", arrayInteiros[j+1], arrayInteiros[j]);
                if(arrayInteiros[j]>arrayInteiros[j+1]) {
                    //System.out.printf("Troca %d por %d%n", arrayInteiros[j+1], arrayInteiros[j]);
                    int temp = arrayInteiros[j];
                    arrayInteiros[j] = arrayInteiros[j+1];
                    arrayInteiros[j+1] = temp;
                    operacoes++;
                }
                //ArrayUtils.imprimir(arrayInteiros);
            }
        }
        tempoFim = System.nanoTime();
    }

}
