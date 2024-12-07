public class Pilha {
    static final int MAX_TAM = 1000;
    Vagao[] pilha = new Vagao[MAX_TAM];
    int topo = -1;

    public boolean isVazia() {
        return topo == -1;
    }

    public int getTamanho() {
        return topo + 1;
    }

    public Vagao top() throws Exception{
        if (this.isVazia()) {
           throw new Exception("Pilha vazia"); 
        }
        return pilha[topo];
    }

    public void push(Vagao v) throws Exception {
        if (topo == MAX_TAM - 1) {
            throw new Exception("Não há espaço disponível");
        }
        pilha[++topo] = v;
    }

    public Vagao pop() throws Exception {
        if (isVazia()) {
            throw new Exception("Lista vazia");
        }
        return pilha[topo--];
    }

    public boolean ePossivel(Pilha pilha) throws Exception {
        if (pilha.isVazia()) {
            throw new Exception("A pilha está vazia");
        }

        int x = 1;

        boolean ordem = false;
        Pilha estacao = new Pilha(); 
        int primeiroDaFila = pilha.top().getNum();

        while (!pilha.isVazia()) {
            if (!estacao.isVazia() && estacao.top().getNum() == primeiroDaFila) {
                estacao.pop();
                pilha.pop();

                if (!pilha.isVazia()) {
                    primeiroDaFila = pilha.top().getNum();
                }
                ordem = true;
            } else if (x <= MAX_TAM) {
                estacao.push(new Vagao(x));
                x++;
            } else {
                return false;
            }

        }

        return ordem;

    }

    public void limparPilha() throws Exception {
        while (!isVazia()) {
            pop();
        }
    }

}
