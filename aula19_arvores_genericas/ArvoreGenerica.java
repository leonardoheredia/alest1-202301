package aula19_arvores_genericas;

import java.util.ArrayList;

public class ArvoreGenerica {
    public static final int DEFAULT_FILHOS = 5;
    class Nodo {
        public Nodo pai;
        public String item;
        public Nodo[] filhos;
        public int numeroFilhos;
        public Nodo(String item) {
            this.pai = null;
            this.filhos = new Nodo[DEFAULT_FILHOS];
            this.item = item;
            this.numeroFilhos=0;
        }
        public void adicionarFilho(Nodo filho) {
            filho.pai = this;
            filhos[numeroFilhos] = filho;
            numeroFilhos++;
        }
    }

    private Nodo raiz;
    private int tamanho;

    public ArvoreGenerica() {
        this.tamanho = 0;
        this.raiz = null;
    }
    public void adicionarNodo(String item, String pai) {
        Nodo novoNodo = new Nodo(item);
        if(tamanho == 0) raiz = novoNodo;
        else {
            Nodo nodoPai = procuraNodoPorValor(pai, raiz);
            nodoPai.adicionarFilho(novoNodo);
        }
        tamanho++;
    }

    private Nodo procuraNodoPorValor(String item, Nodo nodoPesquisa) {
        if(nodoPesquisa==null) return null;
        if(nodoPesquisa.item.equals(item)) return nodoPesquisa;
        if(nodoPesquisa.numeroFilhos>0) {
            for (int i = 0; i < nodoPesquisa.numeroFilhos; i++) {
                Nodo nodoFilho = procuraNodoPorValor(item, nodoPesquisa.filhos[i]);
                if(nodoFilho!=null) return nodoFilho;
            }
        }
        return null;
    }

    public void listaNodosItens() {
        Nodo aux = this.raiz;
        percorreArvorePreOrdemRecursiva(aux);

    }
    private void percorreArvorePreOrdemRecursiva(Nodo aux) {
        if(aux == null) return;
        else {
            System.out.println(aux.item);
            for (int i = 0; i < aux.numeroFilhos; i++) {
                percorreArvorePreOrdemRecursiva(aux.filhos[i]);
            }
        }
    }

    public static void main(String[] args) {
        ArvoreGenerica ag = new ArvoreGenerica();
        ag.adicionarNodo("A", null);
        ag.adicionarNodo("B", "A");
        ag.adicionarNodo("C", "A");
        ag.adicionarNodo("D", "A");
        ag.adicionarNodo("E", "C");
        ag.adicionarNodo("F", "E");
        ag.adicionarNodo("G", "B");
        ag.listaNodosItens();
    }

}
