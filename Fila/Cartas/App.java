import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Fila fila = new Fila();
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while (n != 0) {
            n = sc.nextInt();
            if (n == 0 || n > 50) {
                break;
            }
            if (n != 1) {
                fila.enfileirarInicio(n);
                int[] saida = new int[n];
                for (int j = 0; j < saida.length; j++) {
                    if (!fila.tamFila()) {
                        saida[j] = fila.desenfileirar();
                        fila.enfileirar(fila.desenfileirar());
                    }
                }

                StringBuilder sb = new StringBuilder();
                sb.append("Discarded cards: ");
                for (int f = 0; f < saida.length - 1; f++) {
                    if (f == saida.length - 2) {
                        sb.append(saida[f]);
                    } else {
                        sb.append(saida[f] + ", ");
                    }
                }
                System.out.println(sb.toString());
                System.out.println("Remaining card: " + fila.desenfileirar());
            } else {
                fila.enfileirar(n);
                System.out.println("Discarded cards: ");
                System.out.println("Remaining card: " + fila.desenfileirar());
            }
        }

        sc.close();
    }
}
