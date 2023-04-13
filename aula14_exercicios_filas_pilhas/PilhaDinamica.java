package aula14_exercicios_filas_pilhas;

public class PilhaDinamica {
    private class Nodo {
        public String item;
        public Nodo anterior;
        public Nodo proximo;

        public Nodo(String item) {
            this.item = item;
        }
    }
    private Nodo base;
    private Nodo topo;
    private int quantidade;
    public PilhaDinamica() {
        this.quantidade = 0;
        this.base = null;
        this.topo = null;
    }
    public void empilhar(String item) {
        Nodo novoNodo = new Nodo(item);
        if(estaVazia()) {
            this.base = novoNodo;
            this.topo = novoNodo;
        }
        else {
            novoNodo.anterior = this.topo;
            this.topo.proximo = novoNodo;
            this.topo = novoNodo;
        }
        quantidade++;
    }
    public String desempilhar() {
        if(estaVazia()) return null;
        String retorno = this.topo.item;
        this.topo = this.topo.anterior;
        if(this.topo!=null) this.topo.proximo = null;
        this.quantidade--;
        return retorno;
    }
    public boolean estaVazia() {
        return (quantidade==0);
    }
    public String verTopo() {
        if(estaVazia()) return null;
        return this.topo.item;
    }
    @Override
    public String toString() {
        if(estaVazia()) return "{}";
        String str="";
        for (Nodo n = this.base; n!=null; n=n.proximo) {
            str = str + " " + n.item + " ";
        }
        str = "PilhaDinamica = {" + str + "}";
        str = str + " base = " + this.base.item + "   topo = " + this.topo.item + "  quantidade = " + this.quantidade;
        return str;
    }

    /*metodo reverso deve reverter a ordem da fila, o ultimo se torna o primeiro e assim por diante ate o antigo primeiro virar o ultimo*/
    public void reverso() {
        //implementar
    }
    /*retorna se o item está na fila ou nao*/
    public boolean estaNaPilha(String item) {
        return false;
    }
    /*retorna a posicao do elemento na fila, se ele não existir retorna -1*/
    public int posicaoNaPilha(String item) {
        return -1;
    }
    public void mergearPilha(PilhaDinamica pilha) {
        //a base da pilha recebida se torna o topo da pilha atual
    }
    /*retorna o maior elemento (que tem mais caracteres), se tiver mais de um retorna o que esta mais proximo do topo*/
    public String maiorItem() {
        return "";
    }
    public static void main(String[] args) {
        PilhaDinamica pilha = new PilhaDinamica();

        System.out.println(pilha);
        pilha.empilhar("Alexandre");
        pilha.empilhar("Leonardo");
        pilha.empilhar("Tales");
        System.out.println(pilha);

        pilha.empilhar("Leandro");
        System.out.println(pilha);

        System.out.println("Desempilhou --> " + pilha.desempilhar());
        System.out.println(pilha);

        pilha.empilhar("Tito");
        System.out.println(pilha);

        pilha.empilhar("Mariana");
        System.out.println(pilha);

        pilha.empilhar("Lucas");
        System.out.println(pilha);


    }
}
