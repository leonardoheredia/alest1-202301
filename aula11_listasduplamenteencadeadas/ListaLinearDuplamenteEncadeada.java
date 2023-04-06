package aula11_listasduplamenteencadeadas;

import aula10_respostas.ListaLinearSimplesmenteEncadeada;

public class ListaLinearDuplamenteEncadeada {

    private class Nodo {
        private String item;
        private Nodo anterior;
        private Nodo proximo;
        private Nodo(String item) {
            this.item = item;
            this.proximo = null;
            this.anterior = null;
        }
    }
    private int quantidade;
    private Nodo inicio;
    private Nodo fim;

    public ListaLinearDuplamenteEncadeada() {
        this.inicio = new Nodo("");
        this.fim = new Nodo("");
        this.quantidade = 0;
    }


    public void adicionar(String item) {
        Nodo novoNodo = new Nodo(item);

        if(quantidade==0) {
            inicio.proximo = novoNodo;
            fim.anterior = novoNodo;
            quantidade++;
            return;
        }

        novoNodo.proximo = fim;
        novoNodo.anterior = fim.anterior;
        fim.anterior = novoNodo;
        novoNodo.anterior.proximo = novoNodo;
        quantidade++;
    }




    public String buscar(int posicao) {
        //implrmentar
        return "";
    }
    public boolean adicionar(int posicao, String item) {
        //implementar
        return false;
    }






    public String toString() {
        if(this.quantidade==0) return "[]";
        String str = "[";
        for(Nodo n = this.inicio.proximo; n!=null; n = n.proximo) {
            str = str + " " + n.item + " ";
        }
        str = str + "] n = " + this.quantidade + " (inicio = " + this.inicio.proximo.item + ") (fim = " + this.fim.anterior.item + ")";
        return str;
    }

    public static void main(String[] args) {
        ListaLinearDuplamenteEncadeada ld = new ListaLinearDuplamenteEncadeada();
        ld.adicionar("leonardo");
        ld.adicionar("mariana");
        ld.adicionar("tito");
        System.out.println(ld);
    }
}
