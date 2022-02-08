package br.com.projetonext.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetonext.bean.Cliente;
import br.com.projetonext.repository.ClienteRepository;

@Service
public class ClienteBO {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	
	public ClienteBO(ClienteRepository clienteRepo) {
		this.clienteRepo = clienteRepo;
	}
	
	public boolean inserirCliente(Cliente cli) {
		try {
			this.clienteRepo.save(cli);
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}
}
