import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    static int P = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        Fila oeste = new Fila();
        Fila leste = new Fila();
        Fila sul = new Fila();
        Fila norte = new Fila();
        while (true) {
            if (P == Integer.MIN_VALUE) {
                P = sc.nextInt();
                sc.nextLine();
            }
            if (P == 0)
                break;
            switch (P) {
                case -1:
                    adicionar(oeste);
                    break;
                case -2:
                    adicionar(sul);
                    break;
                case -3:
                    adicionar(norte);
                    break;
                case -4:
                    adicionar(leste);
                    break;
                default:
                    break;
            }
        }

        Fila saida = new Fila();
        organizarAvioes(oeste, leste, sul, norte, saida);

        if (saida.isEmpty()) {
            System.out.println();
        }
        while (!saida.isEmpty()) {
            System.out.print(saida.desenfileirar() + " ");
        }
    }

    public static void adicionar(Fila f) {
        while (true) {
            String aviao = sc.nextLine();
            try {
                P = Integer.parseInt(aviao); 
                return;
            } catch (NumberFormatException e) {
                f.enfileirar(aviao);
            }
        }
        
    }

    public static void organizarAvioes(Fila oeste, Fila leste, Fila sul, Fila norte, Fila novaFila) {
     
        while (!oeste.isEmpty() || !leste.isEmpty() || !sul.isEmpty() || !norte.isEmpty()) {
          try {
              if (!oeste.isEmpty()) {
                  novaFila.enfileirar(oeste.desenfileirar());
              }
              if (!norte.isEmpty()) {
                  novaFila.enfileirar(norte.desenfileirar());
              }
              if (!sul.isEmpty()) {
                  novaFila.enfileirar(sul.desenfileirar());
              }
              if (!leste.isEmpty()) {
                  novaFila.enfileirar(leste.desenfileirar());
              }
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
        }
    }
}
