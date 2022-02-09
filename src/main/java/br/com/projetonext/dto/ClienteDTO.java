package br.com.projetonext.dto;

public class ClienteDTO {
	private String cpf;
	private String senha;
	private String nome;
	
	public ClienteDTO() {}
	
	public ClienteDTO(String cpf, String senha, String nome) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
