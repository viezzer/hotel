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

	public boolean autentica(int senha) {
		if(senha == this.senha) {
			System.out.println("Acesso permitido.");
			return true;
		} else {
			System.out.println("Acesso negado.");
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
