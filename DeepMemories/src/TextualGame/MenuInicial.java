package TextualGame;

import java.util.Scanner;

public class MenuInicial {

    private static final String LINHA = "=-".repeat(40);
    private static final String RECUO = " ".repeat(32);

    public static boolean exibir(Scanner sc) {
        while (true) {
            desenharTitulo();

            System.out.println(RECUO + "1. Jogar");
            System.out.println(RECUO + "2. Criadores");
            System.out.println(RECUO + "3. Sobre");
            System.out.println(RECUO + "0. Sair");
            System.out.println();
            System.out.println(LINHA);
            System.out.print("Escolha uma opção: ");

            String entrada = sc.nextLine().trim();

            switch (entrada) {
                case "1":
                    System.out.println();
                    return true;
                case "2":
                    mostrarCriadores(sc);
                    break;
                case "3":
                    mostrarSobre(sc);
                    break;
                case "0":
                    System.out.println("\nAté a próxima!");
                    return false;
                default:
                    System.out.println("Escolha 1, 2, 3 ou 0.");
            }
        }
    }

    private static void desenharTitulo() {
        System.out.println();
        System.out.println(LINHA);
        System.out.println();
        System.out.println(centralizar("D E E P   M E M O R I E S"));
        System.out.println();
        System.out.println(LINHA);
        System.out.println();
    }

    private static void mostrarCriadores(Scanner sc) {
        String[] criadores = {
                "Vitor Diniz Vasconcelos",
                "João Pedro Silva Leite",
                "Matheus de Oliveira Quaresma",
                "Danilo Soares da Silva",
                "Gabriel Reimberg Bezerra",
                "Paulo Henrique Pereira Rosa"
        };

        System.out.println();
        System.out.println(LINHA);
        System.out.println(centralizar("C R I A D O R E S"));
        System.out.println(LINHA);
        System.out.println();

        for (String nome : criadores) {
            System.out.println(centralizar(nome));
        }

        voltar(sc);
    }

    private static void mostrarSobre(Scanner sc) {
        String[] linhas = {
                "Deep Memories é um RPG de texto no estilo Dungeon.",
                "",
                "A história acompanha Sophie, uma personagem que carrega traumas",
                "psicológicos e acaba caindo em uma fonte mágica.",
                "",
                "A partir dali, ela passa por diversos andares e desafios para",
                "poder encarar seus medos. A cada andar, ela se aprofunda mais",
                "na masmorra."
        };

        System.out.println();
        System.out.println(LINHA);
        System.out.println(centralizar("S O B R E"));
        System.out.println(LINHA);
        System.out.println();

        for (String linha : linhas) {
            System.out.println(centralizar(linha));
        }

        voltar(sc);
    }

    private static void voltar(Scanner sc) {
        System.out.println();
        System.out.println(LINHA);
        System.out.println("(pressione ENTER para voltar ao menu)");
        sc.nextLine();
    }

    private static String centralizar(String texto) {
        int espacos = (80 - texto.length()) / 2;
        return " ".repeat(Math.max(0, espacos)) + texto;
    }
}