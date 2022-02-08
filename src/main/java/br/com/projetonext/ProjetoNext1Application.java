package br.com.projetonext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.projetonext.repository.ClienteRepository;

@SpringBootApplication
public class ProjetoNext1Application {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoNext1Application.class, args);
	}
}
