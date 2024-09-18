package br.com.alura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
    }

    private static void menu(Scanner scanner) {
        while (true) {
            System.out.println("""
                    -------------------------------------------
                    OPÇÕES DISPONÍVEIS
                    
                    0 - Encerrar aplicação
                    1 - Valor especifico da tabuada completa
                    2 - Tabuada completa
                    -------------------------------------------
                    """);

            int action = 0;
            try {
                action = scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException ex) {
                System.out.println("Informe valores inteiros - " + ex.getMessage());
                scanner.nextLine();
                continue;
            }
            switch (action) {
                case 0 :
                    System.out.println("Encerrando aplicação...");
                    break;
                case 1 :
                    tabuadaUnica(scanner);
                    break;
                case 2 :
                    tabuadaCompleta();
                    break;
                default:
                    System.out.println("Informação inválida!");
            }
            if (action == 0) {
                break;
            }
        }
    }

    private static void tabuadaCompleta() {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.printf("%2d x %2d = %3d   |  ", i, j, i * j);
            }
            System.out.println();
        }
    }

    private static void tabuadaUnica(Scanner scanner) {
        while (true) {
            System.out.println("Informe o número que você deseja da tabuada que seja imprimido: ");
            int number = 0;
            try {
                number = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println("Informe valores inteiros - " + ex.getMessage());
                scanner.nextLine();
            }
            System.out.printf("""
                    --------------------------------------------------------
                    TABUADA DO %d
                    
                    """, number);
            for (int i = 0; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + number * i);
            }
            System.out.println("--------------------------------------------------------");
            System.out.println("Deseja continuar ? (s/n)");
            String resp = scanner.nextLine().trim().toUpperCase();
            if(resp.equals("N")) {
                System.out.println("Saindo....");
               break;
            }else if(!resp.equals("S")) {
                System.out.println("Informe apenas as letras 'S' para continuar e 'N' para sair");
            }
        }
    }
}