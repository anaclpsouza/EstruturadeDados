import java.util.ArrayList;

public class Fila {
    int tamanho = 0;
    int inicio = 0;
    int fim = 0;
    static final int TAM_MAX = 50;

    Processo[] fila = new Processo[TAM_MAX];

    public void enfileirar(Processo s) throws Exception {
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

    public Processo desenfileirar() throws Exception {
        if (isEmpty())
            throw new Exception("Fila vazia");
        Processo aux = fila[inicio];
        inicio++;
        if (inicio == TAM_MAX)
            inicio = 0;
        tamanho--;
        return aux;
    }

    public ArrayList<Processo> getAll() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila de processos vazia");
        }
        ArrayList<Processo> processos = new ArrayList<>();
        int i = inicio;

        while (i != fim) {
            processos.add(fila[i]);
            i++;

            if (i == TAM_MAX) {
                i = 0;
            }
        }
        return processos;
    }

    public Processo find(int n) throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila de processos vazia");
        }

        int i = inicio;
        while (i != fim) {
            if (fila[i].num == n) {
                return fila[i];
            }
            i++;
            if (i == TAM_MAX) {
                i = 0;
            }
        }
        return null;
    }

    public void delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila de processos vazia");
        }

        while (!isEmpty()) {
            this.desenfileirar();
        }
    }

    public boolean isFull() {
        return tamanho == TAM_MAX;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}
