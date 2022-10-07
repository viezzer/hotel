package model;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Reserva {
	
	private Cliente cliente;
	private Quarto  quarto;
	private Calendar diaInicio, diaTermino;
	private Funcionario funcionario;
	

	public Reserva(Cliente cliente, Quarto quarto, Funcionario funcionario, Calendar diaInicio, Calendar diaTermino) {
		super();
		this.cliente = cliente;
		this.quarto = quarto;
		this.diaInicio = diaInicio;
		this.diaTermino = diaTermino;
		this.funcionario = funcionario;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Quarto getQuarto() {
		return quarto;
	}


	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}


	public Calendar getDiaInicio() {
		return diaInicio;
	}


	public void setDiaInicio(Calendar diaInicio) {
		this.diaInicio = diaInicio;
	}


	public Calendar getDiaTermino() {
		return diaTermino;
	}


	public void setDiaTermino(Calendar diaTermino) {
		this.diaTermino = diaTermino;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public boolean verificaDisponibilidade(Calendar d1, Calendar d2) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("d1"+sdf.format(d1.getTime()));
		System.out.println("d2"+sdf.format(d2.getTime()));
		if(((d1.after(this.diaInicio) && d1.before(this.diaTermino)) || (d2.after(this.diaInicio) && d2.before(this.diaTermino))) 
				|| (d1.before(this.diaInicio) && (d2.after(diaTermino)))) {
			return false;
		}
		return true;
	}
	public void mostrar() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Cliente: "+this.cliente.getNome());
		System.out.println("Quarto: "+this.quarto.getNumero());
		System.out.println("Funcionario responsavel: "+this.funcionario.getNome());
		System.out.println("Data inicio: "+sdf.format(this.diaInicio.getTime()));
		System.out.println("Data Termino: "+sdf.format(this.diaTermino.getTime()));
	}
	public double getValorReserva() {
		double valor = this.quarto.getDiaria() * ChronoUnit.DAYS.between(this.diaInicio.toInstant(), this.diaTermino.toInstant());
		return valor;
	}
}
