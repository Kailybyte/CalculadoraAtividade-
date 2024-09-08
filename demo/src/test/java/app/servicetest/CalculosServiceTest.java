package app.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import app.repositoy.CalculosRepository;
import app.service.CalculosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CalculosServiceTest {

	@InjectMocks
	private CalculosService calculosService;

	@Mock
	private CalculosRepository calculosRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	// Testes para maiorNumero
	@Test
	@DisplayName("Maior número - cenário 1")
	void testMaiorNumeroCenario1() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
		int maior = calculosService.maiorNumero(numeros);
		assertEquals(5, maior, "O maior número está incorreto");
	}

	@Test
	@DisplayName("Maior número - cenário 2")
	void testMaiorNumeroCenario2() {
		List<Integer> numeros = Arrays.asList(-10, -20, -5, -1);
		int maior = calculosService.maiorNumero(numeros);
		assertEquals(-1, maior, "O maior número está incorreto");
	}

	@Test
	@DisplayName("Maior número - cenário 3")
	void testMaiorNumeroCenario3() {
		List<Integer> numeros = Arrays.asList(100, 50, 25);
		int maior = calculosService.maiorNumero(numeros);
		assertEquals(100, maior, "O maior número está incorreto");
	}

	// Testes para menorNumero
	@Test
	@DisplayName("Menor número - cenário 1")
	void testMenorNumeroCenario1() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
		int menor = calculosService.menorNumero(numeros);
		assertEquals(1, menor, "O menor número está incorreto");
	}

	@Test
	@DisplayName("Menor número - cenário 2")
	void testMenorNumeroCenario2() {
		List<Integer> numeros = Arrays.asList(-10, -20, -5, -1);
		int menor = calculosService.menorNumero(numeros);
		assertEquals(-20, menor, "O menor número está incorreto");
	}

	@Test
	@DisplayName("Menor número - cenário 3")
	void testMenorNumeroCenario3() {
		List<Integer> numeros = Arrays.asList(100, 50, 25);
		int menor = calculosService.menorNumero(numeros);
		assertEquals(25, menor, "O menor número está incorreto");
	}

	// Testes para totalElementos
	@Test
	@DisplayName("Total de elementos - cenário 1")
	void testTotalElementosCenario1() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
		int total = calculosService.totalElementos(numeros);
		assertEquals(5, total, "O total de elementos está incorreto");
	}

	@Test
	@DisplayName("Total de elementos - cenário 2")
	void testTotalElementosCenario2() {
		List<Integer> numeros = Arrays.asList(10, 20, 30);
		int total = calculosService.totalElementos(numeros);
		assertEquals(3, total, "O total de elementos está incorreto");
	}

	@Test
	@DisplayName("Total de elementos - cenário 3")
	void testTotalElementosCenario3() {
		List<Integer> numeros = Arrays.asList(100);
		int total = calculosService.totalElementos(numeros);
		assertEquals(1, total, "O total de elementos está incorreto");
	}

	// Testes para multiplicar
	@Test
	@DisplayName("Multiplicar - cenário 1")
	void testMultiplicarCenario1() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
		long multiplicacao = calculosService.multiplicar(numeros);
		assertEquals(24, multiplicacao, "O resultado da multiplicação está incorreto");
	}

	@Test
	@DisplayName("Multiplicar - cenário 2")
	void testMultiplicarCenario2() {
		List<Integer> numeros = Arrays.asList(5, 5, 5);
		long multiplicacao = calculosService.multiplicar(numeros);
		assertEquals(125, multiplicacao, "O resultado da multiplicação está incorreto");
	}

	@Test
	@DisplayName("Multiplicar - cenário 3")
	void testMultiplicarCenario3() {
		List<Integer> numeros = Arrays.asList(2, 2, 2, 2);
		long multiplicacao = calculosService.multiplicar(numeros);
		assertEquals(16, multiplicacao, "O resultado da multiplicação está incorreto");
	}

	// Testes para moda
	@Test
	@DisplayName("Moda - cenário 1")
	void testModaCenario1() {
		List<Integer> numeros = Arrays.asList(1, 2, 2, 3, 4);
		List<Integer> moda = calculosService.moda(numeros);
		assertEquals(Arrays.asList(2), moda, "A moda está incorreta");
	}

	@Test
	@DisplayName("Moda - cenário 2")
	void testModaCenario2() {
		List<Integer> numeros = Arrays.asList(5, 5, 6, 6);
		List<Integer> moda = calculosService.moda(numeros);
		assertEquals(Arrays.asList(5, 6), moda, "A moda está incorreta");
	}

	@Test
	@DisplayName("Moda - cenário 3")
	void testModaCenario3() {
		List<Integer> numeros = Arrays.asList(7, 7, 7, 1, 1, 1, 1);
		List<Integer> moda = calculosService.moda(numeros);
		assertEquals(Arrays.asList(1), moda, "A moda está incorreta");
	}

	// Testes para mediana
	@Test
	@DisplayName("Mediana - cenário 1")
	void testMedianaCenario1() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
		double mediana = calculosService.mediana(numeros);
		assertEquals(3.0, mediana, 0.01, "A mediana está incorreta");
	}

	@Test
	@DisplayName("Mediana - cenário 2")
	void testMedianaCenario2() {
		List<Integer> numeros = Arrays.asList(10, 20, 30, 40);
		double mediana = calculosService.mediana(numeros);
		assertEquals(25.0, mediana, 0.01, "A mediana está incorreta");
	}

	@Test
	@DisplayName("Mediana - cenário 3")
	void testMedianaCenario3() {
		List<Integer> numeros = Arrays.asList(3, 1, 2, 5, 4);
		double mediana = calculosService.mediana(numeros);
		assertEquals(3.0, mediana, 0.01, "A mediana está incorreta");
	}
}
