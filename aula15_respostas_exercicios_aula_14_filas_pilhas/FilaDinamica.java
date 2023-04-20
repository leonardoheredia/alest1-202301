package aula15_respostas_exercicios_aula_14_filas_pilhas;

public class FilaDinamica {
    private class Nodo {
        public String item;
        public Nodo proximo;
        public Nodo anterior;
        public Nodo(String item) {
            this.item = item;
        }
    }
    private int quantidade;
    private Nodo inicio;
    private Nodo fim;

    public void enfileirar(String item) {
        Nodo novoNodo = new Nodo(item);
        if(estaVazia()) { //primeiro item da fila
            this.inicio = novoNodo;
            this.fim = novoNodo;
        }
        else { //sempre adicionar no final
            this.fim.proximo = novoNodo;
            novoNodo.anterior = this.fim;
            novoNodo.proximo = null;
            this.fim = novoNodo;
        }
        quantidade++;
    }
    public boolean estaVazia() {
        return this.quantidade==0;
    }
    public String desenfileirar() {
        if(estaVazia()) return null;
         String retorno = this.inicio.item;
         this.inicio = this.inicio.proximo;
         if(this.inicio!=null) this.inicio.anterior = null;
         this.quantidade--;
         return retorno;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
    @Override
    public String toString() {
        if(estaVazia()) return "{}";
        String str="";
        for (Nodo n=this.inicio; n!=null; n=n.proximo) {
            str = str + " " + n.item + " ";
        }
        str = "FilaDinamica = {" + str + "}";
        str = str + " inicio = " + this.inicio.item + "   fim = " + this.fim.item + "  quantidade = " + this.quantidade;
        return str;
    }

    /*metodo reverso deve reverter a ordem da fila, o ultimo se torna o primeiro e assim por diante ate o antigo primeiro virar o ultimo*/
    public void reverter() {
        FilaDinamica novaFila = new FilaDinamica();
        Nodo aux = this.fim;
        while (aux!=null) {
            novaFila.enfileirar(aux.item);
            aux = aux.anterior;
        }
        this.inicio = novaFila.inicio;
        this.fim = novaFila.fim;
    }

    /*retorna se o item está na fila ou nao*/
    public boolean estaNaFila(String item) {
        return posicaoNaFila(item)>=0;
    }
    /*retorna a posicao do elemento na fila, se ele não existir retorna -1*/
    public int posicaoNaFila(String item) {
        int pos = 0;
        for (Nodo n = this.inicio; n!=null; n = n.proximo) {
            if(n.item.equals(item)) return pos;
            pos++;
        }
        return -1;
    }
    public void mergearFila(FilaDinamica fila) {
        //o primeiro elemento da fila recebida se torna o ultimo da fila atual
        //basta percorrer a fila recebid por parametro e ir enfileirando cada item na fila atual
        for (Nodo n = fila.inicio; n!=null; n = n.proximo) {
            this.enfileirar(n.item);
        }
    }
    public void mergearFilaSolucaoOtimizada(FilaDinamica fila) {
        //o primeiro elemento da fila recebida se torna o ultimo da fila atual
        //Prof vai implementar, ligando o final da fila com o inicio da anterior
        this.fim.proximo = fila.inicio;
        this.fim = fila.fim;
        this.quantidade = this.quantidade + fila.quantidade;
    }

    /*retorna o maior elemento (que tem mais caracteres), se tiver mais de um retorna o que esta na frente na fila*/
    public String maiorItem() {
        return "";
    }
    public static void main(String[] args) {
        FilaDinamica minhaFila = new FilaDinamica();

        minhaFila.enfileirar("Alexandre");
        minhaFila.enfileirar("Leonardo");
        minhaFila.enfileirar("Tales");
        minhaFila.enfileirar("Mariana");
        minhaFila.enfileirar("Joana");
        System.out.println(minhaFila);

        System.out.println(minhaFila.posicaoNaFila("Mariana"));
        System.out.println(minhaFila.posicaoNaFila("Joana"));
        System.out.println(minhaFila.posicaoNaFila("Lucas"));
        System.out.println(minhaFila.posicaoNaFila("Alexandre"));


        FilaDinamica novaFila = new FilaDinamica();
        novaFila.enfileirar("Claudio");
        novaFila.enfileirar("Lorena");
        novaFila.enfileirar("Fabiola");
        System.out.println("Nova fila");
        System.out.println(novaFila);

        minhaFila.mergearFilaSolucaoOtimizada(novaFila);
        System.out.println(minhaFila);

    }
}
