import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Arvore bst = new Arvore();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            bst.inserir(sc.nextInt());
        }

        ArrayList<Integer> saida = bst.maiorNivel(bst.raiz);

        for (int i = 0; i < saida.size(); i++) {
            System.out.println(i + " " + saida.get(i));
        }

        sc.close();
    }
}
