package view;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.Cliente;
import model.Funcionario;
import model.Quarto;
import model.Reserva;

public class InterfaceDeUsuario {
	private Quarto[] quartos = new Quarto[100];
	private int numQuartos = 0;
	private Cliente[] clientes = new Cliente[100];
	private int numClientes = 0;
	private Funcionario sessionUser = new Funcionario();
	private Funcionario[] funcionarios = new Funcionario[10];
	private int numFuncionarios = 0;
	private Reserva[] reservas = new Reserva[100];
	private int numReservas = 0;
	private Scanner input = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//Variaveis auxiliares
	Cliente cliente;
	Funcionario funcionario;
	Quarto quarto;
	Reserva reserva;		
	Calendar auxDataIni, auxDataFim;
	String nome, cpf;
	int numero, capacidade, senha, iDia, iMes, iAno, fDia, fMes, fAno;
	double diaria, montanteReservas;
	
	public boolean efetuarLogin() {
		System.out.println("USUARIO: ");
		nome = input.nextLine();
		System.out.println("SENHA: ");
		senha = input.nextInt();
		input.nextLine();
		if(nome.equals("ADMINISTRADOR") && senha==123456) {
			sessionUser.setNome(nome);
			sessionUser.setSenha(senha);
			return true;
		} else if(numFuncionarios>0) {
			for(int i=0;i<numFuncionarios; i++) {
				if(funcionarios[i].autentica(nome, senha)) {
					sessionUser.setNome(nome);
					sessionUser.setSenha(senha);
					return true;
				}
			}
		}
		return false;
	}
	
	public int pegaOpcao() {
		System.out.println("0. Logout");
		System.out.println("1. Cadastrar Cliente");
		System.out.println("2. Cadastrar funcion�rio com acesso ao sistema");
		System.out.println("3. Cadastrar novo quarto");
		System.out.println("4. Consultar quartos dispon�veis para reserva em um determinado per�odo");
		System.out.println("5. Realizar reserva");
		System.out.println("6. Apresentar reservas registradas");
		System.out.println("7. Apresentar clientes cadastrados");
		System.out.println("8. Apresentar a receita prevista com as reservas registradas atualmente, por quarto");
		return input.nextInt();
	}
		
	public void cadastrarCliente() {
		//Cadastrar Cliente
		input.nextLine();
		System.out.println("Nome do cliente: ");
		nome = input.nextLine();
		System.out.println("CPF do cliente: ");
		cpf = input.nextLine();
		cliente = new Cliente(nome, cpf);
		clientes[numClientes++] = cliente;
		System.out.println("Cliente cadastrado.");
	}
	
	public void cadastrarFuncionario() {
		//Cadastrar funcion�rio com acesso ao sistema
		input.nextLine();
		System.out.println("Digite o cpf do funcion�rio: ");
		cpf = input.nextLine();
		System.out.println("Digite o nome do funcion�rio: ");
		nome = input.nextLine();
		System.out.println("Digite uma senha para o funcion�rio:");
		senha = input.nextInt();
		funcionario = new Funcionario(nome, cpf, senha);
		funcionarios[numFuncionarios++] = funcionario;
	}
	
	public void cadastrarQuarto() {
		//Cadastrar novo quarto
		input.nextLine();
		System.out.println("Digite o numero do quarto: ");
		numero = input.nextInt();
		System.out.println("Digite a capacidade do quarto: ");
		capacidade = input.nextInt();
		System.out.println("Digite o valor da di�ria do quarto: ");
		diaria = input.nextDouble();
		quarto = new Quarto(numero, capacidade, diaria);
		quartos[numQuartos++] = quarto;
	}
	
