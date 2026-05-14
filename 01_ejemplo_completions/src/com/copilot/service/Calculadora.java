package com.copilot.service;

public class Calculadora {
		public int sumar(int a, int b) {
		return a + b;
	}

	public int restar(int a, int b) {
		return a - b;
	}

	public int multiplicar(int a, int b) {
		return a * b;
	}

	public double dividir(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("No se puede dividir por cero");
		}
		return (double) a / b;
	}
	
	public double factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("No se puede calcular el factorial de un número negativo");
		}
		double resultado = 1;
		for (int i = 1; i <= n; i++) {
			resultado *= i;
		}
		return resultado;
	}
	//Crea un método que reciba un número variable de argumentos y devuelva la suma de todos ellos.
	public int sumarVarios(int... numeros) {
		int resultado = 0;
		for (int numero : numeros) {
			resultado += numero;
		}
		return resultado;
	}
	
}
