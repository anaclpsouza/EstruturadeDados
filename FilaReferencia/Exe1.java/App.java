import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String op = "1";
        Scanner sc = new Scanner(System.in);
        Fila q = new Fila();
        Fila A = new Fila();
        Fila B = new Fila();
        while (!op.equals("0")) {
            System.out.println("Digite a operação: \n A. (adicionar a fila a) \n B. (adicionar a fila b) \n X. (adicionar onde tiver menos elementos) \n 0. Terminar");
            op = sc.nextLine();
            if (op.equals("0")) {
                break;
            }
            q.enfileirar(op);
            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();
            q.enfileirar(nome);
        }

        while (!q.isEmpty()) {
            String opp = q.desenfileirar();

            switch (opp.toUpperCase()) {
                case "A":
                    A.enfileirar(q.desenfileirar());
                    break;
                case "B":
                    B.enfileirar(q.desenfileirar());
                    break;
                case "X":
                    if (A.qtdE() < B.qtdE()) {
                        A.enfileirar(q.desenfileirar());
                    } else if (A.qtdE() > B.qtdE()) {
                        B.enfileirar(q.desenfileirar());
                    } else {
                        q.desenfileirar();
                    }
                    break;
                default:
                    break;
            }
        }
        
        System.out.println("-----------------");
        System.out.println("Fila A");
        while(!A.isEmpty()){
            System.out.println( A.desenfileirar());
        }
        System.out.println("-----------------");
        System.out.println("Fila B");
        while(!B.isEmpty()){
            System.out.println( B.desenfileirar());
        }
      
        
        sc.close();
    }
}
