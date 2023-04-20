package aula15_respostas_exercicios_aula_14_filas_pilhas;

public class PilhaEstatica {
    private static final int CAPACIDADE_DEFAULT = 5;
    private String[] itens;
    private int capacidade;
    private int quantidade;
    private int topo;
    private int base;

    public PilhaEstatica() {
        this.capacidade = CAPACIDADE_DEFAULT;
        this.itens = new String[this.capacidade];
        this.quantidade = 0;
        this.topo = -1;
        this.base = 0;
    }
    public void empilhar(String item) {
        if(estaLotada()) {
            System.out.println("Pilha lotada. Não há mais espaço.");
            return;
        }
        this.topo++;
        this.itens[topo] = item;
        this.quantidade++;
    }
    public String desempilhar() {
        if(this.estaVazia()) return null;

        String valor = this.itens[this.topo];
        this.itens[this.topo] = null;
        topo--;
        quantidade--;
        return valor;
    }
    public String verTopo() {
        String retorno;
        if(this.estaVazia()) retorno=null;
        else retorno = this.itens[this.topo];
        return retorno;
    }
    public boolean estaVazia() {
        return (quantidade==0);
    }
    public void limpar() {
        this.itens = new String[this.capacidade];
        this.quantidade = 0;
        this.topo = -1;
        this.base = 0;
    }
    public boolean estaLotada() {
        return (this.quantidade==this.capacidade);
    }
    @Override
    public String toString() {
        String str="";
        for (int i = 0; i < this.capacidade; i++) {
            str = str + " " + this.itens[i] + " ";
        }
        str = "PilhaEstatica = {" + str + "}";
        str = str + " base = " + this.base + "   topo = " + this.topo + "  quantidade = " + this.quantidade + "  capacidade = " + this.capacidade;
        return str;
    }
    /*metodo reverso deve reverter a ordem da fila, o ultimo se torna o primeiro e assim por diante ate o antigo primeiro virar o ultimo*/
    public void reverter() {
        PilhaEstatica novaPilha = new PilhaEstatica();
        for (int i = this.topo; i >= this.base ; i--) {
            novaPilha.empilhar(this.itens[i]);
        }
        this.itens = novaPilha.itens;
    }
    /*retorna se o item está na fila ou nao*/
    public boolean estaNaPilha(String item) {
        return posicaoNaPilha(item)>=0;
    }
    /*retorna a posicao do elemento na fila, se ele não existir retorna -1*/
    public int posicaoNaPilha(String item) {
        for (int i = 0; i <= this.topo ; i++) {
            if(this.itens[i].equals(item)) return i;
        }
        return -1;
    }
    public void mergearPilha(PilhaEstatica pilha) {
        //a base da pilha recebida se torna o topo da pilha atual
    }
    /*retorna o maior elemento (que tem mais caracteres), se tiver mais de um retorna o que esta mais proximo do topo*/
    public String maiorItem() {
        String aux = "";
        for (int i = base; i <=topo ; i++) {
            if(itens[i].length()>=aux.length()) aux = itens[i];
        }
        return aux;

    }

    public static void main(String[] args) {
        PilhaEstatica pilha = new PilhaEstatica();

        System.out.println(pilha);
        pilha.empilhar("Alexandre");
        pilha.empilhar("Leonardo");
        pilha.empilhar("Tales");
        pilha.empilhar("Mariana");
        pilha.empilhar("Joana");
        System.out.println(pilha);

        pilha.reverter();
        System.out.println(pilha);

        System.out.println(pilha.posicaoNaPilha("Joana"));
        System.out.println(pilha.posicaoNaPilha("Tales"));
        System.out.println(pilha.posicaoNaPilha("Alexandre"));
        System.out.println(pilha.posicaoNaPilha("Leandro"));

        System.out.println(pilha.maiorItem());
    }
}
