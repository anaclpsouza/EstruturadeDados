public class No {
    public No proximo;
    public String elemento;
    public No (String elemento, No proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }
    public No(){
        this.elemento = null;
        this.proximo = null;
    }
}