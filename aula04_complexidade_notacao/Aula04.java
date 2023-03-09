package aula04_complexidade_notacao;


public class Aula04 {
    public static void main(String[] args) {
        Funcoes f = new Funcoes();
        System.out.println("N;fa;fb;fc;fd;fe;cresceMuito");
        for (int N = 5; N <= 150; N+=10) {
            int operacoes_fa = f.fa(N);
            int operacoes_fb = f.fb(N);
            int operacoes_fc = f.fc(N);
            int operacoes_fd = f.fd(N);
            int operacoes_fe = f.fe(N);
            int operacoes_cresceMuito = f.cresceMuito(N);
            //fazer o resto
            System.out.println(N + ";" + operacoes_fa + ";" + operacoes_fb + ";" + operacoes_fc + ";" + operacoes_fd + ";" + operacoes_fe + ";" + operacoes_cresceMuito);
        }
    }
}
