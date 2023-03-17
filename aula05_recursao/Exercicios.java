package aula05_recursao;

import arrays.ArrayUtils;

public class Exercicios {
/*
    1) Implementar um método recursivo em Java para
       calcular o somatório de números inteiros de 0 até n.
    2) Implementar um método recursivo em Java que escreva uma mensagem na tela n vezes.
    3) Implementar um método recursivo em Java que inverta um array de inteiros de tamanho n.
    4) Implementar uma versão não recursiva para calcular o fatorial.
    5) Implementar um método recursivo que faça uma busca binária em um array de inteiros ordenado.
*/
    public static void main(String[] args) {
        //System.out.println(somatorio(200));
        //escrever("que aula demais!!! nem quero saber da chamada!", 100);
        //System.out.println(fatorialNaoRecursivo(7));
        int[] arrayInteiros = {12,  90,  33,  40,  67,  89,  34, 77};
        inverteArrayInteiroRec(arrayInteiros, arrayInteiros.length);


        int[] arrayInteiros2 = {12,  90,  33,  40,  67,  89,  34, 77};
        System.out.println("Outra solucao");
        ArrayUtils.imprimir(arrayInteiros2);
        inverterArrayInteirosRecSegundaSolucao(arrayInteiros2, 0, arrayInteiros.length-1);
        ArrayUtils.imprimir(arrayInteiros2);
    }
    public static int somatorio(int numero) {
        System.out.println(numero);
        if(numero==0) return 0;
        else return numero + somatorio(numero - 1);
    }

    public static void escrever(String mensagem, int n) {
        if(n == 0) return;
        else {
            System.out.println(mensagem);
            escrever(mensagem, n - 1);
        };
    }

    public static int fatorialNaoRecursivo(int n) {
        //5 = 5 * 4 * 3 * 2 * 1
        int resultado = 1;
        if(n==0) return resultado;

        for (int i = n; i >=1 ; i--) {
            resultado = resultado * i;
        }
        return resultado;
    }

    //3) Implementar um método recursivo em Java que inverta um array de inteiros de tamanho n.
    public static void inverteArrayInteiro(int[] arrayInteiros, int n) {
        for (int i = n-1; i >= (n/2); i--) {
            if((n-1) % 2 == 0 && i == (n-1) /2 ) break;
            ArrayUtils.imprimir(arrayInteiros);
            System.out.printf("Trocando %d por %d%n", arrayInteiros[i], arrayInteiros[n-i-1]);
            int temp = arrayInteiros[i];
            arrayInteiros[i] = arrayInteiros[n - i -1];
            arrayInteiros[n - i -1] = temp;
        }
    }

    public static void inverteArrayInteiroRec(int[] arrayInteiros, int n) {
        int tamanhoArray = arrayInteiros.length;
        ArrayUtils.imprimir(arrayInteiros);
        System.out.printf("Trocando %d por %d%n", arrayInteiros[n-1], arrayInteiros[tamanhoArray-n]);
        int temp = arrayInteiros[n-1];
        arrayInteiros[n-1] = arrayInteiros[tamanhoArray-n];
        arrayInteiros[tamanhoArray-n] = temp;
        n--;
        if(tamanhoArray % 2 == 0 &&  n<=tamanhoArray / 2) return;
        else if(tamanhoArray % 2 == 1 &&  n-1<=tamanhoArray / 2) return;
        else inverteArrayInteiroRec(arrayInteiros, n);
    }

    public static void inverterArrayInteirosRecSegundaSolucao(int[] arrayInteiros, int inicio, int fim) {
        if(inicio<fim) {
            int temp = arrayInteiros[inicio];
            arrayInteiros[inicio] = arrayInteiros[fim];
            arrayInteiros[fim] = temp;
            inicio++;
            fim--;
            inverterArrayInteirosRecSegundaSolucao(arrayInteiros, inicio, fim);
        }
    }
    //[12,  90,  33,  40,  67,  89,  34]
    // 0    1    2     3    4    5    6
    // n = 6 --> 6 troca com o 0
    // n = 5 --> 5 troca com o 1
    // n = 4 --> 4 troca com o 2
    // n = 3 --> terminou
    //resultado
    //[34,  89, 67,  40,  33,  90,  12]











    //Dica para o 3
    //[ 12, 90, 33, 40]
    //  0   1    2   4
    //  n = 4  --> 4 troca com o 0
    //  n = 3  --> 3 troca com o 1
    //  n = 2  --> terminou





}
