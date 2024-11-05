import java.util.Scanner;

public class Exe3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vet = { 0, 2, 6, 7, 15, 19, 20 };
        System.out.print("Qual número vc quer saber se tem no vetor? ");
        try {
            int i = sc.nextInt();
            if (existe(vet, i)) {
                System.out.println("O número " + i + " existe no vetor.");
            } else {
                System.out.println("O número " + i + " não existe no vetor.");
            }
        } catch (Exception e) {
            System.out.println("Digite um número");
        }

        sc.close();
    }

    public static boolean existe(int[] vetor, int x) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) { 
            int meio = inicio + (fim - inicio) / 2; 
            if (vetor[meio] == x) {
                return true;
            }

            if (vetor[meio] < x) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return false;
    }
}
