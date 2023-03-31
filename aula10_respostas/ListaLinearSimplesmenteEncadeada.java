package aula10_respostas;

public class ListaLinearSimplesmenteEncadeada {
    private int quantidade;
    private Nodo inicio;
    private Nodo fim;
    private class Nodo {
        private String item;
        private Nodo proximo;

        private Nodo(String item) {
            this.item = item;
            this.proximo = null;
        }
    }
    public ListaLinearSimplesmenteEncadeada() {
        this.quantidade = 0;
        this.inicio = null;
        this.fim = null;
    }
    /** Insere novo nodo no final da lista   */
    public void adicionar(String item) {

        Nodo novoNodo = new Nodo(item);
        if(this.estaVazia()) {
            this.inicio = novoNodo;
            this.fim = novoNodo;
        }
        else {
            this.fim.proximo = novoNodo;
            this.fim = novoNodo;
        }
        this.quantidade++;
    }
    /** Insere novo nodo em uma posicao especifica da lista   */
    public boolean adicionar(int posicao, String item) {
        if(quantidade==0 || posicao==quantidade) {
            adicionar(item); //lista vazia ou entao esta inserindo no final, nesse caso chama o metodo adicionar padrao
            return true;
        }
        if(posicao>quantidade) return false;

        Nodo novoNodo = new Nodo(item);
        if(posicao==0) { //inserindo no inicio
            novoNodo.proximo = this.inicio; //proximo do novoNodo eh o inicio atual que sera trocado para o novoNodo
            this.inicio = novoNodo;
        }
        else {
            Nodo nodoAux = this.inicio;
            Nodo anterior = nodoAux;
            for (int i = 0; i < posicao; i++) { //ao sair do laco for o nodo Anterior sera o a ser ligado com o novo nodo
                anterior = nodoAux;
                nodoAux = nodoAux.proximo;
            }
            anterior.proximo = novoNodo;
            novoNodo.proximo = nodoAux;
        }
        quantidade++;
        return true;
    }
    public String buscar(int posicao) {
        Nodo nodoAux = this.inicio;
        for (int i = 0; i < posicao; i++)
            nodoAux = nodoAux.proximo;
        return nodoAux.item;
    }
    public int buscar(String chave) {
        int posicao = 0;
        for(Nodo n = this.inicio; n!=null; n = n.proximo) {
            if(n.item.equals(chave)) return posicao;
            posicao++;
        }
        return -1; //nao existe
    }
    public void remover(int posicao) {
        if(quantidade==0 || posicao-1>=this.quantidade) return;
        if(posicao<0) return;
        if(posicao==0) { //remover o inicio da lista
            this.inicio = this.inicio.proximo;
        }
        else {
            Nodo nodoAux = this.inicio;
            Nodo anterior = nodoAux;
            for (int i = 0; i < posicao; i++) { //ao sair do laco for o nodoAux sera o nodo a ser removido.
                anterior = nodoAux;
                nodoAux = nodoAux.proximo;
            }
            //removendo nodoAux
            anterior.proximo = nodoAux.proximo;
            if(nodoAux.proximo==null) {
                this.fim = anterior;
            }
        }
        quantidade--;
    }
    public void remover(String chave) {
        int posicao = buscar(chave);
        remover(posicao);
    }
    public boolean existe(String chave) {
        return buscar(chave)>=0;
    }
    public boolean estaVazia() {
        return (this.quantidade==0);
    }
    public void esvaziarLista() {
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }
    @Override
    public String toString() {
        if(this.quantidade==0) return "[]";
        String str = "[";
        for(Nodo n = this.inicio; n!=null; n = n.proximo) {
            str = str + " " + n.item + " ";
        }
        str = str + "] n = " + this.quantidade + " (inicio = " + this.inicio.item + ") (fim = " + this.fim.item + ")";
        return str;
    }

    public static void main(String[] args) {
        ListaLinearSimplesmenteEncadeada ls = new ListaLinearSimplesmenteEncadeada();
        ls.adicionar("leonardo");
        ls.adicionar("mariana");
        ls.adicionar("tales");
        ls.adicionar("alexandre");

        System.out.println(ls);

        ls.remover(0);
        System.out.println(ls);

        ls.remover("joao");
        System.out.println(ls);
        ls.remover("alexandre");
        System.out.println(ls);

        ls.adicionar(0, "joana");
        System.out.println(ls);

        ls.adicionar(122, "joana");
        System.out.println(ls);

        ls.adicionar(3, "tito");
        System.out.println(ls);

        ls.adicionar(3, "rafaela");
        System.out.println(ls);

        ls.adicionar(4, "lucas");
        System.out.println(ls);

        ls.adicionar(6, "ketelin");
        System.out.println(ls);

        ls.remover("joana");
        System.out.println(ls);

        ls.esvaziarLista();
        System.out.println(ls);
    }

}
