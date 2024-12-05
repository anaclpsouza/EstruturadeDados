public class ListaEncadeada {
    public No cabeca = new No();
    private No cauda = cabeca;
    private No elemento;

    public int tamanho = 0;

    public void add(Cidade c) {
        elemento = new No(c, null, null);

        if (tamanho == 0) { // Lista vazia
            cabeca.proximo = elemento;
            elemento.anterior = cabeca;
            cauda = elemento;
        } else if (c.getNota() > cabeca.proximo.elemento.getNota()) { // Inserir no início
            elemento.proximo = cabeca.proximo;
            cabeca.proximo.anterior = elemento;
            cabeca.proximo = elemento;
            elemento.anterior = cabeca;
        } else if (c.getNota() < cauda.elemento.getNota()) { // Inserir no final
            cauda.proximo = elemento;
            elemento.anterior = cauda;
            cauda = elemento;
        } else { // Inserir no meio
            No atual = cabeca.proximo;
            while (atual.proximo != null && atual.proximo.elemento.getNota() > c.getNota()) {
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

    public void excluir(String nome, String pais) throws Exception {
        No atual = cabeca.proximo;
        No anterior = cabeca;
        boolean encontrado = false;

        while (atual != null) {
            if (atual.elemento.getNome().equals(nome) && atual.elemento.getPais().equals(pais)) {
                encontrado = true;
                break;
            }
            anterior = atual;
            atual = atual.proximo;
        }

        if (!encontrado) {
            throw new Exception("Cidade não encontrada.");
        }

        anterior.proximo = atual.proximo;
        tamanho--;
    }

    public int tamanho() {
        return tamanho;
    }
}
