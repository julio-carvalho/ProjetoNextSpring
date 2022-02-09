package br.com.projetonext.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.projetonext.bean.Cliente;
import br.com.projetonext.bo.ClienteBO;
import br.com.projetonext.dto.ClienteDTO;
import br.com.projetonext.repository.ClienteRepository;

@Controller
@RequestMapping("/")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	private ClienteDTO cliDTO;

	@GetMapping	
	public String getIndex(Model model) {
		ClienteDTO cliDTO = new ClienteDTO();
		model.addAttribute("clienteDTO", cliDTO);
		return "index";
	}
	
	@GetMapping("cadastro")
	public String getCadastro(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		
		return "cadastro";
	}
	
	@PostMapping("cadastrar")
	public String insertCliente(Cliente cliente) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			cliente.setData(sdf.parse(cliente.getDataString()));
		} catch (ParseException e) {}
		
		ClienteBO cliBO = this.getClienteBO();
		cliBO.inserirCliente(cliente);
		
		return "redirect:/?inseriu=true";
	}
	
	
	public ClienteBO getClienteBO() {
		return new ClienteBO(this.clienteRepo);
	}
	
	@PostMapping("login")
	public String login(ClienteDTO clienteDTO, ModelMap model) {
		Cliente cli = clienteRepo.findByCpfAndSenha(clienteDTO.getCpf(), clienteDTO.getSenha());
		
		if(cli == null) {
			return "redirect:/?logininvalido";
		}
		
		clienteDTO.setNome(cli.getNome());
		cliDTO = clienteDTO;
		
		return "redirect:/home";
	}
	
	@GetMapping("extrato")
	public String getExtrato() {
		return "extrato";
	}
	
	@GetMapping("home")
	public String getHome(ModelMap model) {
		Cliente cliente = clienteRepo.findByNome(cliDTO.getNome());
		model.addAttribute("clientes", cliente.getNome());
		return "home";
	}
			
	public Cliente buscaNome() {
		Cliente cliente = clienteRepo.findByNome(cliDTO.getNome());
		
		return cliente;
	}
	
}
