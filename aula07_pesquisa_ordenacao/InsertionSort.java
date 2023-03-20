package aula07_pesquisa_ordenacao;

public class InsertionSort {
    private int operacoes; //propriedade para guardar o numero de operacoes realizadas
    private long tempoInicio; //usado para guardar o inicio da execucao
    private long tempoFim;

    public void ordernar(int[] arrayInteiros) {
        tempoInicio = System.nanoTime();
        operacoes = 0;

        int tamanho = arrayInteiros.length;
        int chave;
        for (int j = 1; j < tamanho; j++) { //inicia na posicao 1
            chave = arrayInteiros[j]; //chave inicia com o valor da posicao 1 (nao a zero)
            int i = j - 1;
            while ( i>=0 && arrayInteiros[i]>chave) { //so executa quando o valor da posicao em i for maior que a chave
                //System.out.printf("Trocou %d pelo %d%n", arrayInteiros[i+1], arrayInteiros[i]);
                arrayInteiros[i+1] = arrayInteiros[i];
                i = i -1;
                operacoes++;
            }
            operacoes++;
            arrayInteiros[i + 1] = chave;
        }
    }


}
