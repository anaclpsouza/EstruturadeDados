public class ListaEncadeada {
    private No cabeca = new No();
    private No cauda = cabeca;
    private No elemento;

    public int tamanho = 0;

    public void add(Veiculo v) {
        elemento = new No(v, null);
        cauda.proximo = elemento;
        cauda = elemento;
        tamanho++;
    }

    public String exibir() {
        StringBuilder sb = new StringBuilder();
        No atual = cabeca.proximo;
        while (atual != null) {
            sb.append(atual.elemento.getPlaca() + " | ").append(atual.elemento.getMarca() + " | ")
                    .append(atual.elemento.getModelo() + " | ").append(atual.elemento.getValor()).append("\n");
            atual = atual.proximo;
        }
        return sb.toString();
    }

    public void excluir(String placa) throws Exception {
        No atual = cabeca.proximo;
        No anterior = cabeca; 
        boolean encontrado = false;
    
        while (atual != null) {
            if (atual.elemento.getPlaca().equals(placa)) {
                encontrado = true;
                break;
            }
            anterior = atual;
            atual = atual.proximo; 
        }
    
        if (!encontrado) {
            throw new Exception("Placa não encontrada.");
        }
    
        anterior.proximo = atual.proximo;
        tamanho--;
    }

}
