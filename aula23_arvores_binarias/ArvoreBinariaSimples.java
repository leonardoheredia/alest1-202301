package aula23_arvores_binarias;
public class ArvoreBinariaSimples {

    public String item;
    private ArvoreBinariaSimples esquerda;
    private ArvoreBinariaSimples direita;
    private ArvoreBinariaSimples pai;

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
            System.out.println(arvore.item);
            percorrerPreOrdemRecursivo(arvore.esquerda);
            percorrerPreOrdemRecursivo(arvore.direita);
        }
    }

    public ArvoreBinariaSimples obterSubarvoreEsquerda() { return this.esquerda;}
    public ArvoreBinariaSimples obterSubarvoreDireita() { return this.direita;}
    public void imprimir() {
        System.out.println(this.item);
    }

    public int obterTamanho() {
        return 0;
    }

    public int obterAltura() {
        return 0;
    }

    public void removerSubArvoreEsquerda() {
        this.esquerda.pai = null;
        this.esquerda = null;
    }

    public void removerSubArvoreDireita() {
        this.direita.pai = null;
        this.direita = null;
    }
    public static void main(String[] args) {
        ArvoreBinariaSimples a = new ArvoreBinariaSimples("A");
        ArvoreBinariaSimples b = new ArvoreBinariaSimples("B");
        ArvoreBinariaSimples c = new ArvoreBinariaSimples("C");
        ArvoreBinariaSimples d = new ArvoreBinariaSimples("D");

        a.adicionarSubArvoreEsquerda(b);
        a.adicionarSubArvoreDireita(c);
        b.adicionarSubArvoreEsquerda(d);

        c.adicionarSubArvoreEsquerda(new ArvoreBinariaSimples("K"));
        c.adicionarSubArvoreDireita(new ArvoreBinariaSimples("J"));
        c.obterSubarvoreEsquerda().adicionarSubArvoreEsquerda(new ArvoreBinariaSimples("L"));
        c.obterSubarvoreEsquerda().adicionarSubArvoreDireita(new ArvoreBinariaSimples("M"));

        a.percorrerPreOrdem();

    }
}
