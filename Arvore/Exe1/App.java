import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        BSTree bst = new BSTree();
        Random random = new Random();
        int teste = random.nextInt(10) + 1;

        bst.inserir(bst.raiz, new Aluno(1, "João", "BSI"));
        bst.inserir(bst.raiz, new Aluno(2, "Francisco", "ADM"));
        bst.inserir(bst.raiz, new Aluno(3, "Diana", "ADM"));
        bst.inserir(bst.raiz, new Aluno(4, "Leonardo", "ADM"));
        bst.inserir(bst.raiz, new Aluno(5, "Légolas", "BSI"));
        bst.inserir(bst.raiz, new Aluno(6, "Luke", "BSI"));
        bst.inserir(bst.raiz, new Aluno(7, "Léia", "ADM"));
        bst.inserir(bst.raiz, new Aluno(8, "Clove", "BSI"));
        bst.inserir(bst.raiz, new Aluno(9, "Jett", "ADM"));
        bst.inserir(bst.raiz, new Aluno(10, "Raze", "BSI"));

        System.out.println("-- PRIMEIRA SAÍDA -- ");
        bst.imprime_preOrdem(bst.raiz);

        System.out.println("Maior matrícula: " + bst.maiorMat(bst.raiz).aluno.toString());
        System.out.println("A matrícula " + teste + " está cadastrada? ");
        
        if (bst.inArvore(bst.raiz, teste)) {
            System.out.println("Sim.");
        } else {
            System.out.println("Não.");
        }

        bst.remover(1);

        bst.remover(10);

        System.out.println("-- APÓS REMOVER AS MATRÍCULAS 1 E 10 --");
        bst.imprime_preOrdem(bst.raiz);

        System.out.println("Maior matrícula: " + bst.maiorMat(bst.raiz).aluno.toString());
    }
}
