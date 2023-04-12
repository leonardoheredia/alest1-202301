package aula14_exercicios_filas_pilhas;

public class FilaEstaticaCircular {

    private static final int CAPACIDADE_INICIAL = 6;
    private String[] itens;
    private int capacidade;
    private int quantidade;
    private int inicio;
    private int fim;

    public FilaEstaticaCircular() {
        this.capacidade = CAPACIDADE_INICIAL;
        this.itens = new String[this.capacidade];
        this.quantidade = 0;
        this.inicio = 0;
        this.fim = -1;
    }

    public void enfileirar(String item) {
        if(this.estaLotada()) {
            System.out.println("Sinto muito, a fila está lotada");
            return;
        }
        int posicao = this.fim+1;
        if(posicao==capacidade) { //chegou ao final do array mas ainda tem espaco pois a final nao esta lotada, entao circular
            posicao = 0;
        }
        this.itens[posicao] = item;
        this.fim = posicao;
        this.quantidade++;
    }

    public String desenfileirar() {
        if(this.estaVazia()) {
            System.out.println("Sinto muito, a fila está vazia");
            return null;
        }
        String retorno = itens[this.inicio];
        itens[this.inicio] = null;
        if(this.inicio+1==capacidade) { //o inicio tentou mover alem da capacidade, siginifica que tiramos o ultimo e entao o inicio volta a ser 0
            this.inicio = -1;
        }
        this.inicio++;
        this.quantidade--;
        if(this.estaVazia()) {
            this.limpar();
        }
        return retorno;
    }

    public void limpar() {
        for (int i = 0; i < this.capacidade; i++) {
            itens[i] = null;
        }
        this.quantidade = 0;
        this.inicio = 0;
        this.fim = -1;
    }

    @Override
    public String toString() {
        String str="";
        for (int i = 0; i < this.capacidade; i++) {
            str = str + " " + this.itens[i] + " ";
        }
        str = "FilaEstatica = {" + str + "}";
        str = str + " inicio = " + this.inicio + "   fim = " + this.fim + "  quantidade = " + this.quantidade + "  capacidade = " + this.capacidade;
        return str;
    }

    public boolean estaVazia() {
        return this.quantidade==0;
    }

    public boolean estaLotada() {
        return this.quantidade == this.capacidade;
    }

    /*metodo reverso deve reverter a ordem da fila, o ultimo se torna o primeiro e assim por diante ate o antigo primeiro virar o ultimo*/
    public void reverso() {
        //implementar
    }

    /*retorna se o item está na fila ou nao*/
    public boolean estaNaFila(String item) {
        return false;
    }

    /*retorna a posicao do elemento na fila, se ele não existir retorna -1*/
    public int posicaoNaFila(String item) {
        return -1;
    }
    public void mergearFila(FilaEstaticaCircular fila) {
        //o primeiro elemento da fila recebida se torna o ultimo da fila atual
    }
    /*retorna o maior elemento (que tem mais caracteres), se tiver mais de um retorna o que esta na frente na fila*/
    public String maiorItem() {
        return "";
    }
    public static void main(String[] args) {
        FilaEstaticaCircular minhaFila = new FilaEstaticaCircular();
        System.out.println(minhaFila);

        minhaFila.enfileirar("Alexandre");
        minhaFila.enfileirar("Leonardo");
        minhaFila.enfileirar("Tales");
        System.out.println(minhaFila);

        minhaFila.enfileirar("Leandro");
        System.out.println(minhaFila);

        minhaFila.desenfileirar();
        System.out.println(minhaFila);

        minhaFila.enfileirar("Tito");
        System.out.println(minhaFila);

        minhaFila.enfileirar("Mariana");
        System.out.println(minhaFila);

        minhaFila.desenfileirar();
        System.out.println(minhaFila);

        minhaFila.enfileirar("Lucas");
        System.out.println(minhaFila);

        minhaFila.enfileirar("Lucas2");
        System.out.println(minhaFila);

        minhaFila.desenfileirar();
        minhaFila.desenfileirar();
        minhaFila.desenfileirar();
        minhaFila.desenfileirar();
        minhaFila.desenfileirar();
        minhaFila.desenfileirar();
        minhaFila.desenfileirar();
        System.out.println(minhaFila);

        minhaFila.enfileirar("Lucas2");
        System.out.println(minhaFila);

        minhaFila.desenfileirar();
        System.out.println(minhaFila);
    }
}
