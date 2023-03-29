package aula09_tad_listaslineares;

public class DemoListaLinear {
    public static void main(String[] args) {
        ListaLinearEstatica lista = new ListaLinearEstatica();
        lista.adicionar("leonardo");
        lista.adicionar("matheus");
        lista.adicionar("clarissa");
        lista.adicionar("enzo");
        lista.adicionar("felipe");

        System.out.println(lista);

        lista.remover("enzo");
        lista.remover("felipe");

        System.out.println(lista);

        lista.limpar();

        System.out.println(lista);


    }
}
