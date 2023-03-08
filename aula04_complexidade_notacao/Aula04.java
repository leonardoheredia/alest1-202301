package aula04_complexidade_notacao;


public class Aula04 {
    public static void main(String[] args) {
        Funcoes f = new Funcoes();
        for (int N = 1; N <= 100; N+=5) {
            int operacoes_fa = f.fa(N);
            int operacoes_fb = f.fb(N);
            int operacoes_fc = f.cresceMuito(N);
            //fazer o resto
            System.out.println(N + ";" + operacoes_fa + ";" + operacoes_fb + ";" + operacoes_fc);
        }
    }
}
