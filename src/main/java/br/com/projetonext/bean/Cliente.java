package br.com.projetonext.bean;

import java.util.Date;

import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@ManagedBean
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="cliente_id_usuario_seq")
	@SequenceGenerator(name="cliente_id_usuario_seq", sequenceName = "cliente_id_usuario_seq", allocationSize = 1)
	@Column(name="id_cliente")
	private Integer idCliente;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="data_nascimento")
	private Date data;
	
	private String dataString;
	
	public Cliente() {
		super();
	}
	public Cliente(String nome, String senha, String cpf, Date data, String dataString) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.data = data;
		this.dataString = dataString;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDataString() {
		return dataString;
	}
	public void setDataString(String dataString) {
		this.dataString = dataString;
	}
}
