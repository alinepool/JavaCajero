package org.generetion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import org.generetion.Cuenta;

public class Cajero {

	public static void main(String[] args) {
		try {
			Scanner leer = new Scanner(System.in);
			int menu = 0;
			int invalidAttempts = 0;
			System.out.println("CAJERO AUTOÁTICO");// Imprime bienvenida al cajero
			System.out.println("Bienvenido");

			// Crear instancia
			Cuenta cuenta = new Cuenta("Titular de la cuenta", 10000);
			do {
				System.out.println("Selecciona una opcion");
				System.out.println("	1. RETIRAR EFECTIVO");
				System.out.println("	2. DEPOSITAR EFECTIVO");
				System.out.println("	3. CONSULTA SALDO");
				System.out.println("	4. QUEJAS");
				System.out.println("	5. ULTIMOS MOVIMIENTOS");
				System.out.println("	9. SALIR");
				menu = leer.nextInt();

				if (menu < 1 || menu > 5) {
					invalidAttempts++;
					if (invalidAttempts >= 3) {
						System.out.println("Has ingresado 3 valores invalidos, Hasta pronto");
						break;
					}
				} else {
					invalidAttempts = 0;
				}

				switch (menu) {

				case 1:
					System.out.println("Retirar Efectivo \nIngresa el monto a retirar \nPuedes retirar hasta $6000");
					System.out.println("Saldo disponible para retirar: $" + cuenta.checkBalance());
					System.out.println("\nNuestro cajero solo permite \nretiros con billetes de $50");
					float withdrawAmount = leer.nextFloat();
					cuenta.withdraw(withdrawAmount);
					break;
				case 2:
					System.out.println("Depositar Efectivo");

					cuenta.deposit();
					break;
				case 3:
					cuenta.checkBalance();
					break;
				case 4:
					cuenta.complaint();
					break;
				case 5:
					cuenta.bankingTransactions();
					break;
				case 9:
					System.out.println("\n Gracias por usar el cajero");
					break;
				default:
					System.out.println("Error, selecciona una opción valida");
				}
				System.out.println("");

			} while (menu != 9);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
