public class PilhaReferencia {
    int tam = 0;
    Carta topo;

    public boolean isVazia() {
        return tam==0;
    }

    public int getTamanho() {
        return tam;
    }

    public void push(Carta n) {

        if (tam!=0) {
            n.prox = topo;
        }
        topo = n;
        ++tam;
    }

    public Carta pop() throws Exception{
        if (isVazia()) {
            throw new Exception("Pilha Vazia");
        }
        Carta n = topo;
        topo = topo.prox;
        --tam;
        return n;
    }

}
