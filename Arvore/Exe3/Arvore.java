public class Arvore {
    No raiz = null;

    public void inserir(int ano, double temp) {
        this.raiz = inserirRec(this.raiz, ano, temp);
    }

    private No inserirRec(No no, int ano, double temp) {
        if (no == null) {
            return new No(ano, temp);
        }
        if (no.temperatura > temp) {
            no.esquerda = inserirRec(no.esquerda, ano, temp);
        } else {
            no.direita = inserirRec(no.direita, ano, temp);
        }
        return no;
    }
    
    public No maiorAno() throws Exception {
        return maiorAnoRec(this.raiz);
    }

    private No maiorAnoRec(No no) throws Exception {
        if (no == null)
            throw new Exception("Raiz nula");
        if (no.direita != null)
            return maiorAnoRec(no.direita);
        else
            return no;
    }

    public void limparArvore() {
        this.raiz = null;
    }
}
