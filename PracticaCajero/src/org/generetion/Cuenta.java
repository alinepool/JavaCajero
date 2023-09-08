package org.generetion;

import java.util.ArrayList;
import java.util.Scanner;

public class Cuenta {
	private String accountHolder;
	private double balance;
	private ArrayList<Movements> lastMovements = new ArrayList<>();
	private String answer;
	private String accountType;
	private double chequesBalance;
	private Scanner leer = new Scanner(System.in);

	public Cuenta(String accountHolder, double balance) {
		this.accountHolder = accountHolder;
		this.balance = balance;
	}

	public void withdraw(double amount) {

		if (amount <= 0 || amount > 6000) {
			System.out.println("\nMonto inválido, \nel monto puede ser desde 0 hasta 6000");
		} else if (amount > balance) {
			System.out.println("\nMonto inválido, monto mayor al disponible");
		} else if (amount % 50 != 0) {
			System.out.println("\nSolo se permiten retiros de multiplos de $50.00");
		} else {
			System.out.println("¿Deasea donar $200 para la graduacón de CH30? \n (Sí/No)");
			String answer = leer.next().toLowerCase();
			if (answer.equals("si")) {
				if (balance >= (amount + 200)) {
					balance -= (amount + 200);
					lastMovements.add(new Movements("Donación", 200));
					System.out.println("Gracias por tu donación, Se han retirado $200.");
				} else {
					System.out.println("No cuentas con el saldo suficiente para donar");
				}

			} else if (answer.equals("no")) {
				balance -= amount;
				lastMovements.add(new Movements("Retiro", amount));
				System.out.println("Donacion rechazada, se procede al retiro");
				System.out.println("\nOperación Exitosa");
			} else {
				System.out.println("Respuesta inválida. Se realizará el retiro.");
				balance -= amount;
				lastMovements.add(new Movements("Retiro", amount));
				System.out.println("\nOperación Exitosa");
			}

		}

	}

	public void deposit() {
		Scanner leer = new Scanner(System.in);
		System.out.println("Selecciona el tipo de cuenta para el deposito");
		System.out.println("1. Cuenta de Cheques");
		System.out.println("2. Tarjeta de credito");
		int choice = leer.nextInt();

		if (choice == 1) {
			System.out.println("Ingresa el monto a depositar en la Cuenta de Cheques");
			double depositAmount = leer.nextDouble();

			if (depositAmount % 50 != 0) {
				System.out.println("Cantidad invalida, solo multiplos de 50");

			} else {
				balance += depositAmount;
				lastMovements.add(new Movements("Deposito a Cuenta de Cheques", depositAmount));
				System.out.println("Operacion exitosa");
			}

		} else if (choice == 2) {
			System.out.println("Ingresa el monto a depositar en Tarjeta de Credito");
			System.out.println("Recuerda que puedes depositar con sentavos \n(Solo hasta dos decimales)");
			double depositAmount = leer.nextDouble();

			if (depositAmount <= 0) {
				System.out.println("Cantidad invalida, intenta de nuevo");
			} else {
				balance -= depositAmount;
				lastMovements.add(new Movements("Deposito a Tarjeta de Crédito", depositAmount));
				System.out.println("Operacion exitosa");
			}

		} else {
			System.out.println("Tipo de cuenta invalido");
		}
	}

	public double checkBalance() {
		System.out.println("Saldo disponible: $" + balance);
		return balance;
	}

	public void complaint() {
		System.out.println("No disponible, intente más tarde");
	}

	public void bankingTransactions() {
		if (lastMovements.isEmpty()) {
			System.out.println("Sin movimientos al momento");
		} else {
			for (Movements movimiento : lastMovements) {
				System.out.println("ID: " + movimiento.getId());
				System.out.println("Fecha: " + movimiento.getDate());
				System.out.println("Tipo: " + movimiento.getType());
				System.out.println("Monto: $" + movimiento.getAmount());
			}
		}
	}
}
