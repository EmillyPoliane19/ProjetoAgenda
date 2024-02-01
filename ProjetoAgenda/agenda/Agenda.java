import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System .in);
        Contato apresentacao = new Contato();
        apresentacao.saudacao();

        int opcao = 1;
        Contato[] agenda = new Contato[50];

        while (opcao != 3) {
            Contato escolher = new Contato();
            opcao = escolher.escolher(sc);

            switch (opcao) {
                case 1:
                    escolher.buscarContatoPorNome(agenda, sc);
                    break;

                case 2:
                    Contato verificar = new Contato();
                    String dadoContato = verificar.testarNome(sc);
                    Contato pessoa = new Contato(verificar.getNome(), verificar.getNumero(), verificar.getEmail());
                    String adicionar = pessoa.adicionarContato(agenda, pessoa);
                    System.out.println("\n" + adicionar);

                    break;

                case 3:
                    break;
            }
        }
        sc.close();
    }
}
