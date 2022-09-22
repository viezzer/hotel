package view;

import java.util.Scanner;
import model.Cliente;
import model.Funcionario;
import model.Quarto;

public class InterfaceDeUsuario {
	private Quarto[] quartos = new Quarto[100];
	private int numQuartos = 0;
	private Cliente[] clientes = new Cliente[100];
	private int numClientes = 0;
	private Funcionario[] funcionarios = new Funcionario[10];
	private int numFuncionarios = 0;
	private Scanner input = new Scanner(System.in);
	
	public int pegaOpcao() {
		System.out.println("0. Logout");
		System.out.println("1. Cadastrar Cliente");
		System.out.println("2. Cadastrar funcionário com acesso ao sistema");
		System.out.println("3. Cadastrar novo quarto");
		System.out.println("4. Consultar quartos disponíveis para reserva em um determinado período");
		System.out.println("5. Realizar reserva");
		System.out.println("6. Apresentar reservas registradas");
		System.out.println("7. Apresentar clientes cadastrados");
		System.out.println("8. Apresentar a receita prevista com as reservas registradas atualmente, por quarto");
		return input.nextInt();
	}
		
	public void menuPrincipal() {
		//Variaveis auxiliares
		Cliente cliente;
		Funcionario funcionario;
		Quarto quarto;
		String nome, cpf;
		int numero, capacidade, senha;
		double diaria;
		
		//Funcionario administrador = new Funcionario("ADMINISTRADOR", "99999999999", 123456);
		int opcao = this.pegaOpcao();
		while(opcao!=0) {
			switch(opcao) {
			case 1:
				//Cadastrar Cliente
				input.nextLine();
				System.out.println("Nome do cliente: ");
				nome = input.nextLine();
				System.out.println("CPF do cliente: ");
				cpf = input.nextLine();
				cliente = new Cliente(nome, cpf);
				clientes[numClientes++] = cliente;
				System.out.println("Cliente cadastrado.");
				break;
			case 2:
				//Cadastrar funcionário com acesso ao sistema
				input.nextLine();
				System.out.println("Digite o cpf do funcionário: ");
				cpf = input.nextLine();
				System.out.println("Digite o nome do funcionário: ");
				nome = input.nextLine();
				System.out.println("Digite uma senha para o funcionário:");
				senha = input.nextInt();
				funcionario = new Funcionario(nome, cpf, senha);
				funcionarios[numFuncionarios++] = funcionario;
				break;
			case 3:
				//Cadastrar novo quarto
				input.nextLine();
				System.out.println("Digite o numero do quarto: ");
				numero = input.nextInt();
				System.out.println("Digite a capacidade do quarto: ");
				capacidade = input.nextInt();
				System.out.println("Digite o valor da diária do quarto: ");
				diaria = input.nextDouble();
				quarto = new Quarto(numero, capacidade, diaria, false);
				quartos[numQuartos++] = quarto;
				break;
			case 4:
				//Consultar quartos disponíveis para reserva em um determinado período
				
				break;
			case 5:
				//Realizar reserva
				
				break;
			case 6:
				//Apresentar reservas registradas
				
				break;
			case 7:
				//Apresentar clientes cadastrados
				for(int i=0;i<numClientes;i++) {
					System.out.println(clientes[i].getNome());
				}
				break;
			case 8:
				//Apresentar a receita prevista com as reservas registradas atualmente, por quarto
				
				break;	
			}
			opcao = this.pegaOpcao();
		}
	}
}
		