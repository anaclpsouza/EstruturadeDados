public class Exe6 {

    public static void main(String[] args) {
        int[] vet1 = { 1, 2, 3, 4, 5 };
        int[] vet2 = { 6, 7, 8, 9, 10 };

        try {
            int[] vet3 = novoVetor(vet1, vet2);
            for (int i = 0; i < vet3.length; i++) {
                System.out.print("[" + vet3[i] + "] ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    public static int[] novoVetor(int[] v1, int[] v2) throws Exception {
        int[] v3 = new int[5];
        int pontV1 = 0;
        int pontV2 = 0;
        int uP = -1;
        
        while (uP != v3.length - 1) {
            int n = (int) (Math.random() * 50);

            if (n % 2 == 0) {
                v3[++uP] = v1[pontV1];
                pontV1++;
            } else {
                v3[++uP] = v2[pontV2];
                pontV2++;
            }
        } 
        return v3;
    }
}
