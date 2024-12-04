public class Cliente {
    private int cod;
    private String nome;
    private String tel;

    public Cliente() {}

    public Cliente(int cod, String nome,String tel) {
        this.cod = cod;
        this.nome = nome;
        this.tel = tel;
    }

    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}
