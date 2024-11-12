import java.util.Scanner;

public class Exe4 {
    public static int[] vet = new int[10];
    public static int uP = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        boolean a = true;
        do {
            System.out.println("1. Cadastrar número.");
            System.out.println("2. Excluir número.");
            System.out.println("3. Ver vetor.");
            System.out.println("0. Sair.");
            try {
                op = sc.nextInt();

                switch (op) {
                    case 1:
                        telaCad(vet, sc);
                        break;
                    case 2:
                        telaEx(vet, sc);
                        break;
                    case 3:
                        exibeVet(vet);
                        break;
                    case 0:
                        a = false;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Digite apenas números");
                System.exit(0);
            }
        } while (a);

        sc.close();
    }

    public static void telaCad(int[] vet, Scanner sc) {
        int n;
        int op;
        System.out.print("Digite o número a ser cadastrado: ");
        try {
            n = sc.nextInt();
            System.out.println("1. Cadastrar no início.");
            System.out.println("2. Cadastrar no fim.");
            System.out.println("3. Cadastrar no meio.");

            try {
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        inserirInicio(n, vet);
                        break;
                    case 2:
                        inserirFim(n, vet);
                        break;
                    case 3:
                        inserirMeio(n, vet, sc);
                        break;
                    default:
                        System.out.println("Insira uma opção válida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Digite apenas números");
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println("Digite apenas números");
            System.exit(0);
        }
    }

    public static void telaEx(int[] vet, Scanner sc) {
        int op;
        System.out.println("1. Excluir no início.");
        System.out.println("2. Excluir no fim.");
        System.out.println("3. Excluir no meio.");
        try {
            op = sc.nextInt();
            switch (op) {
                case 1:
                    excluirInicio(vet);
                    break;

                case 2:
                    excluirFim(vet);
                    break;
                case 3:
                    excluirMeio(vet, sc);
                    break;
                default:
                    System.out.println("Insira uma opção válida.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Digite apenas números");
            System.exit(0);
        }

    }

    public static void exibeVet(int[] vet) {
        System.out.print("Vetor: ");
        for (int i = 0; i < uP + 1; i++) {
            System.out.print("[" + vet[i] + "] ");
        }
        System.out.println("");
    }

    public static void inserirFim(int n, int[] vetor) {
        if (uP == vetor.length - 1) {
            System.out.print("O vetor está cheio. 10/10.");
        } else {
            vetor[++uP] = n;
        }
    }

    public static void inserirInicio(int n, int[] vetor) {
        if (uP == vetor.length - 1) {
            System.out.println("O vetor está cheio. 10/10.");
        } else {
            for (int i = uP + 1; i > 0; --i) {
                vetor[i] = vetor[i - 1];
            }
            vetor[0] = n;
            uP++;
        }
    }

    public static void inserirMeio(int n, int[] vetor, Scanner sc) {
        exibeVet(vetor);
        System.out.print("Escolha uma posição (de 0 a " + (uP + 1) + "): ");
        try {
            int p = sc.nextInt();
            if (p > uP) {
                inserirFim(n, vetor);
            } else {
                for (int i = uP + 1; i > p; --i) {
                    vetor[i] = vetor[i - 1];
                }
                vetor[p] = n;
                uP++;
            }
        } catch (Exception e) {
            System.out.println("Digite apenas números.");
            System.exit(0);
        }
    }

    public static void excluirFim(int[] vetor) {
        if (uP == -1) {
            System.out.println("O vetor está vazio");
        } else {
            --uP;
        }
    }

    public static void excluirInicio(int[] vetor) {
        if (uP == -1) {
            System.out.println("O vetor está vazio");
        } else {
            for (int i = 0; i < uP; i++) {
                vetor[i] = vetor[i + 1];
            }
            --uP;
        }
    }

    public static void excluirMeio(int[] vetor, Scanner sc) {
        if (uP == -1) {
            System.out.println("O vetor está vazio");
        } else {
            exibeVet(vetor);
            System.out.print("Escolha uma posição (de 0 a " + (uP + 1) + "): ");
            try {
                int p = sc.nextInt();
                if (p > uP) {
                    System.out.println("Posição não está em uso.");
                } else {
                    for (int i = p; i < uP; i++) {
                        vetor[i] = vetor[i + 1];
                    }
                    --uP;
                }
            } catch (Exception e) {
                System.out.println("Digite apenas números.");
                System.exit(0);
            }
        }
    }

}
