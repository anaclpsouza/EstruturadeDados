public class Exe2 {
    public static void main(String[] args) {
        int[] vetor = { 12, 4, 7, 9, 25, 3, 15, 30, 20 };
        int[] maiores = tresMaiores(vetor);
        for (int i = 0; i < maiores.length; i++) {
            System.out.println(maiores[i]);

        }

    }

    public static int[] tresMaiores(int[] vetor) {
        int maior = vetor[0];
        int segmaior = vetor[1];
        int termaior = vetor[2];

        for (int i = 3; i < vetor.length; i++) {
            int num = vetor[i];
            if (num > maior) {
                termaior = segmaior;
                segmaior = maior;
                maior = num;
            } else if (num > segmaior) {
                termaior = segmaior;
                segmaior = num;
            } else if (num > termaior) {
                termaior = num;
            }
        }

        return new int[] { maior, segmaior, termaior };
    }

    //complexidade O(n)
}
