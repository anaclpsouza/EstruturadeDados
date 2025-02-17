import java.util.ArrayList;

public class HashTable {
    public static final int TAM = 17;
    ArrayList<Time>[] tabela;

    public HashTable() {
        tabela = (ArrayList<Time>[]) new ArrayList[TAM];
    }

    private int hash(String chave) {
        int h = 0;
        for (int i = 0; i < chave.length(); i++) {
            h = (31 * h + chave.charAt(i)) % TAM;
        }
        return h;
    }

    public Time get(String chave) {
        int hash = hash(chave);
        ArrayList<Time> times = tabela[hash];
        if (times == null) {
            return null;
        }
        for (Time time : times) {
            if (time.getCodigo().equals(chave)) {
                return time;
            }
        }
        return null;
    }

    public String put(Time t) {
        int hash = hash(t.getCodigo());
        ArrayList<Time> times = tabela[hash];
        if (times == null) {
            times = new ArrayList<Time>();
            tabela[hash] = times;
        }
        
        for (Time time : times) {
            if (time.getCodigo().equals(t.getCodigo())) {
                return "Um time com este código já foi adicionado antes.";
            }
        }

        times.add(t);
        return "Time adicionado!";

    }

    public Time remove(String chave) {
        int hash = hash(chave);
        ArrayList<Time> times = tabela[hash];
        if (times == null) {
            return null;
        }
        for (int i = 0; i < times.size(); i++) {
            if (times.get(i).getCodigo().equals(chave)) {
                return times.remove(i);
            }
        }
        return null;
    }
}
