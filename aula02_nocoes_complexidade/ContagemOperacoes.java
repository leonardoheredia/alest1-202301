package aula02_nocoes_complexidade;

public class ContagemOperacoes {
    public static void main(String[] args) {

    }

    private static int funcao_01(int n) {
        int operacoes = 0;
        for (int i = 0; i < n; i++) {
            operacoes++;
        }
        return operacoes;
    }

}
