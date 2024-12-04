public class No {
    public No proximo;
    public Veiculo elemento;
    public No (Veiculo elemento, No proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }
    public No(){
        this.elemento = null;
        this.proximo = null;
    }
}
