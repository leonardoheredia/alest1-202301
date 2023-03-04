/*
Construa um método que:
1) Receba um inteiro n e retorne um String com todos os inteiros de 0 até n;
2) Receba um inteiro n e retorne um array com todos os inteiros de 0 até n;
3) Receba um número e retorne true se este número for primo, false caso contrário;
4) Receba dois inteiros e retorne um array com todos os primos entre estes números.



* */

package aula01_exercicios_revisao;

import arrays.ArrayUtils;

public class ExerciciosRevisao {
    public static void main(String[] args) {

        System.out.println(receberInteiroRetornarString(5));

        ArrayUtils.imprimir(receberInteiroRetornarArray(8));

        System.out.println(ehPrimo(8));
        System.out.println(ehPrimo(17));

        ArrayUtils.imprimir(receberDoisInteirosRetonarArrayComPrimos(0, 100));

        int[] lista = {3, 5, 3, 2, 1, 1};
        System.out.println(nOcorrencias(lista, 9));

        int[] lista2 = {3, 5, 1, 0, 6, 5, 3, 5, 7, 3, 9};
        System.out.println(hasRepeat(lista2));

        ArrayUtils.imprimir(lista2);
        System.out.println();
        System.out.println("O array tem " + nroRepeat(lista2) + " elementos repetidos.");

        System.out.println("Lista com os repetidos");
        ArrayUtils.imprimir(listRepeat(lista2));


        System.out.println("Teste do Union");
        int[] listaA = {3, 5, 3, 2, 1, 1};
        int[] listaB = {1, 3, 5, 8, 9};
        int[] listaAUniaoB = union(listaA, listaB);
        ArrayUtils.imprimir(listaA);
        ArrayUtils.imprimir(listaB);
        ArrayUtils.imprimir(listaAUniaoB);
        System.out.println("Teste do Intersec");
        ArrayUtils.imprimir(intersect(listaA, listaB));

    }

    public static String receberInteiroRetornarString(int valorInteiro) {
        String valorString="";

        for (int i = 0; i <= valorInteiro; i++) {
            valorString = valorString + " " + i;
        }
        return valorString;
    }
    public static int[] receberInteiroRetornarArray(int valorInteiro) {
        int[] arrayInteiro = new int[valorInteiro+1];
        for (int i = 0; i < arrayInteiro.length ; i++) {
            arrayInteiro[i] = i;
        }
        return arrayInteiro;
    }
    public static boolean ehPrimo(int numeroInteiro) {
        //numero primo eh um numero natural divisivel apenas por 1 e por ele mesmo
        //2, 3, 5, 7, 11, 13
        //implementacao para fins didaticos! não é a mais otimizada

        if(numeroInteiro<=1) return false;

        int divisores=0;
        for (int i = 1; i <= numeroInteiro ; i++) {
            if(numeroInteiro % i == 0) divisores++;
            if(divisores>2) return false;
        }
        if (divisores==2) return true;
        else return false;
        //outra forma de escrever esse if seria
        //return (divisoes==2)
    }
    public static int[] receberDoisInteirosRetonarArrayComPrimos(int valorInteiro1, int valorInteiro2) {
        int capacidadeMaxima = valorInteiro2 - valorInteiro1;
        int[] arrayComPrimosTemporario = new int[capacidadeMaxima];
        int quantidadePrimos = 0;
        for (int i = valorInteiro1; i <=valorInteiro2 ; i++) {
            if(ehPrimo(i)) {
                arrayComPrimosTemporario[quantidadePrimos] = i;
                quantidadePrimos++;
            }
        }

        //gera array final apenas com primos
        int[] arrayComPrimos = new int[quantidadePrimos];
        for (int i = 0; i < quantidadePrimos; i++) {
            arrayComPrimos[i] = arrayComPrimosTemporario[i];
        }
        return arrayComPrimos;
    }
    public static int nOcorrencias(int[] lista, int elemento) {
        int quantidadeOcorrencias = 0;
        for (int i = 0; i < lista.length ; i++) {
            if(lista[i]==elemento) quantidadeOcorrencias++;
        }
        return quantidadeOcorrencias;
    }

    /*
    Método que retorna true se l tem elementos repetidos
    boolean hasRepeat(int[] l)
    */
    public static boolean hasRepeat(int[] l) {
        for (int i = 0; i < l.length; i++) {
            for(int j=i + 1; j < l.length; j++) {
                if(l[j]==l[i]) return true;
            }
        }
        return false;
    }

    /*
    Método que retorna o número de elementos repetidos em l
	int nroRepeat(int[] l)
     */
    public static int nroRepeat(int[] l) {
        int quantidadeRepetidos = 0;
        for (int i = 0; i < l.length; i++) {
            for(int j=i + 1; j < l.length; j++) {
                if(l[j]==l[i])  {
                    quantidadeRepetidos++;
                }
            }
        }
        return quantidadeRepetidos;
    }

/*
    Método que retorna uma lista de elementos repetidos de l
     int[] listRepeat(int[] l)
 */
    public static int[] listRepeat(int[] l) {
        int[] elementosRepetidos = new int[l.length];
        int quantidadeRepetidos = 0;
        for (int i = 0; i < l.length; i++) {
            for(int j=i + 1; j < l.length; j++) {
                if(l[j]==l[i])  {
                    elementosRepetidos[quantidadeRepetidos] = l[i];
                    quantidadeRepetidos++;
                }
            }
        }
        int[] elementosRepetidosLimpa = new int[quantidadeRepetidos];
        for (int i = 0; i < elementosRepetidosLimpa.length; i++) {
            elementosRepetidosLimpa[i] = elementosRepetidos[i];
        }
        return elementosRepetidosLimpa;
    }

/*
    Método que retorna a união de l1 e l2
	 int[] union(int[] l1, int[] l2)
*/
    public static int[] union(int[] l1, int[] l2) {
        int tamanhoNovaLista = l1.length + l2.length;
        int[] novaLista = new int[tamanhoNovaLista];
        int contadorNovaLista = 0;

        for (int i = 0; i < l1.length; i++) {
            novaLista[contadorNovaLista] = l1[i];
            contadorNovaLista++;
        }
        for (int i = 0; i < l2.length; i++) {
            novaLista[contadorNovaLista] = l2[i];
            contadorNovaLista++;
        }
        return novaLista;
    }


    /*
    Método que retorna a intersecao de l1 e l2
	 int[] union(int[] l1, int[] l2)
*/
    public static int[] intersect(int[] l1, int[] l2) {
        int tamanhoMaior = maiorValorInteiro(l1.length, l2.length);
        int[] arrayTemporario = new int[tamanhoMaior];
        int contadorTemporario = 0;

        for (int i = 0; i < l1.length; i++) {
            for (int j = 0; j < l2.length; j++) {
                if(l2[j]==l1[i]) {
                    if(!ArrayUtils.valorExisteNoArray(arrayTemporario, l2[j])) {
                        arrayTemporario[contadorTemporario] = l2[j];
                        contadorTemporario++;
                    }
                }
            }
        }
        int[] arrayFinal = new int[contadorTemporario];
        for (int i = 0; i < arrayFinal.length; i++) {
            arrayFinal[i] = arrayTemporario[i];
        }
        return arrayFinal;
    }

    public static int maiorValorInteiro(int a, int b) {
        if(a>b) return a;
        return b;
    }
}

