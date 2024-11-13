package OpVetores;

public class Exe2 {
    public static int uP = -1;
    public static int[] vet = new int[100];
    public static void main(String[] args) {
        int a = 0;
       
        while (a < 100) {
            int num = (int) (Math.random() * 100);
            int op = (int) (Math.random() * 3) + 1;
            if (op == 1) {
                insereInicio(vet, num);
            } else if (op == 2) {
                insereUltimo(vet, num);
            } else if (op == 3) {
                inserePen(vet, num);
            }
            a++;
        }
        
        for (int i = 0; i <= uP; i++) {
            System.out.print("[" + vet[i] + "] ");
        }
      
    }

    public static void insereInicio(int[] vet, int num) {
        if (uP == -1) {
            vet[0] = num;
            uP = 0;
        } else {
            for (int i = uP + 1; i > 0; i--) {
                vet[i] = vet[i - 1];
            }
            vet[0] = num;
            uP++;
        }
    }

    public static void insereUltimo(int[] vet, int num) {
        if (uP == vet.length - 1) {
            System.out.print("O vetor está cheio.");
        } else {
            vet[++uP] = num;
        }
    }

    public static void inserePen(int[] vet, int num) {
        if (uP == -1) {
            insereUltimo(vet, num);
        } else {
            for (int i = uP + 1; i > uP; i--) {
                vet[i] = vet[i - 1];
            }
            vet[uP] = num;
            uP++;
        }
    }
}
