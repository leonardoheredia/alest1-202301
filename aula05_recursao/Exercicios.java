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
        System.out.println(somatorio(200));
    }
    public static int somatorio(int numero) {
        System.out.println(numero);
        if(numero==0) return 0;
        else return numero + somatorio(numero - 1);
    }
}
