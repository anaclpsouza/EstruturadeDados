package OpVetores;

public class Exe1 {
    public static void main(String[] args) {
        int[] vet = new int[10];
        System.out.println("Vetor inicial:");
        for (int i = 0; i < vet.length; i++) {
            vet[i] = (int) (Math.random() * 50);
            System.out.print("[" + vet[i] + "] ");
        }

        System.out.println("\nVetor sem os pares:");
        int tam = removerPares(vet);
        for (int i = 0; i < tam; i++) {
            System.out.print("[" + vet[i] + "] ");
        }

    }

    public static int removerPares(int[] vet) {
        int p = 0;
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] % 2 == 1) {
              vet[p] = vet[i]; 
              p++;
            }
        }
        return p;
    }
}
