public class Aluno {
    private int mat;
    private String nome;
    private String curso;

    public Aluno(int mat, String nome, String curso) {
        this.mat = mat;
        this.nome = nome;
        this.curso = curso;
    }

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    @Override
    public String toString() {
        return "Aluno [mat=" + mat + ", nome=" + nome + ", curso=" + curso + "] \n";
    }
}
