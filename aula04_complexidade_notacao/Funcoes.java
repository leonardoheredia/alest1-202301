package aula04_complexidade_notacao;

public class Funcoes {

    public int fa(int n) {
        int cont = 0;
        for (int i = 0; i < n; i++) {
            cont++;
        }
        return cont;
    }

    public int fb(int n) {
        int cont = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cont++;
            }
        }
        return cont;
    }

    public int fc(int n) {
        int cont = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < 2 * i; j++) {
                cont++;
            }
        }
        return cont;
    }

    public int fd(int n) {
        int cont = 0;
        for (int i = 1; i < n; i = i + i) {
            cont++;
        }
        return cont;
    }

    public int fe(int n) {
        int cont = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j = j + j) {
                cont++;
            }
        }
        return cont;
    }


    public  int cresceMetade(int n) {
        int operacoes = 0;
        for (int i = 1; i < n; i = i * 2){
            operacoes++;
        }
        return operacoes;
    }

    public int cresceMuito(int n) {
        int operacoes = 0;
        for (int i = 1; i <= Math.pow(1.2, n); i++){
            operacoes++;
        }
        return operacoes;
    }



}