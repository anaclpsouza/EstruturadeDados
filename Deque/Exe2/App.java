import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Deque<Parcela> deque = new Deque<Parcela>();
        Scanner sc = new Scanner(System.in);
        int nParcelas = 0;
        double valor = 0;

        System.out.print("Valor do financiamento: ");
        try {
            valor = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Digite somente números");
            System.exit(0);
        }
        System.out.print("Em quantas parcelas? ");
        try {
            nParcelas = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Digite apenas números inteiros");
            System.exit(0);
        }
        double valorParcelas = valor / nParcelas;
        for (int i = 1; i <= nParcelas; i++) {
            double juros = ((valorParcelas * 0.01) * i);
            double v = (valorParcelas + juros);
            deque.addLast(new Parcela(v, juros));
        }
        boolean a = true;
        while (a) {
            if (deque.isEmpty()) {
                System.out.println("Todas as parcelas foram pagas.");
                a = false;
                break;
            } else {
                System.out.println("Parcelas:");
                deque.print();
                System.out.println(" ");
            }
            System.out.printf("Ações: \n 1. Pagar parcela atual \n 2. Pagar última parcela \n 3. Sair \n");
            String op = sc.next();
            System.out.println(" ");
            switch (op) {
                case "1":
                    System.out.println("Valor do pagamento: " + deque.removeFirst().getValorParcelas());
                    break;
                case "2":
                    if (deque.size() > 1) {
                        Parcela p = deque.getLast();
                        double parcela = p.getValorParcelas() - p.getJuros();
                        deque.removeLast();
                        System.out.println("Valor do pagamento: " + parcela);
                    } else {
                        System.out.println("Valor do pagamento: " + deque.removeFirst().getValorParcelas());
                    }
                    break;
                case "3":
                    a = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida, nenhuma ação foi realizada.");
                    break;
            }
        }

        sc.close();
    }
}
