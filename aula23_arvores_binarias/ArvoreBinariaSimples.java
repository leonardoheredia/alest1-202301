package aula23_arvores_binarias;
public class ArvoreBinariaSimples {

    public String item;
    public ArvoreBinariaSimples esquerda;
    public ArvoreBinariaSimples direita;
    public ArvoreBinariaSimples pai;

    public ArvoreBinariaSimples(String item) {
        this.item = item;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
    public void adicionarSubArvoreEsquerda(ArvoreBinariaSimples subarvore) {
        this.esquerda = subarvore;
        subarvore.pai = this;
    }
    public void adicionarSubArvoreDireita(ArvoreBinariaSimples subarvore) {
        this.direita = subarvore;
        subarvore.pai = this;
    }

    public void percorrerPreOrdem() {
        percorrerPreOrdemRecursivo(this);
    }
    private void percorrerPreOrdemRecursivo(ArvoreBinariaSimples arvore) {
        if(arvore!=null) {
            percorrerPreOrdemRecursivo(arvore.esquerda);
            percorrerPreOrdemRecursivo(arvore.direita);
        }
    }

    public void imprimir() {
        System.out.println(this.item);
    }

    public static void main(String[] args) {
        ArvoreBinariaSimples a = new ArvoreBinariaSimples("A");
        ArvoreBinariaSimples b = new ArvoreBinariaSimples("B");
        ArvoreBinariaSimples c = new ArvoreBinariaSimples("C");
        ArvoreBinariaSimples d = new ArvoreBinariaSimples("D");

        a.adicionarSubArvoreEsquerda(b);
        a.adicionarSubArvoreDireita(c);
        b.adicionarSubArvoreEsquerda(d);



    }
}
