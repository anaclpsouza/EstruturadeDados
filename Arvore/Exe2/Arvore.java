import java.util.ArrayList;

public class Arvore {

    Node raiz = null;

    public void inserir(int altura) {
        this.raiz = inserirRec(this.raiz, altura);
    }

    private Node inserirRec(Node no, int altura) {
        if (no == null) {
            return new Node(altura);
        }

        if (altura < no.altura) {
            no.esquerda = inserirRec(no.esquerda, altura);
        } else {
            no.direita = inserirRec(no.direita, altura);
        }
        return no;
    }

    public ArrayList<Integer> maiorNivel(Node no) {
        ArrayList<Integer> mA = new ArrayList<>();
        ArrayList<Node> nivel = new ArrayList<>();
        nivel.add(no);

        while (!nivel.isEmpty()) {
            int menorA = Integer.MAX_VALUE;
            ArrayList<Node> proxNivel = new ArrayList<>();

            for (Node node : nivel) {
                if (node.altura < menorA) {
                    menorA = node.altura;
                }

                if (node.esquerda != null) {
                    proxNivel.add(node.esquerda);
                }

                if (node.direita != null) {
                    proxNivel.add(node.direita);
                }

            }
            mA.add(menorA);
            nivel = proxNivel;
        }
        return mA;
    }
}