package model;

public class Hotel {
	private Quarto[] quartos = new Quarto[100];
	private int numQuartos = 0;
	private Cliente[] clientes = new Cliente[100];
	private int numClientes = 0;
	private Funcionario[] funcionarios = new Funcionario[10];
	private int numFuncionarios = 0;
	private Reserva[] reservas = new Reserva[999];
	Funcionario administrador = new Funcionario("ADMINISTRADOR", "00000000", 123456);
}
