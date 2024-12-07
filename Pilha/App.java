import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean sairBloco = false;
        Pilha saida = new Pilha();
        Pilha saidaEsperada = new Pilha();
        int num = -1;
        int vagoes;

        while (!sairBloco) {
            System.out.print("Quantidade de vagões: ");
            int a = sc.nextInt();

            if (a == 0) {
                sairBloco = true;
                break;
            }

            vagoes = a;
            Pilha pilhaBase = new Pilha();
            
            // aqui eu crio a pilha da entrada em ordem crescente
            for (int i = a; i > 0; i--) {
                pilhaBase.push(new Vagao(i));
            }


            boolean continuar = true;
            while (continuar) {
                for (int i = 0; i < vagoes; i++) {
                    num = sc.nextInt();

                    if (num == 0) {
                        continuar = false;
                        break;
                    }
                    
                    saida.push(new Vagao(num));
                }
                
                if (num == 0) {
                    break;
                }

                // organizo a pilha
                for (int j = 0; j < vagoes; j++) {
                    saidaEsperada.push(saida.pop());
                }

                if (pilhaBase.ePossivel(saidaEsperada)) {
                    System.out.println("Sim");
                } else {
                    System.out.println("Não");
                }
            }

        }
        sc.close();
    }

}
