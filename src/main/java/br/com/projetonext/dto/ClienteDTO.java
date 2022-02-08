package br.com.projetonext.dto;

public class ClienteDTO {
	private String cpf;
	private String senha;
	
	public ClienteDTO() {}
	
	public ClienteDTO(String cpf, String senha) {
		super();
		this.cpf = cpf;
		this.senha = senha;
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
	
	
}
