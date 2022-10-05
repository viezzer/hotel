package model;

public class Funcionario {
	private String nome;
	private String cpf;
	private int senha;

	public Funcionario(String nome, String cpf, int senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public boolean autentica(String nome, int senha) {
		if(senha == this.senha && nome == this.nome) {
			//System.out.println("Acesso permitido.");
			return true;
		} else {
			//System.out.println("Acesso negado.");
			return false;
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
}
