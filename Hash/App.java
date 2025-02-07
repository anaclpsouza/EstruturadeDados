import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        HashTable ht = new HashTable();
        ht.putAberto(new Livro("978-0-7334-2609-4","A volta","Lobão",1200));
        ht.putAberto(new Livro("378-0-7334-2609-4","A ida","Lobão",1200));
        ht.putAberto(new Livro("978-0-7234-2609-4","Não volto","Lobão",1200));
        ht.putAberto(new Livro("178-0-7234-2609-4","Sentirei saudades","Lobão",1200));
        ht.putAberto(new Livro("278-0-7234-2609-4","Voltei","Lobão",1200));
        ht.putAberto(new Livro("478-0-7234-2609-4","Democracia","Lobão",1200));
        ht.putAberto(new Livro("578-0-7234-2609-4","O grito","Lobão",1200));
        ht.putAberto(new Livro("678-0-7234-2609-4","O silêncio","Lobão",1200));
        ht.putAberto(new Livro("778-0-7234-2609-4","Gelo derretendo","Lobão",1200));
        ht.putAberto(new Livro("878-0-7234-2609-4","O crime","Lobão",1200));
        ht.putAberto(new Livro("918-0-7234-2609-4","O julgamento","Lobão",1200));
        ht.putAberto(new Livro("928-0-7234-2609-4","A vingança","Lobão",1200));
        ht.putAberto(new Livro("938-0-7234-2609-4","Retaliação","Lobão",1200));
        /* ht.status(); */
        // Acessando um livro qualquer
        System.out.println("Informe o ISBN do livro que deseja acessar");
        String key = in.nextLine();
        Livro x = ht.get(key);
        if (x!=null)
            System.out.println("Título do livro: " + x.getTitulo());
        else 
            System.out.println("Livro não encontrado");

        System.out.println("Informe o ISBN do livro que deseja remover");
        key = in.nextLine();
        x = ht.remove(key);
        if (x!=null)
            System.out.println("O livro "+x.getTitulo() + " foi removido");
        else
            System.out.println("Livro não encontrado.");
       /*  ht.status(); */

        in.close();
    }
}
