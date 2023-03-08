package aula03_complexidade_exercicios;

public class ExerciciosComplexidade {
    public static void main(String[] args) {

        Funcoes f = new Funcoes();
        System.out.println("N;operacoes");
        for (int N = 1; N <= 100; N+=5) {
            int operacoes = f.fe(N);
            System.out.println(N + ";" + operacoes);
        }

    }
}
