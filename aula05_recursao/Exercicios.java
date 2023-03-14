package aula05_recursao;

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
        escrever("que aula demais!!! nem quero saber da chamada!", 100);
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

    //Dica para o 3
    //[ 12, 90, 33, 40]
    //  0   1    2   4
    //  n = 4  --> 4 troca com o 0
    //  n = 3  --> 3 troca com o 1
    //  n = 2  --> terminou


    //[12,  90,  33,  40,  67,  89,  34]
    // 0    1    2     3    4    5    6
    // n = 6 --> 6 troca com o 0
    // n = 5 --> 5 troca com o 1
    // n = 4 --> 4 troca com o 2
    // n = 3 --> terminou
    //resultado
    //[34,  89, 67,  40,  33,  90,  12]

}
