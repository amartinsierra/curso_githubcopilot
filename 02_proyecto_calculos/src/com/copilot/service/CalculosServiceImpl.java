package com.copilot.service;

import java.util.List;

public class CalculosServiceImpl implements CalculosService {

	@Override
	public int totalMayores(int n, List<Integer> numeros) {
		//deveulve la cantidad de números mayores que n en la lista
		//utilizando programación funcional
		return (int) numeros.stream().filter(numero -> numero > n).count();
	}

	@Override
	public List<Integer> numerosMenores(int n, List<Integer> numeros) {
		//devuelve una lista con los números menores que n en la lista
		//utilizando programación funcional
		return numeros.stream().filter(numero -> numero < n).toList();
	}

}
