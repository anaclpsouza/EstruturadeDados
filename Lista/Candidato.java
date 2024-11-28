public class Candidato {
    private String nome;
    private int nota;
    private int insc;

    
    public Candidato(String nome, int nota, int i) {
        this.nome = nome;
        this.nota = nota;
        this.insc = i;
    }
    

    public int gerarInsc(int insc) {
        insc = insc + 1;
        return insc;
    }
    

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getNota() {
        return nota;
    }


    public void setNota(int nota) {
        this.nota = nota;
    }


    public int getInsc() {
        return insc;
    }


    public void setInsc(int insc) {
        this.insc = insc;
    }

    
}
