public class Fila {
    int tamanho = 0;
    int inicio = 0;
    int fim = 0;
    static final int TAM_MAX = 50;

    int[] fila = new int[TAM_MAX];

    public void enfileirarInicio(int s) throws Exception {
        if (isFull()) {
            throw new Exception("Fila cheia");
        }

        for (int i = 1; i <= s; i++) {
            fila[fim] = i;
            fim++;
            if (fim == TAM_MAX) {
                fim = 0;
            }
            tamanho++;
        }
    }


    public void enfileirar(int i) throws Exception {
        if (isFull()) {
            throw new Exception("Fila cheia");
        }

        
            fila[fim] = i;
            fim++;
            if (fim == TAM_MAX) {
                fim = 0;
            }
            tamanho++;
        
    }


    public int desenfileirar() throws Exception {
        if (isEmpty())
            throw new Exception("Fila vazia");
        int aux = fila[inicio];
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

    public boolean tamFila() {
        return tamanho == 1;
    }
}
