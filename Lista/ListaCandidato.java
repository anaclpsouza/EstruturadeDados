public class ListaCandidato {
    private Candidato[] C;
    private int tam = 20;
    private int ultimo = 0;

    public ListaCandidato() {
        C = new Candidato[tam];
    }

    public void add(Candidato c) throws Exception{
        if (ultimo == C.length) {
            aumentarLista(ultimo + 1);
        }

        C[ultimo] = c;
        ultimo++;
    }


    public void aumentarLista(int novoTam) {
        Candidato[] novoC = new Candidato[novoTam];

        for (int i = 0; i < C.length; i++) {
            novoC[i] = C[i];
        }

        C = novoC;
    }

    public Candidato get(int pos) throws Exception {
        if (pos >= ultimo)
            throw new Exception("Não existe este elemento");
        return C[pos];
    }

    public int tamanho() {
        return ultimo;
    }

    public void remove(int cod) throws Exception {

        int pos = -1;
        for (int i = 0; i < ultimo; i++) {
            if (C[i].getInsc() == cod) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            throw new Exception("A posição não existe");
        }

        for (int i = pos; i < ultimo - 1; i++) {
            C[i] = C[i + 1];
        }
        ultimo--;
    }

    public Candidato getbyCandidato(String nome) throws Exception {
        for (int i = 0; i < C.length; i++) {
            if (C[i].getNome().equals(nome)) {
                return C[i];
            } 
        }
        throw new Exception("Este Candidato não existe");
    }
}
