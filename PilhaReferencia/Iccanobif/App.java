import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Random rn = new Random();
        int f = rn.nextInt(10) + 1;
        PilhaReferencia pilha = new PilhaReferencia();

        for (int i = 1; i <= f; i++) {
            pilha.push(new Num(fibo(i)));
        }

        while (!pilha.isVazia()) {
            System.out.print(pilha.pop().num + " ");
        }
    }

    public static long fibo(int f) throws Exception {
        if (f == 0) {
            return 0;
        } else if (f == 1) {
            return 1;
        }
        long a = 0, b = 1, resultado = 0;
        for (int i = 2; i <= f; i++) {
            resultado = a + b;
            a = b;
            b = resultado;
        }
        return resultado;
    }
}