	public void consultarQuartosDisponiveisParaReserva() {
		//Consultar quartos dispon�veis para reserva em um determinado per�odo
		System.out.println("Digite a data inicial da reserva:");
		System.out.println("DIA:");
		iDia = input.nextInt();
		System.out.println("MES:");
		iMes = input.nextInt();
		System.out.println("ANO:");
		iAno = input.nextInt();
		//auxDataIni = new GregorianCalendar(iDia, iMes-1, iAno);
		auxDataIni = new GregorianCalendar(iAno, iMes-1, iDia);
		System.out.println("Digite a data final da reserva:");
		System.out.println("DIA:");
		fDia = input.nextInt();
		System.out.println("MES:");
		fMes = input.nextInt();
		System.out.println("ANO:");
		fAno = input.nextInt();
		//auxDataFim = new GregorianCalendar(fDia, fMes-1, fAno);
		auxDataFim = new GregorianCalendar(fAno, fMes-1, fDia);
		System.out.println(sdf.format(auxDataIni.getTime()));
		//System.out.println(sdf.format(auxDataIni2.getTime()));
		System.out.println(sdf.format(auxDataFim.getTime()));
		for(int i=0;i<numQuartos;i++) {
			boolean disponivel = true;
			for(int j=0;j<numReservas;j++) {
				if(reservas[j].getQuarto().getNumero()==quartos[i].getNumero()) {
					if(reservas[j].verificaDisponibilidade(auxDataIni, auxDataFim)) {
						disponivel = true;
					} else {
						disponivel = false;
						break;
					}
				}
			}
			if(disponivel) {
				System.out.println("Quarto "+quartos[i].getNumero()+" disponivel");
			}
		}
	}
	
	public void realizarReserva() {
		//Realizar reserva ARRUMAR
		cliente = null;
		quarto = null;
		System.out.println("Cpf do Cliente: ");
		input.nextLine();
		cpf = input.nextLine();
		for(int i=0; i<numClientes; i++) {
			if(clientes[i].getCpf().equals(cpf)) {
				
				cliente = clientes[i];
				System.out.println("Cliente Encontrado");
				break;
			}
		}
		if(cliente==null) {
			return;
		}
		System.out.println("Numero do Quarto: ");
		numero = input.nextInt();
		for(int i=0; i<numQuartos; i++) {
			if(quartos[i].getNumero()==numero) {
				quarto = quartos[i];
				System.out.println("Quarto Encontrado");
				break;
			}
		}
		System.out.println("DATA INICIAL DA RESERVA: ");
		System.out.println("DIA: ");
		iDia = input.nextInt();
		System.out.println("MES: ");
		iMes = input.nextInt();
		System.out.println("ANO: ");
		iAno = input.nextInt();
		auxDataIni = new GregorianCalendar(iAno, iMes-1, iDia);
		System.out.println("DATA FINAL DA RESERVA: ");
		System.out.println("DIA: ");
		fDia = input.nextInt();
		System.out.println("MES: ");
		fMes = input.nextInt();
		System.out.println("ANO: ");
		fAno = input.nextInt();
		auxDataFim = new GregorianCalendar(fAno, fMes-1, fDia);
		reserva = new Reserva(cliente, quarto, sessionUser, auxDataIni, auxDataFim);
		reservas[numReservas++] = reserva;
	}
	
	public void apresentarReservas() {
		System.out.println("Reservas: ");
		for(int i=0;i<numReservas;i++) {
			reservas[i].mostrar();
		}
	}
	
	public void listarClientes() {
		for(int i=0;i<numClientes;i++) {
			System.out.println("Cliente "+i+" "+clientes[i].getNome());
		}
	}
	
	public void apresentarReceitaPrevistaDasReservas() {
		montanteReservas = 0;
		for(int i=0;i<numReservas;i++) {
			montanteReservas += reservas[i].getValorReserva();
		}
		System.out.println("Montante: "+ montanteReservas);
	}
	
	public void menuPrincipal() {
		int opcao = this.pegaOpcao();
		while(opcao!=0) {
			switch(opcao) {
			case 1:
				this.cadastrarCliente();
				break;
			case 2:
				this.cadastrarFuncionario();
				break;
			case 3:
				this.cadastrarQuarto();
				break;
			case 4:
				this.consultarQuartosDisponiveisParaReserva();
				break;
			case 5:
				this.realizarReserva();
				break;
			case 6:
				//Apresentar reservas registradas 
				this.apresentarReservas();
				break;
			case 7:
				//Apresentar clientes cadastrados
				this.listarClientes();
				break;
			case 8:
				//Apresentar a receita prevista com as reservas registradas atualmente, por quarto
				this.apresentarReceitaPrevistaDasReservas();
				break;	
			}
			opcao = this.pegaOpcao();
		}
		input.nextLine();
	}
}
		