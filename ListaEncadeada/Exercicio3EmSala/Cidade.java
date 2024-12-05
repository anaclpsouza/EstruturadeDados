public class Cidade {
    private String nome, pais, pontos;
    int nota;
    public Cidade(String nome, String pais, String pontos, int nota) {
        this.nome = nome;
        this.pais = pais;
        this.pontos = pontos;
        this.nota = nota;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getPontos() {
        return pontos;
    }
    public void setPontos(String pontos) {
        this.pontos = pontos;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
    
}
