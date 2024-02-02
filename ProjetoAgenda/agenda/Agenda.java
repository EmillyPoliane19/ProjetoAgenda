import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System .in);
        Contato apresentacao = new Contato();
        apresentacao.saudacao();

        int opcao = 1;
        Contato[] agenda = new Contato[50];

        while (opcao != 5) {
            Contato escolher = new Contato();
            opcao = escolher.escolher(sc);

            switch (opcao) {
                case 1:
                    escolher.buscarContatoPorNome(agenda, sc);
                    break;

                case 2:
                    escolher.buscarNomePorLetra(agenda, sc);
                    break;

                case 3:
                    String dadoContato = escolher.testarNome(sc);
                    Contato pessoa = new Contato(escolher.getNome(), escolher.getNumero(), escolher.getEmail());
                    String adicionar = pessoa.adicionarContato(agenda, pessoa);
                    System.out.println(adicionar);
                    break;

                case 4:
                    escolher.listaDeContatos(agenda);
                    break;

                case 5:
                    System.out.print("Obrigado por utilizar!");
                    break;
            }
        }
        sc.close();
    }
}
