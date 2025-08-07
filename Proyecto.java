package algoritmos;

import java.util.Scanner;
public class Proyecto {
public static void main(String[] args) {
        Scanner captura = new Scanner(System.in);
        
        int pinCorrecto = 1234, pinIngresado;
        double saldo = 100000;
        int intentos = 3;

        // Validación del PIN con solo 3 intentos
        do {
            System.out.print("Ingrese su PIN: ");
            while (captura.hasNextDouble()!=true) {
                System.out.println("PIN inválido. Ingrese solo números.");
                captura.next();
            }
            pinIngresado = captura.nextInt();

            if (pinIngresado != pinCorrecto) {
                intentos--;
                System.out.println("PIN incorrecto. Intentos restantes: " + intentos);
                
                if (intentos == 0) {
                    System.out.println("Tarjeta bloqueada. Espere unos minutos antes de intentarlo nuevamente.");
                    return;
                }
            }
        } while (pinIngresado != pinCorrecto);

        int opcion; // Menú de opciones del cajero
        do {
            System.out.println("=== CAJERO AUTOMÁTICO ===");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            while (captura.hasNextDouble()!=true) {
                System.out.println("Ingrese un número válido.");
                captura.next();
            }
            opcion = captura.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Su saldo actual es: $" + saldo);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    while (!captura.hasNextDouble()) {
                        System.out.println("Ingrese un monto válido.");
                        captura.next();
                    }
                    double deposito = captura.nextDouble();

                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    } else {
                        System.out.println("El monto debe ser positivo.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    while (!captura.hasNextDouble()) {
                        System.out.println("Ingrese un monto válido.");
                        captura.next();
                    }
                    double retiro = captura.nextDouble();

                    if (retiro > 0 && retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    } else if (retiro > saldo) {
                        System.out.println("Fondos insuficientes.");
                    }
                    break;
                case 4:
                    System.out.println("Gracias por usar el cajero. Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);
    }
}