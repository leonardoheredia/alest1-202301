package aula24_arvores_binarias_pesquisa;

public class AppExemplo {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa();
        abp.adicionar(100);
        abp.adicionar(30);
        abp.adicionar(200);
        abp.adicionar(78);
        abp.adicionar(250);
        abp.adicionar(120);
        abp.imprimirArvore();
    }
}
