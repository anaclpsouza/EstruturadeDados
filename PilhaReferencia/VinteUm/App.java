import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        PilhaReferencia j1 = new PilhaReferencia();
        PilhaReferencia j2 = new PilhaReferencia();
        int Pj1 = 0;
        int Pj2 = 0;
        int op = 1;
        Random rn = new Random();

        System.out.println("--- JOGADOR 1 ---");
        while (op != 0) {
            int a = rn.nextInt(10) + 1;
            Pj1 += a;
            j1.push(new Carta(a));
            if (Pj1 > 21) {
                System.out.println("Pontuação: " + Pj1 + " ultrapassou 21.");
                Pj1 -= j1.pop().num; 
                Pj1 = Pj1 - 5;
                System.out.println("Pontuação atual (com penalidade): " + Pj1);
                op = 0;
                break;
            }
            System.out.println("Pontuação atual: " + Pj1);
            System.out.print("Deseja mais uma carta? ");
            System.out.println("1. Sim | 0. Não");
            op = sc.nextInt();
        }
        op = 1;
        System.out.println(" \n \n \n \n \n \n \n \n --- JOGADOR 2 ---");
        while (op != 0) {
            int a = rn.nextInt(10) + 1;
            Pj2 += a;
            j2.push(new Carta(a));
            if (Pj2 > 21) {
                j2.pop();
                System.out.println("Pontuação: " + Pj2 + " ultrapassou 21.");
                Pj2 -= j2.pop().num; 
                Pj2 = Pj2 - 5;
                System.out.println("Pontuação atual (com penalidade): " + Pj2);
                op = 0;
                break;
            }
            System.out.println("Pontuação atual: " + Pj2);
            System.out.print("Deseja mais uma carta? ");
            System.out.println("1. Sim | 0. Não");
            op = sc.nextInt();
        }

        if (Pj1 <= 21 && (Pj1 > Pj2 || Pj2 > 21)) {
            System.out.print(" \n Jogador 1 venceu. Cartas: ");
            while (!j1.isVazia()) {
                System.out.print(j1.pop().num + " ");
            }
        } else if (Pj2 <= 21 && (Pj2 > Pj1 || Pj1 > 21)) {
            System.out.print(" \n Jogador 2 venceu. Cartas: ");
            while (!j2.isVazia()) {
                System.out.print(j2.pop().num + " ");
            }
        } else {
            System.out.println(" \n Empate.");
        }
        

        sc.close();

    }
}
