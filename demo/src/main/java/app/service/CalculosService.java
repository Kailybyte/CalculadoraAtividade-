package app.service;

import java.util.*;
import java.util.stream.Collectors;

import app.repositoy.CalculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Resultado;

@Service
public class CalculosService {

	@Autowired
	private CalculosRepository calculosRepository;


	public List<Resultado> findAll(){
		return this.calculosRepository.findAll();
	}

	public Resultado calcular(Entrada entrada) {

		Resultado resultado = new Resultado();
		List<Integer> lista = entrada.getLista();

		int soma = this.somar(lista);
		System.out.println("A soma deu " + soma);
		resultado.setSoma(soma);

		double media = this.media(lista);
		resultado.setMedia(media);

		int maior = this.maiorNumero(lista);
		resultado.setMaior(maior);

		int menor = this.menorNumero(lista);
		resultado.setMenor(menor);

		int totalElementos = this.totalElementos(lista);
		resultado.setTotalElementos(totalElementos);

		long multiplicacao = this.multiplicar(lista);
		resultado.setMultiplicacao(multiplicacao);

		List<Integer> moda = this.moda(lista);
		resultado.setModa(moda);

		double mediana = this.mediana(lista);
		resultado.setMediana(mediana);

		resultado = this.calculosRepository.save(resultado);

		return resultado;

	}

	public int somar(List<Integer> lista) {
		return lista.stream().mapToInt(Integer::intValue).sum();
	}

	public double media(List<Integer> lista) {
		return (double) this.somar(lista) / lista.size();
	}

	public int maiorNumero(List<Integer> lista) {
		return Collections.max(lista);
	}

	public int menorNumero(List<Integer> lista) {
		return Collections.min(lista);
	}

	public int totalElementos(List<Integer> lista) {
		return lista.size();
	}

	public long multiplicar(List<Integer> lista) {
		return lista.stream().reduce(1, (a, b) -> a * b);
	}

	public List<Integer> moda(List<Integer> lista) {
		Map<Integer, Long> frequencias = lista.stream()
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		long maxFrequencia = Collections.max(frequencias.values());
		return frequencias.entrySet().stream()
				.filter(e -> e.getValue() == maxFrequencia)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}

	public double mediana(List<Integer> lista) {
		List<Integer> listaOrdenada = new ArrayList<>(lista);
		Collections.sort(listaOrdenada);
		int tamanho = listaOrdenada.size();
		if (tamanho % 2 == 0) {
			return (listaOrdenada.get(tamanho / 2 - 1) + listaOrdenada.get(tamanho / 2)) / 2.0;
		} else {
			return listaOrdenada.get(tamanho / 2);
		}
	}
}
