public class Exe5 {

    public static void main(String[] args) {
        int[] vet = { 7, 6, 2, 4, 1, 0, 3 };
        
        System.out.println("Vetor desordenado: ");
        for (int i = 0; i < vet.length; i++) {
            System.out.print("[" + vet[i] + "] ");
        }
        
        System.out.println("\nVetor impresso em ordem: ");
        imprimeOrdem(vet);
    }

    public static void imprimeOrdem(int[] vet) {
        boolean[] impresso = new boolean[vet.length];

        for (int i = 0; i < vet.length; i++) {
            int menor = Integer.MAX_VALUE;
            int indice = -1;
            for (int j = 0; j < impresso.length; j++) {
                if (!impresso[j] && menor > vet[j]) {
                    menor = vet[j];
                    indice = j;
                }  
            }

            impresso[indice] = true;

            System.out.print("[" + menor + "] ");
        }
    }
}
