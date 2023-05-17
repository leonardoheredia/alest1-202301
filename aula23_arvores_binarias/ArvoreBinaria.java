package aula23_arvores_binarias;

import aula15_respostas_exercicios_aula_14_filas_pilhas.FilaDinamica;

import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {

    class Nodo {
        public String item;
        public Nodo esquerda;
        public Nodo direita;
        public Nodo pai;
        public Nodo(String item) {
            this.item = item;
            this.esquerda = null;
            this.direita = null;
            this.pai = null;
        }
    }
    Nodo raiz;
    int tamanho;
    public ArvoreBinaria(String item) {
        Nodo novoNodo = new Nodo(item);
        raiz = novoNodo;
    }
    public void adicionarSubarvoreEsquerda(ArvoreBinaria arvore) {
        this.raiz.esquerda = arvore.raiz;
        arvore.raiz.pai = this.raiz;
    }

    public void adicionarSubarvoreDireita(ArvoreBinaria arvore) {
        this.raiz.direita = arvore.raiz;
        arvore.raiz.pai = this.raiz;
    }

    public void percorrerPreOrdem() {
        percorrerPreOrdemRecursivo(raiz);
    }

    public void percorrerPreOrdemRecursivo(Nodo n) {
        if(n!=null) {
            System.out.println(n.item);
            percorrerPreOrdemRecursivo(n.esquerda);
            percorrerPreOrdemRecursivo(n.direita);
        }
    }

    public void percorrerPosOrdem() {
        //implementar
    }

    public void percorrerPosOrdemRecursivo(Nodo n) {
        //implementar
    }

    public int getTamanho() {
        return 0; //implementar
    }


    public static void main(String[] args) {
        ArvoreBinaria leonardo = new ArvoreBinaria("Leonardo");
        ArvoreBinaria mariana = new ArvoreBinaria("Mariana");
        ArvoreBinaria alexandre = new ArvoreBinaria("Alexandre");
        ArvoreBinaria tito = new ArvoreBinaria("Tito");
        ArvoreBinaria lucas = new ArvoreBinaria("Lucas");

        leonardo.adicionarSubarvoreEsquerda(mariana);
        leonardo.adicionarSubarvoreDireita(alexandre);

        mariana.adicionarSubarvoreEsquerda(tito);
        mariana.adicionarSubarvoreDireita(lucas);

        leonardo.percorrerPreOrdem();
    }
}
