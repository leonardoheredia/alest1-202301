package aula08_exercicios_pesquisa_ordenacao;

import arrays.ArrayUtils;

public class Aula08_Exercicios_PesquisaOrdenacao {

    public static void main(String[] args) {
        exercicio3();
        exercicio4();
        exercicio5();

    }

    //3) Implementar um método em Java que receba dois arrays de inteiros e retorne um array que seja o merge dos arrays a e b.

    public static void exercicio3() {
        System.out.printf("%nExercicio 3%n");
        int[] arrayA = {10, 30, 20, 40, 54, 12};
        int[] arrayB = {12, 15, 70, 66, 99};
        ArrayUtils.imprimir(arrayA);
        ArrayUtils.imprimir(arrayB);
        System.out.printf("%nArray Mergeado");
        int[] arrayM = mergeArray(arrayA, arrayB);
        ArrayUtils.imprimir(arrayM);
    }
    public static int[] mergeArray(int[] arrayA, int[] arrayB) {
        int[] arrayMergeado = new int[arrayA.length + arrayB.length];

        int k = 0;
        for (int i = 0; i < arrayA.length; i++) {
            arrayMergeado[k] = arrayA[i];
            k++;
        }
        for (int j = 0; j < arrayB.length; j++) {
            arrayMergeado[k] = arrayB[j];
            k++;
        }
        return arrayMergeado;
    }




    //4) Implementar um método em java que receba dois arrays de inteiros ordenados e retorne um array ordenado que seja o merge dos arrays a e b.
    public static void exercicio4() {
        System.out.printf("%nExercicio 4%n");
        int[] arrayA = {10, 20, 30, 40, 41};
        int[] arrayB = {12, 15, 66, 77, 88, 90};
        ArrayUtils.imprimir(arrayA);
        ArrayUtils.imprimir(arrayB);
        System.out.printf("%nArray Mergeado");
        int[] arrayM = mergeArrayOrdenado(arrayA, arrayB);
        ArrayUtils.imprimir(arrayM);
    }
    public static int[] mergeArrayOrdenado(int[] arrayA, int[] arrayB) {
        int tamanho = arrayA.length + arrayB.length;
        int[] arrayMergeado = new int[tamanho];

        int i=0;
        int j=0;
        for (int k = 0; k < arrayMergeado.length; k++) {
            if(i==arrayA.length) { //array A ja foi mergeado
                arrayMergeado[k] = arrayB[j];
                j++;
            }
            else if(j==arrayB.length) { //array B ja foi mergeado
                arrayMergeado[k] = arrayA[i];
                i++;
            }
            else if(arrayA[i]<=arrayB[j]) {
                arrayMergeado[k] = arrayA[i];
                i++;
            }
            else {
                arrayMergeado[k] = arrayB[j];
                j++;
            }
        }

        return arrayMergeado;
    }


    public static void exercicio5() {
        System.out.printf("%nExercicio 5%n");
        int[] arrayA = {12, 15, 66, 77, 88, 90};
        ArrayUtils.imprimir(arrayA);
        int valor = 91;
        System.out.printf("%nPesquisando: %d", valor);
        if(existeNoArrayUsandoBuscaBinaria(arrayA, valor)) System.out.printf("%n Valor existe no array!!!");
        else System.out.printf("%nNão existe!");

    }
    public static Boolean existeNoArrayUsandoBuscaBinaria(int[] arrayOrdenado, int valorPesquisado) {
        int inicio = 0;
        int fim = arrayOrdenado.length - 1;

        while(inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if(valorPesquisado < arrayOrdenado[meio]) { //o meio eh menor que o valor pesquisado, move para a esquerda no array
                fim = meio - 1;
            }
            else if(valorPesquisado > arrayOrdenado[meio]) {
                inicio = meio + 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
