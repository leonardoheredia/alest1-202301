package aula09_tad_listaslineares;

public class ListaLinearEstatica {
    private static final int CAPACIDADE_INICIAL = 3;
    private String[] itens;
    private int capacidade;
    private int tamanho;
    public ListaLinearEstatica() {
        this.capacidade = CAPACIDADE_INICIAL;
        this.itens = new String[CAPACIDADE_INICIAL];
        this.tamanho = 0;

    }
    public void adicionar(String item) {
        gerenciarCapacidade();
        this.itens[tamanho] = item;
        this.tamanho++;
    }
    public void adicionar(int posicao, String item) {
        gerenciarCapacidade();
        // 0 1 2 3 4  - inserir x na posicao 2, move tudo uma posicao a frente
        // c f d e w
        // 0 1 2 3 4 5
        //           w
        for (int i = this.tamanho-1; i >=posicao; i--) {
            this.itens[i+1] = this.itens[i];
        }
        this.itens[posicao] = item;
        this.tamanho++;
    }
    public int buscar(String chave) {
        for (int i = 0; i < tamanho; i++) {
            if(itens[i].equals(chave)) return i;
        }
        return -1;
    }
    public boolean remover(int posicao) {
        this.itens[posicao] = "";
        // 0 1 2 3 4 5 - remover o e da posicao 4, remove e entao reorganiza o array
        // c f x d - w
        for (int i = posicao+1; i < this.tamanho ; i++) {
            this.itens[i-1] = this.itens[i];
        }
        this.itens[tamanho-1] = null;
        this.tamanho--;
        return true;
    }
    public int remover(String chave) {
        int posicao = buscar(chave);
        if(posicao<0) { //chave nao existe, vai retornar -1
            return -1;
        }
        if(this.remover(posicao)) return posicao;
        else return -1;
    }
    public boolean contem(String chave) {
        int aux = buscar(chave);
        return (aux>=0);
    }
    public boolean estaVazia() {
        return (tamanho==0);
    }
    public void limpar() {
        for (int i = 0; i < tamanho; i++) {
            itens[i] = null;
            tamanho--;
        }
    }
    public void gerenciarCapacidade() {
        if(this.tamanho<this.capacidade)  { //não chegou no limite
            return;
        }
        int novaCapacidade = this.capacidade * 2; //dobra a capacidade
        String[] auxItens = new String[novaCapacidade];
        for (int i = 0; i < this.tamanho; i++) {
            auxItens[i] = this.itens[i];
        }
        this.itens = auxItens;
        this.capacidade = novaCapacidade;
    }
    @Override
    public String toString() {
        String str="";
        for (int i = 0; i < this.tamanho; i++) {
            str = str + " " + this.itens[i] + " ";
        }
        str = "ListaLinearSequencial = {" + str + "}";
        return str;
    }
    public static void main(String[] args) {
        ListaLinearEstatica l = new ListaLinearEstatica();
        l.adicionar("c");
        l.adicionar("f");
        l.adicionar("d");
        l.adicionar("e");
        l.adicionar("w");
        l.adicionar(2, "x");
        l.remover("e");
        l.remover(0);
        System.out.printf("%n Tamanaho = %d", l.tamanho);
        System.out.printf("%n Buscar(c) = %d", l.buscar("d"));
        System.out.printf("%n Capacidade = %d", l.capacidade);
        System.out.printf("%n %s", l.toString());

    }


}
