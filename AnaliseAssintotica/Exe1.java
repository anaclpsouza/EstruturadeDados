public class Exe1 {
    public static void main(String[] args) {
        int[] vetorTeste = {1, 56, 4, 8, 20};
        
        int[] vetorMaiorMenor = maiorMenor(vetorTeste);
        System.out.println("Maior: " + vetorMaiorMenor[0]);
        System.out.println("Menor: " + vetorMaiorMenor[1]);
    }

    public static int[] maiorMenor(int[] vetor) {

        int maior = vetor[0];
        int menor = vetor[0];

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            } else if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }

        return new int[]{maior, menor};
        
    }

    // a complexidade é O(n)
}
