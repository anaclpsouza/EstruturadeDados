public class No {
    public No direita;
    public No esquerda;
    public int ano;
    public double temperatura;

    public No(int ano, double temperatura) {
        this.ano = ano;
        this.temperatura = temperatura;
        this.esquerda = null;
        this.direita = null;
    }
    
}
