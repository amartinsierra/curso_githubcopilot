package com.copilot.service;

import java.util.List;

public interface CalculosService {
	int totalMayores(int n, List<Integer> numeros);
	List<Integer> numerosMenores(int n, List<Integer> numeros);
}
