public class PilhaReferencia {
    int tam = 0;
    Num topo;

    public boolean isVazia() {
        return tam==0;
    }

    public int getTamanho() {
        return tam;
    }

    public void push(Num n) {
        if (tam!=0) {
            n.prox = topo;
        }
        topo = n;
        ++tam;
    }

    public Num pop() throws Exception{
        if (isVazia()) {
            throw new Exception("Pilha Vazia");
        }
        Num n = topo;
        topo = topo.prox;
        --tam;
        return n;
    }
}
