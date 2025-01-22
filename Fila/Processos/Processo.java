public class Processo {
    int num;
    String titulo;
    public Processo(int num, String titulo) {
        this.num = num;
        this.titulo = titulo;
    }
    public String toString() {
        return " Título: " + this.titulo + " N°: " + this.num + "  \n";
    }
}
