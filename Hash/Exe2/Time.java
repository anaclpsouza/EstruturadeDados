public class Time {
    private String codigo;
    private String nome;
    private int anoF;
    private String presidente;
    private String tecnico;

    public Time(String codigo, String nome, int anoF, String presidente, String tecnico) {
        this.codigo = codigo;
        this.nome = nome;
        this.anoF = anoF;
        this.presidente = presidente;
        this.tecnico = tecnico;
    }

    public Time() {
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getAnoF() {
        return anoF;
    }
    public void setAnoF(int anoF) {
        this.anoF = anoF;
    }
    public String getPresidente() {
        return presidente;
    }
    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }
    public String getTecnico() {
        return tecnico;
    }
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    @Override
    public String toString() {
        return "Time [Código=" + codigo + ", Nome=" + nome + ", Ano de fundação=" + anoF + ", Presidente=" + presidente
                + ", Técnico=" + tecnico + "]";
    }

    
}
