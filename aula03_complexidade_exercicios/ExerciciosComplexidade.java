package aula03_complexidade_exercicios;

public class ExerciciosComplexidade {
    public static void main(String[] args) {
        Funcoes f = new Funcoes();
        for(int i=1; i<300; i+=10){
            int r = f.fa(i);
            System.out.println(i+";"+r);
        }
    }
}
