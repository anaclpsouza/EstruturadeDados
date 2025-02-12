import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashTable tabela = new HashTable();
        boolean a = true;                   
        while (a) {
            System.out.println("Opções: \n 1.Cadastro \n 2.Consulta \n 3.Sair");
            String op = sc.next();
            switch (op) {
                case "1":
                    System.out.print("Código do Time: ");
                    String cod = sc.next();
                    System.out.print("Nome do Time: ");
                    String nome = sc.next();
                    System.out.print("Ano de fundação: ");
                    int ano = 0;
                    try {
                        ano = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar. Informe apenas números para o ano.");
                        break;
                    }
                    System.out.print("Presidente: ");
                    String pres = sc.next();
                    System.out.print("Técnico: ");
                    String tec = sc.next();
                    System.out.println(tabela.put(new Time(cod, nome, ano, pres, tec)));
                    break;
                case "2":
                    System.out.print("Informe o código do time que deseja consultar: ");
                    String codC = sc.next();
                    Time time = tabela.get(codC);
                    if (time == null) {
                        System.out.println("Time não encontrado.");
                    } else {
                        System.out.println(time.toString());
                    }
                    break;
                case "3":
                    a = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        sc.close();
    }
}
      
