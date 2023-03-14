package aula05_recursao;

public class Aula05_Exemplos_Recursivos {

    public static void main(String[] args) {
        //System.out.println("Fatorial");
        //int n = fatorial(4);
        //System.out.printf("%n%d%n", n);
        int numero = fibonacci(30);
        System.out.println(numero);


        /*
        System.out.println("Fibonacci");
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i) + " ");
        }
        */


    }

    public static int fatorial(int n) {
        if(n==0 || n==1)  {
            System.out.println("Chegou na condicao de parada. N = " + n);
            return 1;
        }
        else {
            System.out.println("Fazendo " + n + " * " + " fatorial(" +(n-1) + ")");
            return n * fatorial(n - 1);
        }
    }

    /*
    Sequencia de Fibonacci = [0, 1, 1, 2, 3, 5, 8, 13, 21, ...]
    fib(0) = 0 se n = 0
    fib(1) = 1 se n = 1
    fib(n) = fib(n - 1) + fib(n - 2)
    Método print fibonnaci de 0 até n
    */
    public static int fibonacci(int n) {
        if(n == 0) return  n;
        else if (n==1 || n==2) return 1;
        else return (fibonacci(n - 1) + fibonacci(n - 2));
    }

}
