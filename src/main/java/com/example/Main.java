package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nombres = { "Yorman Usme", "Memo Pipe", "Juan Memo" };
        double[] saldos = { 1000, 500, 100 };

        int indiceSeleccionado = seleccionarCuenta(nombres);
        System.out.println("Has seleccionado la cuenta: " + nombres[indiceSeleccionado]);

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    depositar(indiceSeleccionado, saldos, nombres);
                    break;
                case 2:
                    retirar(indiceSeleccionado, saldos, nombres);
                    break;
                case 3:
                    consultarSaldo(indiceSeleccionado, saldos, nombres);
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el Banco Simple!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

    }

    public static void mostrarMenu() {

        System.out.println("---------Menu---------");
        System.out.println("1. Depositar");
        System.out.println("2. retirar");
        System.out.println("3. consultar saldo");
        System.out.println("4. salir");
        System.out.println("-----------------------");

    }

    public static int seleccionarCuenta(String[] nombres) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar la lista de nombres con sus índices
        System.out.println("Lista de cuentas bancarias:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(i + ": " + nombres[i]);
        }

        int indice = -1;

        // Solicitar al usuario que ingrese el índice
        while (true) {
            System.out.print("Ingresa el índice de la cuenta que deseas utilizar: ");
            try {
                indice = Integer.parseInt(scanner.nextLine());

                // Validar que el índice esté en el rango correcto
                if (indice >= 0 && indice < nombres.length) {
                    return indice;
                } else {
                    System.out
                            .println("Índice inválido. Por favor, ingresa un índice entre 0 y " + (nombres.length - 1));
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número entero.");
            }
        }
    }

    public static void depositar(int indice, double[] saldos, String[] nombres) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el monto a depositar: ");
        double monto = scanner.nextDouble();

        if (monto > 0) {
            saldos[indice] += monto;
            System.out.println("Has depositado " + monto + " a " + nombres[indice]);
            System.out.println("Nuevo saldo de " + nombres[indice] + ": " + saldos[indice]);
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    public static void retirar(int indice, double[] saldos, String[] nombres) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el monto a retirar: ");
        double monto = scanner.nextDouble();

        if (monto > 0 && monto <= saldos[indice]) {
            saldos[indice] -= monto;
            System.out.println("Has retirado " + monto + " de " + nombres[indice]);
            System.out.println("Nuevo saldo de " + nombres[indice] + ": " + saldos[indice]);
        } else {
            System.out.println("El monto a retirar debe ser positivo y menor o igual al saldo actual.");
        }
    }

    public static void  consultarSaldo(int indice, double[]saldos, String[] nombres) {
        System.out.println("Tu saldo es: "+ saldos[indice]);
    }

}
