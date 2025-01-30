public class Fila {
    int tam = 0;
    private No cabeca = new No();
    private No cauda = cabeca;
    private No el;

    public void enfileirar(String aviao) {
        el = new No(aviao, null);
        if (tam != 0) {
            cauda.proximo = el;
        } else {
            cabeca = el;
        }
        cauda = el;
        tam++;
    }

    public String desenfileirar() throws Exception {
        if (isEmpty()) {
            throw new Exception("Sua fila está vazia");
        }
        String el = cabeca.elemento;
        cabeca = cabeca.proximo;
        tam--;
        return el;
    }

    public boolean isEmpty() {
        return tam == 0;
    }

    public int tamFila() {
        return tam;
    }
}
