package aula24_arvores_binarias_pesquisa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinariaPesquisa {
    class Nodo {
        public int item;
        public Nodo pai;
        public Nodo esquerda;
        public Nodo direita;
        public Nodo(int item) {
            this.item = item;
            this.pai = null;
            this.esquerda = null;
            this.direita = null;
        }
    }
    private Nodo raiz;
    private int tamanho;
    public ArvoreBinariaPesquisa() {
        tamanho = 0;
    }
    private void adicionarRecursivamente(Nodo novoNodo, Nodo pai) {
        if(novoNodo.item < pai.item) { //vai para a esquerda do nodo pai
            if(pai.esquerda==null) {
                pai.esquerda = novoNodo;
                novoNodo.pai = pai;
            }
            else adicionarRecursivamente(novoNodo, pai.esquerda);
        }
        else {
            if(pai.direita==null) {
                pai.direita = novoNodo;
                novoNodo.pai = pai;
            }
            else adicionarRecursivamente(novoNodo, pai.direita);
        }
    }
    public void adicionar(int item) {
        Nodo novoNodo = new Nodo(item);
        if(this.tamanho==0) this.raiz = novoNodo;
        else adicionarRecursivamente(novoNodo, raiz);
        this.tamanho++;
    }
    public boolean estaVazia() {
        //implementar
        return false;
    }
    public int obterTamanho() {
        //implementar
        return tamanho;
    }
    public void limpar(){
        //limpa a arvore
        //implementar
    }
    public int obterEsquerda(int item) {
        //retorna o filho a esquerda de item
        //implmentar
        return 0;
    }
    public int obterDireita(int item) {
        //retorna o filho a direita de item
        //implmentar
        return 0;
    }
    public int obterPai(int item) {
        Nodo filho = buscarNodo(item);
        if(filho!=null && filho.pai!=null) {
            return filho.pai.item;
        }
        return -1;
    }
    public ArrayList<Integer> elementosPreOrdem() {
        ArrayList<Integer> elementos = new ArrayList<>();
        preOrdemRecursivo(this.raiz, elementos);
        return elementos;
    }
    private void preOrdemRecursivo(Nodo pai, ArrayList<Integer> elementos) {
        elementos.add(pai.item);
        if(pai.esquerda!=null) preOrdemRecursivo(pai.esquerda, elementos);
        if(pai.direita!=null) preOrdemRecursivo(pai.direita, elementos);
    }
    public ArrayList<Integer> elementosCentralOrdem() {
        //retorna um array list com os elementos (valores inteiros) em ordem central
        //implementar
        return null;
    }
    public ArrayList<Integer> elementosPosOrdem() {
        //retorna um array list com os elementos (valores inteiros) em pos ordem
        //implementar
        return null;
    }
    public ArrayList<Integer> elementosLargura() {
        ArrayList<Integer> elementos = new ArrayList<>();
        Queue<Nodo> fila = new LinkedList<>();
        fila.add(this.raiz);
        while(!fila.isEmpty()) {
            Nodo aux = fila.poll();
            elementos.add(aux.item);
            if(aux.esquerda!=null) fila.add(aux.esquerda);
            if(aux.direita!=null) fila.add(aux.direita);
        }
        return elementos;
    }
    public int obterNivel(int item) {
        //retorna o nivel do elemeto item, caso nao existe retorna -1
        //implementar
        return 0;
    }
    public Nodo buscarNodo(int item) {
        //retorna o nodo que contem o item
        Nodo aux = this.raiz;
        while(aux!=null) {
            if(aux.item==item) return aux;
            if(item<aux.item) aux = aux.esquerda;
            else aux = aux.direita;
        }
        return null;
    }
    public boolean existe(int item) {
        return (buscarNodo(item)!=null);
    }
    public int altura() {
        int altura = alturaRecursiva(this.raiz, -1,-1);
        return altura;
    }
    public int alturaRecursiva(Nodo nodo, int altura_esq, int altura_dir) {
        if(nodo==null) return Math.max(altura_esq, altura_dir);
        else {
            System.out.println("Visitei o " + nodo.item);
            if(nodo.esquerda!=null) altura_esq = alturaRecursiva(nodo.esquerda, altura_esq + 1, altura_dir);
            if(nodo.direita!=null) altura_dir = alturaRecursiva(nodo.direita, altura_esq, altura_dir+1);
        }
        return Math.max(altura_esq, altura_dir);
    }
    public boolean ehInterno(int item) {
        Nodo nodo = buscarNodo(item);
        if(nodo==null) return false; //soh vai acontecer se o nodo nao existir na arvore
        if(nodo.esquerda!=null || nodo.direita!=null) return true;
        else return false;
    }
    public boolean ehExterno(int item) {
        //retorna true se o elemento esta em um nodo interno
        Nodo nodo = buscarNodo(item);
        if(nodo==null) return false;
        if(nodo.direita==null && nodo.esquerda==null) return true;
        else return false;
    }
    public void remover(int item) {
        //remove o elemento da arvore se ele existir
        //implementar
    }
    public void imprimirArvore() {
        imprimirArvoreRecusivamente(this.raiz, 0);
    }
    private void imprimirArvoreRecusivamente(Nodo raiz, int nivel) {
        if (raiz == null) return;
        nivel += 5;
        imprimirArvoreRecusivamente(raiz.direita, nivel);
        System.out.print("\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        System.out.print(raiz.item + "\n");
        for (int i = 5; i < nivel; i++) System.out.print(" ");
        imprimirArvoreRecusivamente(raiz.esquerda, nivel);
    }
    public void adicionarNaoRecursivo(int item) {
        Nodo novoNodo = new Nodo(item);
        if(this.tamanho==0) this.raiz = novoNodo;
        else {
            Nodo aux = this.raiz;
            boolean inseriu = false;
            while(!inseriu) {
                if(novoNodo.item < aux.item) {
                    if(aux.esquerda==null) {
                        aux.esquerda = novoNodo;
                        inseriu = true;
                    }
                    else aux = aux.esquerda;
                }
                else if (novoNodo.item > aux.item) {
                    if(aux.direita==null)  {
                        aux.direita = novoNodo;
                        inseriu = true;
                    }
                    else aux = aux.direita;
                }
                else {
                    System.out.println("Item já existe.");
                    return;
                }
            }
        }
        this.tamanho++;
    }

}
