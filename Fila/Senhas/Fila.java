public class Fila {
    int tamanho = 0;
    int inicio = 0;
    int fim = 0;
    static final int TAM_MAX = 50;

    Senha[] fila = new Senha[TAM_MAX];

    public void enfileirar(Senha s) throws Exception {
        if (isFull()) {
            throw new Exception("Fila cheia");
        }

        fila[fim] = s;
        fim++;
        if (fim == TAM_MAX) {
            fim = 0;
        }
        tamanho++;
    }

    public Senha desenfileirar() throws Exception {
        if (isEmpty())
            throw new Exception("Fila vazia");
        Senha aux = fila[inicio];
        inicio++;
        if (inicio == TAM_MAX)
            inicio = 0;
        tamanho--;
        return aux;
    }

    public boolean isFull() {
        return tamanho == TAM_MAX;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}
