package aula13_pilhas.alocacao_estatica;

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
        //ATIVIDADE: implementar o tratamento para evitar o estouro de pilha
        this.topo++;
        this.itens[topo] = item;
        this.quantidade++;
    }

    public String desempilhar() {
        String valor = this.itens[this.topo];
        this.itens[this.topo] = null;
        topo--;
        quantidade--;
        return valor;
    }

    public String verTopo() {
        //retorna o topo sem desempilhar
        //implementar
        return "";
    }

    public boolean estaVazia() {
        //implementar
        return false;
    }

    public void limpar() {
        //limpar a pilha
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

    public static void main(String[] args) {
        PilhaEstatica pilha = new PilhaEstatica();

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
