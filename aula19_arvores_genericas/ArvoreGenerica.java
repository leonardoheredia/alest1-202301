package aula19_arvores_genericas;

public class ArvoreGenerica {

    class Nodo {
        public String item;
        public Nodo pai;
        public Nodo[] filhos;
        public int numeroFilhos;
        public Nodo(String item) {
            this.item = item;
            this.pai = null;
            this.filhos = new Nodo[100];
            this.numeroFilhos = 0;
        }
        public void adicionarFilho(Nodo nodoFilho) {
            nodoFilho.pai = this;
            this.filhos[numeroFilhos] = nodoFilho;
            numeroFilhos++;
        }

    }
    private Nodo raiz;
    private int tamanho;
    public ArvoreGenerica() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public void percorrerPreOrdem() {
        System.out.println("");
        percorrerPreOrdemRecursivo(raiz);
    }
    public void percorrerPreOrdemRecursivo(Nodo n) {
        System.out.printf(n.item + " ");;
        for (int i = 0; i < n.numeroFilhos ; i++) {
            percorrerPreOrdemRecursivo(n.filhos[i]);
        }
    }

    public void percorrerPosOrdem() {
        System.out.println("");
        percorrerPosOrdemRecursivo(raiz);
    }
    public void percorrerPosOrdemRecursivo(Nodo n) {
        for (int i = 0; i < n.numeroFilhos ; i++) {
            percorrerPosOrdemRecursivo(n.filhos[i]);
        }
        System.out.printf(n.item + " ");
    }

    public void adicionarNodo(String item, String pai) {
        Nodo novoNodo = new Nodo(item);
        if(tamanho==0) {
            this.raiz = novoNodo;
        }
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

    public static void main(String[] args) {
        ArvoreGenerica g = new ArvoreGenerica();
        g.adicionarNodo("A", null);
        g.adicionarNodo("B", "A");
        g.adicionarNodo("C", "A");
        g.adicionarNodo("D", "A");
        g.adicionarNodo("J", "B");
        g.adicionarNodo("P", "B");
        g.adicionarNodo("Y", "P");
        g.adicionarNodo("K", "D");
        g.adicionarNodo("O", "K");
        g.adicionarNodo("F", "O");
        g.adicionarNodo("M", "D");
        g.adicionarNodo("Z", "D");

        g.percorrerPreOrdem();

        g.percorrerPosOrdem();

    }


}
