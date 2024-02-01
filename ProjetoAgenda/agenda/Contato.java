import java.util.Scanner;

public class Contato {
    String nome;
    String numero;
    String email;

    //Gets e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //Construtor sem parametro
    Contato () {}
    //Construtor para adinionar o contato
    Contato (String nome, String numero, String email) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }
    //Buscar contato na lista
    void buscarContatoPorNome(Contato[] agenda, Scanner sc) {
        System.out.println("Qual o nome?");
        String escolha = sc.nextLine();

        Contato busca = new Contato();
        String buscar = busca.buscarContato(agenda, escolha);

        if (buscar == null) {
            System.err.println("Contato não encontrado!\n");
        } else {
            System.out.println(buscar);
        }
    }

    //Interage com ao método buscarContatoPorNome
    String buscarContato (Contato [] agenda, String nome) {
        for (Contato contato : agenda) {
            if (contato != null && contato.getNome().contains(nome)) {
                return contato.status();
            } else if (agenda[0] == null) {
                System.err.println("Agenda vazia!\nQue tal escolher outra opção?");
            }
        }
        return null;
    }
    //Adicionar contatos na lista
    String adicionarContato (Contato [] agenda, Contato pessoa) {
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] == null) {
                agenda[i] = pessoa;
                return "Contato adicionado!\n";
            }
        }
        return "A agenda está cheia!";
    }
    //Testa se o contato está com as configurações certas
    String testarNome (Scanner sc) {
        System.out.print("Nome:");
        nome = sc.nextLine();
        boolean testeNome = verificarCaracter(nome);

        while (!testeNome) {
            System.err.println("Hmmm...Parece que o nome possuie números, escreva novamente:");
            nome = sc.nextLine();
            testeNome = verificarCaracter(nome);
        }

        System.out.print("Telefone:");
        numero = sc.nextLine();
        boolean testeNumero = verificarDigito(numero);

        while (!testeNumero) {
            System.err.println("Hmmm...Parece que o numero possuie letras, escreva novamente:");
            numero = sc.nextLine();
            testeNumero = verificarDigito(numero);
        }

        System.out.print("Email:");
        email = sc.nextLine();
        boolean testeEmail = verificarSeTemArroba(email);

        while (!testeEmail) {
            System.err.println("Hmmm...Parece que o email não possuie @, escreva novamente:");
            email = sc.nextLine();
            testeEmail = verificarSeTemArroba(email);
        }
        return nome + numero + email;
    }
    //Verificar se é digito
    boolean verificarDigito (String numero){
        int contagemLetra = 0;
        for (int i = 0; i < numero.length(); i++) {
            char letra = numero.charAt(i);

            if(!Character.isDigit(letra)) {
                contagemLetra ++;
            }
        }
        if (contagemLetra > 0){
            return false;
        }
        return true;
    }
    //Verificar se é caracter
    boolean verificarCaracter (String palavra){
        int contagemDigito = 0;

        for (int i = 0; i < palavra.length(); i++) {
            char letra = palavra.charAt(i);
            if(Character.isDigit(letra)) {
                contagemDigito ++;
            }
        }
        if (contagemDigito > 0){
            return false;
        }
        return true;
    }
    //Verifica se o email tem @
    boolean verificarSeTemArroba(String email) {
        String teste = "@";
        if (email.contains(teste)) {
            return true;
        }
        return false;
    }
    //Mensagens iniciais de interação
    String status () {
        return "\nNome: " + nome + "\nNúmero: " + numero + "\nEmail: " + email + "\n";
    }
    void saudacao () {
        System.out.println("Bem Vindo a Agenda");

    }
    //Escolha para manipulações da lista
    int escolher(Scanner sc) {
        System.out.println("Escolha uma das opções, utilize os números para escolher:");
        System.out.println("[1] Buscar contato.\n[2] Adicionar novo contato.\n[3] Sair");
        int escolha= sc.nextInt();
        sc.nextLine();
        return escolha;
    }
}
