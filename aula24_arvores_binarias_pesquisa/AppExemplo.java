package aula24_arvores_binarias_pesquisa;

import java.util.ArrayList;

public class AppExemplo {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa abp = new ArvoreBinariaPesquisa();
        abp.adicionar(100);
        abp.adicionar(30);
        abp.adicionar(200);
        abp.adicionar(78);
        abp.adicionar(250);
        abp.adicionar(120);
        abp.adicionar(20);
        abp.adicionar(15);
        abp.adicionar(300);
        abp.adicionar(290);
        abp.imprimirArvore();

        System.out.println("Tamanho da arvore = " + abp.obterTamanho());
        ArrayList<Integer> preordem = abp.elementosPreOrdem();
        for (Integer i:preordem) {
            System.out.println(i);
        }

        System.out.println(abp.existe(78));
        System.out.println(abp.existe(999));
        System.out.println(abp.existe(10));

        ArrayList<Integer> largura = abp.elementosLargura();
        for (Integer i:largura) {
            System.out.println(i);
        }

        System.out.println(abp.altura());

        System.out.println("ABP exemplo 2");
        ArvoreBinariaPesquisa abp2 = new ArvoreBinariaPesquisa();
        abp2.adicionarNaoRecursivo(100);
        abp2.adicionarNaoRecursivo(30);
        abp2.adicionarNaoRecursivo(200);
        abp2.adicionarNaoRecursivo(78);
        abp2.adicionarNaoRecursivo(250);
        abp2.adicionarNaoRecursivo(120);
        abp2.adicionarNaoRecursivo(20);
        abp2.adicionarNaoRecursivo(15);
        abp2.adicionarNaoRecursivo(300);
        abp2.adicionarNaoRecursivo(290);
        abp2.imprimirArvore();
    }
}
