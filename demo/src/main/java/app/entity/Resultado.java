package app.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int soma;
	private double media;
	private int maior;
	private int menor;
	private int totalElementos;
	private long multiplicacao;

	@ElementCollection
	private List<Integer> moda;
	private double mediana;


	public Resultado() {
	}

	public Resultado(long id, int soma, double media, int maior, int menor, int totalElementos, long multiplicacao, List<Integer> moda, double mediana) {
		this.id = id;
		this.soma = soma;
		this.media = media;
		this.maior = maior;
		this.menor = menor;
		this.totalElementos = totalElementos;
		this.multiplicacao = multiplicacao;
		this.moda = moda;
		this.mediana = mediana;
	}

	// Getters e Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSoma() {
		return soma;
	}

	public void setSoma(int soma) {
		this.soma = soma;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public int getMaior() {
		return maior;
	}

	public void setMaior(int maior) {
		this.maior = maior;
	}

	public int getMenor() {
		return menor;
	}

	public void setMenor(int menor) {
		this.menor = menor;
	}

	public int getTotalElementos() {
		return totalElementos;
	}

	public void setTotalElementos(int totalElementos) {
		this.totalElementos = totalElementos;
	}

	public long getMultiplicacao() {
		return multiplicacao;
	}

	public void setMultiplicacao(long multiplicacao) {
		this.multiplicacao = multiplicacao;
	}

	public List<Integer> getModa() {
		return moda;
	}

	public void setModa(List<Integer> moda) {
		this.moda = moda;
	}

	public double getMediana() {
		return mediana;
	}

	public void setMediana(double mediana) {
		this.mediana = mediana;
	}
}
