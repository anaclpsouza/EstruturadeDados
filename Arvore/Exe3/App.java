import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Arvore bst = new Arvore();

        while (true) {
            bst.limparArvore();
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {

                String anoTemp = sc.nextLine();
                String anoT[] = anoTemp.split(" ");
                bst.inserir(Integer.parseInt(anoT[0]), Double.parseDouble(anoT[1]));
            }

            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int ano = sc.nextInt();
                if (ano == bst.maiorAno().ano) {
                    System.out.println("Correto");
                } else {
                    System.out.println("Incorreto");
                }
            }
        }

        sc.close();
    }
}
