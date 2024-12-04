public class ListaEncadeada {
    private No cabeca = new No();
    private No cauda = cabeca;
    private No elemento;

    public int tamanho = 0;

    public void add(Cliente c) {
        elemento = new No(c, null, null);

        if (tamanho == 0) { // Lista vazia
            cabeca.proximo = elemento;
            cauda = elemento;
            elemento.anterior = cabeca;
        } else if (c.getCod() < cabeca.proximo.elemento.getCod()) { // Inserir no início
            elemento.proximo = cabeca.proximo;
            cabeca.proximo.anterior = elemento;
            cabeca.proximo = elemento;
            elemento.anterior = cabeca;
        } else if (c.getCod() > cauda.elemento.getCod()) { // Inserir no final
            cauda.proximo = elemento;
            elemento.anterior = cauda;
            cauda = elemento;
        } else { // Inserir no meio
            No atual = cabeca.proximo;
            while (atual.proximo != null && atual.proximo.elemento.getCod() < c.getCod()) {
                atual = atual.proximo;
            }

            elemento.proximo = atual.proximo;

            if (atual.proximo != null) {
                atual.proximo.anterior = elemento;
            }

            atual.proximo = elemento;
            elemento.anterior = atual;
        }

        tamanho++;
    }

    public String exibirCrescente() {
        StringBuilder sb = new StringBuilder();
        No atual = cabeca.proximo;
        while (atual != null) {
            sb.append(atual.elemento.getCod() + " | ").append(atual.elemento.getNome() + " | ").append(atual.elemento.getTel() + " | ")
                    .append("\n");
            atual = atual.proximo;
        }
        return sb.toString();
    }

    public String exibirDecrescente() {
        StringBuilder sb = new StringBuilder();
        No atual = cauda;
        while (atual != null && atual != cabeca) {
            sb.append(atual.elemento.getCod() + " | ").append(atual.elemento.getNome() + " | ").append(atual.elemento.getTel() + " | ")
                    .append("\n");
            atual = atual.anterior;
        }
        return sb.toString();
    }
}
