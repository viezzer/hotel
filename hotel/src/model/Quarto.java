package model;

public class Quarto {
	private int numero;
	private int capacidade;
	private double diaria;

	public Quarto(int numero, int capacidade, double diaria) {
		super();
		this.numero = numero;
		this.capacidade = capacidade;
		this.diaria = diaria;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public double getDiaria() {
		return diaria;
	}
	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}
	
}
