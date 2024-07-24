import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

//        Faça um programa que permita cadastrar nomes e sobrenome e números de telefones
//        - O programa não deve armazenar nomes repetidos e nem numeros repetidos
//        - o programa não pode aceitar numeros de telefone sem o dd
//
//        Melhoria do programa, faça com que seja possivel buscar o numero de telefone a partir do nome completo da
//        pessoa, desconsiderando as letras maiúsculas

public class exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        List<String> nomes = new ArrayList<>();
        List<String> sobrenomes = new ArrayList<>();
        List<String> telefones = new ArrayList<>();
        int opcao = 0;
        char confirma = 'N';

        do{
            System.out.println("Lista Telefonica");
            System.out.println("=================");
            System.out.println("1 - Cadastrar novo contato");
            System.out.println("2 - Exibir contatos");
            System.out.println("3 - Pesquisar por um contato");
            System.out.println("9 - Sair");
            opcao = input.nextInt();

            switch(opcao){
                case 1:
                    while (true) {
                        // Listar nome
                        System.out.println("Nome:");
                        String nome = scanner.nextLine();

                        // Listar sobrenome
                        System.out.println("Sobrenome:");
                        String sobrenome = scanner.nextLine();

                        boolean existe = false;
                        for (int i = 0; i < nomes.size(); i++) {
                            if (nomes.get(i).equalsIgnoreCase(nome) && sobrenomes.get(i).equalsIgnoreCase(sobrenome)) {
                                System.out.println("O nome e sobrenome já existem na lista. Tente novamente.");
                                existe = true;
                                break;
                            }
                        }

                        if (!existe) {
                            nomes.add(nome);
                            sobrenomes.add(sobrenome);

                            // Listar número de telefone
                            String telefone;
                            while (true) { // Loop até obter um número de telefone válido
                                System.out.println("Telefone com DDD (11 dígitos):");
                                telefone = scanner.nextLine();

                                // Verificar se o telefone tem 11 dígitos e contém apenas números
                                if (telefone.length() != 11 || !telefone.matches("\\d+")) {
                                    System.out.println("O telefone deve ter exatamente 11 dígitos e conter apenas números.");
                                } else if (telefones.contains(telefone)) {
                                    System.out.println("O telefone já existe na lista.");
                                } else {
                                    telefones.add(telefone);
                                    break; // Sair do loop do telefone
                                }
                            }
                            break; // Sair do loop do nome e sobrenome
                        }
                    }
                    break;

                case 2:
                    System.out.println("Lista:");
                    for (int i = 0; i < nomes.size(); i++) {
                        System.out.println(nomes.get(i) + " " + sobrenomes.get(i) + ": " + telefones.get(i));
                    }
                    break;

                case 3:

                    System.out.println("Nome:");
                    String pesquisa_nome = scanner.nextLine().toLowerCase();

                    System.out.println("Sobrenome:");
                    String pesquisa_sobrenome = scanner.nextLine().toLowerCase();

                    boolean encontrado = false;
                    for (int i = 0; i < nomes.size(); i++) {
                        if (nomes.get(i).toLowerCase().equals(pesquisa_nome) && sobrenomes.get(i).toLowerCase().equals(pesquisa_sobrenome)) {
                            System.out.println("Numeros encontrados: ");
                            System.out.println(nomes.get(i) + " " + sobrenomes.get(i) + ": " + telefones.get(i));
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Nome não encontrado");
                    }


                case 9:
                    System.out.println("Tem certeza que deseja sair?");
                    confirma = input.next().toUpperCase().charAt(0);
            }
        } while(confirma != 'S');
        scanner.close();
    }
}