package aula06_exercicios;

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
        int[] a1 = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        //exercicio 5
        System.out.println(buscaBinariArrayOrdenado(a1, 0, a1.length-1, 80));
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

    //Implementar um método recursivo em Java que inverta um array de inteiros de tamanho n.
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

    //5) Implementar um método recursivo que faça uma busca binária em um array de inteiros ordenado.
    /*
    * [10, 20, 30, 40, 50, 60, 70, 80]
    *   0   1   2   3   4   5   6   7
     */
    public static int buscaBinariArrayOrdenado(int[] arrayOrdenado, int inicio, int fim, int chave) {
        int meio = (inicio + fim) / 2;

        if (inicio > fim) {
            return -1;
        }

        if(chave==arrayOrdenado[meio]) return meio;
        else if(chave < arrayOrdenado[meio]) {
            return buscaBinariArrayOrdenado(arrayOrdenado, inicio, meio-1, chave);
        }
        else  {
            return buscaBinariArrayOrdenado(arrayOrdenado, meio + 1, fim, chave);
        }
    }


}

